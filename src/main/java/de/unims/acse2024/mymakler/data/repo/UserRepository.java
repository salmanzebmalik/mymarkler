package de.unims.acse2024.mymakler.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import de.unims.acse2024.mymakler.data.model.MaklerUser;

public interface UserRepository extends JpaRepository<MaklerUser, Long> {
  // Use method name to let Spring generate an appropriate method.
  MaklerUser findByUsername(String username);

  boolean existsByUsername(String username);
}
