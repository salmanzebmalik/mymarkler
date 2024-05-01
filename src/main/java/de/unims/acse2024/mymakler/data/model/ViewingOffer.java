package de.unims.acse2024.mymakler.data.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ViewingOffer implements Serializable {
  private static final long serialVersionUID = 7818194320117743916L;

  @Id
  private long id;

  // TODO: implement entity
  // TODO: use LocalDateTime for dates and times
}
