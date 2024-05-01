package de.unims.acse2024.mymakler.service;

import java.util.List;
import java.util.Set;

import de.unims.acse2024.mymakler.data.model.Attribute;

public interface AttributeService {
  Set<Attribute> createOrGet(Set<Attribute> attributes);
  List<Attribute> getAllAttributes();
}
