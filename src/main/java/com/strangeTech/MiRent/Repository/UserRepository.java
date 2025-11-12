package com.strangeTech.MiRent.Repository;

import com.strangeTech.MiRent.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
