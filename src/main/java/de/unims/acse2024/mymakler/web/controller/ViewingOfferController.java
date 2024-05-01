package de.unims.acse2024.mymakler.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.web.controller.dto.ViewingOfferDto;
import de.unims.acse2024.mymakler.web.controller.dto.ViewingRequestDto;

@Controller
@RequestMapping("/viewing-offers")
public class ViewingOfferController {
  @GetMapping()
  public String index(@AuthenticationPrincipal MaklerUser currentUser, Model model) {
    // TODO: implement controller logic to retrieve relevant viewing offers
    return "viewing-offers/index";
  }

  @GetMapping("/{id}")
  public String details(@AuthenticationPrincipal MaklerUser currentUser, @PathVariable("id") long id, Model model) {
    // TODO: implement controller logic to retrieve viewing offer with given id
    // TODO: users should not be able to send a second request
    // TODO: handle case where id does not exist
    return "viewing-offers/details";
  }

  @PostMapping("/apply")
  public String apply(Model model, @AuthenticationPrincipal MaklerUser currentUser, @Valid @ModelAttribute("request") ViewingRequestDto viewingRequest, BindingResult result) {
    // TODO: implement controller logic for applying to a viewing request
    // TODO: landlords should not be able to apply
    // TODO: handle (validation) errors and show them in the viewing-offers/details template
    // TODO: redirect to index page with a successful message
    return "redirect:/viewing-offers?successfulRequest";
  }

  @GetMapping("/new")
  public String create(@AuthenticationPrincipal MaklerUser currentUser, Model model) {
    // TODO: implement controller logic for creating a new viewing offering
    // TODO: tenants should not be able to create a viewing offering
    return "viewing-offers/new";
  }

  @PostMapping("/create")
  public String create(@AuthenticationPrincipal MaklerUser currentUser, @ModelAttribute("offer") @Valid ViewingOfferDto viewingOfferDto, BindingResult result) {
    // TODO: implement controller logic for creating a new viewing offering
    // TODO: handle (validation) errors and show them in the viewing-offers/new template
    // TODO: redirect to overview page
    return "redirect:/overview";
  }
}
