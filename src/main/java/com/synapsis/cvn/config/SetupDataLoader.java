package com.synapsis.cvn.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.synapsis.cvn.persistence.entity.Privilege;
import com.synapsis.cvn.persistence.entity.Role;
import com.synapsis.cvn.persistence.entity.User;
import com.synapsis.cvn.persistence.repository.PrivilegeRepository;
import com.synapsis.cvn.persistence.repository.RoleRepository;
import com.synapsis.cvn.persistence.repository.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

        final Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        
        User user=userRepository.findByEmail("test@test.com");
        
        if (user==null) {
        	user = new User();
            user.setFirstName("Test");
            user.setLastName("Test");
            user.setPassword(passwordEncoder.encode("test"));
            user.setEmail("test@test.com");
            user.setRoles(Arrays.asList(adminRole));
            user.setEnabled(true);
            userRepository.save(user);
		}
        
        final Role userRole = roleRepository.findByName("ROLE_USER");
        
        User user2=userRepository.findByEmail("test2@test2.com");
        
        if (user2==null) {
        	 user2 = new User();
             user2.setFirstName("Test2");
             user2.setLastName("Test2");
             user2.setPassword(passwordEncoder.encode("test2"));
             user2.setEmail("test2@test2.com");
             user2.setRoles(Arrays.asList(userRole));
             user2.setEnabled(true);
             userRepository.save(user2);
		}
       

        alreadySetup = true;
    }

    @Transactional
    private final Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}