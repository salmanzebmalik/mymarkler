package de.unims.acse2024.mymakler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.data.repo.UserRepository;
import de.unims.acse2024.mymakler.service.exception.ConfirmationFailed;
import de.unims.acse2024.mymakler.service.exception.PasswordNotLongEnough;
import de.unims.acse2024.mymakler.service.exception.UsernameTaken;

@Service
public class StdUserService implements UserService {
  private static final int MIN_PASSWORD_SIZE = 3;

  @Autowired
  private AttributeService attributeService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  private static boolean isValidPassword(String password) {
    return password != null && password.length() >= MIN_PASSWORD_SIZE;
  }

  @Override
  public MaklerUser loadUserByUsername(String username) throws UsernameNotFoundException {
    MaklerUser result = userRepository.findByUsername(username);
    if (result == null) {
      throw new UsernameNotFoundException(String.format("User with name %s cannot be found.", username));
    }
    return result;
  }

  @Override
  public void login(MaklerUser user) {
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    SecurityContextHolder.getContext().setAuthentication(token);
  }

  @Override
  public MaklerUser create(MaklerUser user) throws UsernameTaken, PasswordNotLongEnough {
    if (userRepository.existsByUsername(user.getUsername())) {
      throw new UsernameTaken(String.format("The given username %s is already taken.", user.getUsername()));
    }

    if (isValidPassword(user.getPlaintextPassword())) {
      replacePlaintextPassword(user);
    } else {
      throw new PasswordNotLongEnough();
    }

    user.setAttributes(new HashSet<>(attributeService.createOrGet(user.getAttributes())));

    return userRepository.save(user);
  }

  @Override
  public MaklerUser update(MaklerUser userUpdate, String confirmationPassword) throws PasswordNotLongEnough, ConfirmationFailed {
    // We must update the old version by setting its values according to 'userUpdate'
    MaklerUser oldVersion = userRepository.getOne(userUpdate.getId());

    if (!passwordEncoder.matches(confirmationPassword, oldVersion.getPassword())) {
      throw new ConfirmationFailed();
    }

    if (userUpdate.getPlaintextPassword() != null && !userUpdate.getPlaintextPassword().isEmpty()) {
      if (isValidPassword(userUpdate.getPlaintextPassword())) {
        replacePlaintextPassword(userUpdate);
        oldVersion.setPassword(userUpdate.getPassword());
      } else {
        throw new PasswordNotLongEnough();
      }
    }

    oldVersion.setEmail(userUpdate.getEmail());
    oldVersion.setCityOfOrigin(userUpdate.getCityOfOrigin());

    userUpdate.setAttributes(new HashSet<>(attributeService.createOrGet(userUpdate.getAttributes())));

    oldVersion.setAttributes(userUpdate.getAttributes());
    return userRepository.save(oldVersion);
  }

  private void replacePlaintextPassword(MaklerUser userWithPlaintextPassword) {
    String result = passwordEncoder.encode(userWithPlaintextPassword.getPlaintextPassword());
    userWithPlaintextPassword.setPlaintextPassword(null);
    userWithPlaintextPassword.setPassword(result);
  }

  @Override
  public MaklerUser getUser(long id) {
    return userRepository.getOne(id);
  }
}
