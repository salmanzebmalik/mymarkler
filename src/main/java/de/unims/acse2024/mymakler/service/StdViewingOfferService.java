package de.unims.acse2024.mymakler.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import de.unims.acse2024.mymakler.data.model.ViewingOffer;
import de.unims.acse2024.mymakler.service.exception.ViewingOfferDateInPast;

@Service
public class StdViewingOfferService implements ViewingOfferService {
  @Override
  public ViewingOffer create(long offeringUserId, ViewingOffer viewingOffer) throws ViewingOfferDateInPast {
    // TODO: implement business logic to create a viewing offer
    // TODO: validate that the viewing date is not in the past
    return null;
  }

  @Override
  public ViewingOffer get(long id) throws NoSuchElementException {
    // TODO: implement business logic to retrieve a viewing offer with given id
    // TODO: throw a NoSuchElementException if the viewing offer cannot be found
    return null;
  }

  @Override
  public List<ViewingOffer> getAllInFuture() {
    // TODO: implement business logic to retrieve relevant viewing offers
    return Collections.emptyList();
  }

  @Override
  public List<ViewingOffer> getAllUntreatedInFuture(long userId) {
    // TODO: implement business logic to retrieve relevant viewing offers
    return Collections.emptyList();
  }
}
