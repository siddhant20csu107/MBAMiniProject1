package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<booking, Long> {
	
    @Query("SELECT b FROM booking b WHERE b.vehicle.id = :vehicleId")
    List<booking> findByVehicleId(@Param("vehicleId") Long vehicleId);

}
