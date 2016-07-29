package com.synapsis.cvn.services.interfaces;

import com.synapsis.cvn.exception.UserAlreadyExistException;
import com.synapsis.cvn.persistence.entity.PasswordResetToken;
import com.synapsis.cvn.persistence.entity.User;
import com.synapsis.cvn.persistence.entity.VerificationToken;
import com.synapsis.cvn.web.dto.UserDto;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    User getUserByPasswordResetToken(String token);

    User getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

}
