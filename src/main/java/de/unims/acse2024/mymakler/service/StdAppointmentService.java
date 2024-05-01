package de.unims.acse2024.mymakler.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import de.unims.acse2024.mymakler.data.model.Appointment;
import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.data.model.Role;
import de.unims.acse2024.mymakler.service.exception.Forbidden;

@Service
public class StdAppointmentService implements AppointmentService {
  private List<Appointment> getAllAppointmentsInFutureForOfferingUser(long userId) {
    // TODO: implement business logic for retrieving relevant appointments
    return Collections.emptyList();
  }

  private List<Appointment> getAllAppointmentsInFutureForRequestingUser(long userId) {
    // TODO: implement business logic for retrieving relevant appointments
    return Collections.emptyList();
  }

  @Override
  public List<Appointment> getAllAppointmentsInFutureForUser(MaklerUser user) {
    if (user.getRole() == Role.LANDLORD) {
      return getAllAppointmentsInFutureForOfferingUser(user.getId());
    } else {
      return getAllAppointmentsInFutureForRequestingUser(user.getId());
    }
  }

  @Override
  public Appointment create(long acceptingUserId, long viewingRequestId, String remarks) throws Forbidden {
    // TODO: implement business logic for creating an appointment
    // TODO: validate that acceptingUserId offers the viewing
    // TODO: validate that the viewing request was not already declined
    // TODO: validate that there is no existing appointment
    return null;
  }
}
