package de.unims.acse2024.mymakler.service;

import java.util.List;
import java.util.NoSuchElementException;

import de.unims.acse2024.mymakler.data.model.ViewingOffer;
import de.unims.acse2024.mymakler.service.exception.ViewingOfferDateInPast;

public interface ViewingOfferService {
  List<ViewingOffer> getAllInFuture();

  List<ViewingOffer> getAllUntreatedInFuture(long requestingUserId);

  ViewingOffer create(long offeringUserId, ViewingOffer viewingOffer) throws ViewingOfferDateInPast;

  ViewingOffer get(long id) throws NoSuchElementException;
}
