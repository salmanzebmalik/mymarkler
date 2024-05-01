package de.unims.acse2024.mymakler.web.controller.dto;

import java.io.Serializable;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import de.unims.acse2024.mymakler.data.model.Attribute;
import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.data.model.Role;

public class UserDto implements Serializable {
  private static final long serialVersionUID = 15962998226472476L;

  @NotBlank
  private String username;

  private String plaintextPassword;

  @NotBlank
  private String role;

  @Pattern(regexp = "[a-zA-Z, ]+")
  private String attributes;

  private String confirmationPassword;

  @NotBlank
  private String cityOfOrigin;

  @NotBlank
  @Email
  private String email;

  public UserDto() {}

  public UserDto(MaklerUser user) {
    this.cityOfOrigin = user.getCityOfOrigin();
    this.email = user.getEmail();
    this.username = user.getUsername();
    this.role = user.getRole() == Role.LANDLORD ? "Landlord" : "Tenant";
    this.attributes = Utility.attributesToString(user.getAttributes());
  }

  public MaklerUser toUser() {
    MaklerUser result = new MaklerUser();
    result.setUsername(username);
    result.setPlaintextPassword(plaintextPassword);
    if (role != null) {
      result.setRole(Role.of(role));
    }
    result.setAttributes(Attribute.of(attributes.replaceAll(" ", "").split(",")));
    result.setCityOfOrigin(cityOfOrigin);
    result.setEmail(email);
    return result;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPlaintextPassword() {
    return plaintextPassword;
  }

  public void setPlaintextPassword(String plaintextPassword) {
    this.plaintextPassword = plaintextPassword;
  }

  public String getConfirmationPassword() {
    return confirmationPassword;
  }

  public void setConfirmationPassword(String confirmationPassword) {
    this.confirmationPassword = confirmationPassword;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getAttributes() {
    return attributes;
  }

  public void setAttributes(String attributes) {
    this.attributes = attributes;
  }

  public String getCityOfOrigin() {
    return cityOfOrigin;
  }

  public void setCityOfOrigin(String cityOfOrigin) {
    this.cityOfOrigin = cityOfOrigin;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
