package de.unims.acse2024.mymakler.web.controller.dto;

import java.util.Set;
import java.util.stream.Collectors;

import de.unims.acse2024.mymakler.data.model.Attribute;

public final class Utility {
  private Utility() {}

  public static String attributesToString(Set<Attribute> attributes) {
    return attributes.stream().map(a -> a.getName()).sorted().collect(Collectors.joining(", "));
  }
}
