package de.unims.acse2024.mymakler.data.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Appointment implements Serializable {
  private static final long serialVersionUID = 7963596183081206458L;

  @Id
  private long id;

  // TODO: implement entity
}
