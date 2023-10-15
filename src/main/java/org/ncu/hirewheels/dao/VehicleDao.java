package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDao extends JpaRepository<vehicle, Long> {

	@Query("SELECT vehicle FROM vehicle vehicle " +
	        "JOIN FETCH vehicle.vehicleSubcategory subcategory " +
	        "JOIN FETCH subcategory.vehicleCategory category " +
	        "WHERE category.id = :categoryId " +
	        "AND vehicle.availabilityStatus = 1")
	List<vehicle> findAvailableVehiclesByCategory(@Param("categoryId") Long categoryId);
}
