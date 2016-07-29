package com.synapsis.cvn.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
