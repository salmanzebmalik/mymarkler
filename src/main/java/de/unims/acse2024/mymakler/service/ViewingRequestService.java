package de.unims.acse2024.mymakler.service;

import java.util.List;
import java.util.NoSuchElementException;

import de.unims.acse2024.mymakler.data.model.ViewingRequest;
import de.unims.acse2024.mymakler.service.exception.Forbidden;

public interface ViewingRequestService {
  ViewingRequest get(long id) throws NoSuchElementException;

  ViewingRequest create(long userId, long viewingOfferId, String description) throws Forbidden;

  List<ViewingRequest> getAllUntreatedByLandlordInFuture(long userId);

  boolean userAlreadyRequestedOffer(long userId, long viewingOfferId);

  void decline(long decliningUserId, long viewingRequestId) throws Forbidden;
}
