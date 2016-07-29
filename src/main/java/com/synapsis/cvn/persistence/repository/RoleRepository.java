package com.synapsis.cvn.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.synapsis.cvn.persistence.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}
