package de.unims.acse2024.mymakler.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.service.exception.ConfirmationFailed;
import de.unims.acse2024.mymakler.service.exception.PasswordNotLongEnough;
import de.unims.acse2024.mymakler.service.exception.UsernameTaken;

public interface UserService extends UserDetailsService {
  void login(MaklerUser user);

  MaklerUser create(MaklerUser user) throws UsernameTaken, PasswordNotLongEnough;

  MaklerUser update(MaklerUser user, String confirmationPassword) throws PasswordNotLongEnough, ConfirmationFailed;

  MaklerUser getUser(long id);
}
