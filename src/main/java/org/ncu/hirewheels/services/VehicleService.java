package org.ncu.hirewheels.services;

import java.time.ZonedDateTime;
import java.util.List;

import org.ncu.hirewheels.controller.VehicleSchema;
import org.ncu.hirewheels.entities.vehicle;

public interface VehicleService {
	VehicleSchema convertToDTO(vehicle vehicle);
	List<vehicle> getAllVehicles();
	boolean isVehicleAvailableForBooking(Long vehicleId, ZonedDateTime pickupDate, ZonedDateTime dropoffDate);
	List<vehicle> getAvailableVehicles(Long categoryId, String pickupLocation, ZonedDateTime pickupDate, ZonedDateTime dropoffDate);
}
