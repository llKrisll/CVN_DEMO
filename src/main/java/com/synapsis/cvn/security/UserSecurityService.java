package com.synapsis.cvn.security;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.synapsis.cvn.persistence.entity.PasswordResetToken;
import com.synapsis.cvn.persistence.entity.User;
import com.synapsis.cvn.persistence.repository.PasswordResetTokenRepository;

@Service
@Transactional
public class UserSecurityService implements ISecurityUserService {

    @Autowired
    private PasswordResetTokenRepository passwordTokenRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    // API

    @Override
    public String validatePasswordResetToken(long id, String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
        if ((passToken == null) || (passToken.getUser().getId() != id)) {
            return "invalidToken";
        }

        final Calendar cal = Calendar.getInstance();
        if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            return "expired";
        }

        final User user = passToken.getUser();
        final Authentication auth = new UsernamePasswordAuthenticationToken(user, null, userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
        return null;
    }

}