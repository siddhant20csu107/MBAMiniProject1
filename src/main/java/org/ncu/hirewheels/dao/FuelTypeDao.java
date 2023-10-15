package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.fuel_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelTypeDao extends JpaRepository<fuel_type, Long> {

}
