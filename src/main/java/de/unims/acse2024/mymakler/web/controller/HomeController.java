package de.unims.acse2024.mymakler.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.unims.acse2024.mymakler.data.model.MaklerUser;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  public String index(@AuthenticationPrincipal MaklerUser currentUser, Model model) {
    if (currentUser == null) {
      // There is no AuthenticationPrincipal, i.e., the user must log in.
      return "users/login";
    }
    // By using the special "redirect:"-prefix, we redirect to this page.
    return "redirect:/users/profile";
  }

  @GetMapping("overview")
  public String overview(@AuthenticationPrincipal MaklerUser currentUser) {
    switch (currentUser.getRole()) {
      case LANDLORD:
        return "redirect:/viewing-requests";
      case TENANT:
        return "redirect:/viewing-offers";
      default:
        throw new IllegalStateException("unknown user role");
    }
  }
}
