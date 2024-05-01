package de.unims.acse2024.mymakler.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import de.unims.acse2024.mymakler.data.model.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, String> {
}
