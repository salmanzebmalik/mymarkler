package de.unims.acse2024.mymakler.service;

import java.util.List;

import de.unims.acse2024.mymakler.data.model.Appointment;
import de.unims.acse2024.mymakler.data.model.MaklerUser;
import de.unims.acse2024.mymakler.service.exception.Forbidden;

public interface AppointmentService {
  List<Appointment> getAllAppointmentsInFutureForUser(MaklerUser user);

  Appointment create(long acceptingUserId, long requestId, String remarks) throws Forbidden;
}
