package de.unims.acse2024.mymakler.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import de.unims.acse2024.mymakler.data.model.MaklerUser;

//**Can** be used to retrieve a logged-in, authenticated User. This class is implemented separately from UserService to
// reuse it in services which need to retrieve the current User but do not need typical User-services.
@Service
public class StdActiveUserService implements ActiveUserService {
  /**
   * Returns the logged-in user or null, if currently not logged in
   */
  public MaklerUser getActiveUser() {
    Object result = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return result instanceof MaklerUser
        ? (MaklerUser) result
        : null;
  }
}
