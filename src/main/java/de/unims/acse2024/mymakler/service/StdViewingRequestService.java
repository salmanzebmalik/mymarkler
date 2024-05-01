package de.unims.acse2024.mymakler.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import de.unims.acse2024.mymakler.data.model.ViewingRequest;
import de.unims.acse2024.mymakler.service.exception.Forbidden;

@Service
public class StdViewingRequestService implements ViewingRequestService {
  @Override
  public ViewingRequest get(long id) throws NoSuchElementException {
    // TODO: implement business logic to retrieve viewing request with given id
    // TODO: throw a NoSuchElementException if the viewing request cannot be found
    return null;
  }

  @Override
  public ViewingRequest create(long userId, long viewingOfferId, String description) throws Forbidden {
    // TODO: implement business logic to create a new viewing request
    // TODO: validate that the user didn't already created a request in the past; throw a Forbidden exception if this is the case
    return null;
  }

  @Override
  public List<ViewingRequest> getAllUntreatedByLandlordInFuture(long userId) {
    // TODO: implement business logic to retrieve relevant viewing requests
    return Collections.emptyList();
  }

  @Override
  public boolean userAlreadyRequestedOffer(long userId, long viewingOfferId) {
    // TODO: implement business logic to check if the user already created a viewing request for given offer
    return false;
  }

  @Override
  public void decline(long decliningUserId, long viewingRequestId) throws Forbidden {
    // TODO: implement business logic to decline a viewing request
    // TODO: validate that the offering user correspond to decliningUserId
  }
}
