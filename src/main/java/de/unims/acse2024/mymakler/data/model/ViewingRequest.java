package de.unims.acse2024.mymakler.data.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ViewingRequest implements Serializable {
  private static final long serialVersionUID = 841816892216204087L;

  @Id
  private long id;

  // TODO: implement entity
}
