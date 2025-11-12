package com.strangeTech.MiRent.Repository;

import com.strangeTech.MiRent.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
