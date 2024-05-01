package de.unims.acse2024.mymakler.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.unims.acse2024.mymakler.data.model.MaklerUser;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
  @GetMapping()
  public String index(@AuthenticationPrincipal MaklerUser currentUser, Model model) {
    // TODO: implement logic to retrieve relevant appointments
    return "appointments/index";
  }
}
