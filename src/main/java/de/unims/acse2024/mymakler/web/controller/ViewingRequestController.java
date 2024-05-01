package de.unims.acse2024.mymakler.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import de.unims.acse2024.mymakler.data.model.MaklerUser;

@Controller
@RequestMapping("/viewing-requests")
public class ViewingRequestController {
  @GetMapping()
  public String index(@AuthenticationPrincipal MaklerUser currentUser, Model model) {
    // TODO: implement controller logic to retrieve relevant viewing requests
    return "viewing-requests/index";
  }

  @PostMapping("/accept")
  public String accept(Model model, @AuthenticationPrincipal MaklerUser currentUser, String offeringUserRemarks, long requestId) {
    // TODO: implement controller logic for accepting a viewing request
    // NOTE: offeringUserRemarks is the comment from the landlord; requestId is the viewing request to accept
    return "redirect:/viewing-requests?accepted";
  }

  @PostMapping("/decline")
  public String decline(long requestId, @AuthenticationPrincipal MaklerUser currentUser) {
    // TODO: implement controller logic for declining a viewing request
    // requestId is the viewing request to decline
    return "redirect:/viewing-requests?declined";
  }
}
