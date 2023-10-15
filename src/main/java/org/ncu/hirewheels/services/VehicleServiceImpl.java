package org.ncu.hirewheels.services;

import java.util.ArrayList;
import java.util.List;
import java.time.ZonedDateTime;

import org.ncu.hirewheels.controller.VehicleSchema;
import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.entities.booking;
import org.ncu.hirewheels.entities.vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private VehicleDao vehicleDao;

    @Override
    public List<vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }
    
    @Override
    public VehicleSchema convertToDTO(vehicle vehicle) {
        VehicleSchema dto = new VehicleSchema();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setVehicleModel(vehicle.getVehicleModel());
        dto.setVehicleNumber(vehicle.getVehicleNumber());
        dto.setVehicleSubcategoryName(vehicle.getVehicleSubcategory().getVehicleSubcategoryName());
        dto.setColor(vehicle.getColor());
        dto.setLocationName(vehicle.getLocation().getLocationName());
        dto.setFuelTypeName(vehicle.getFuelType() != null ? vehicle.getFuelType().getFuelType() : "N/A");
        dto.setAvailabilityStatus(vehicle.getAvailabilityStatus());
        dto.setVehicleImageUrl(vehicle.getVehicleImageUrl());
        return dto;
    }
    
    @Override
    public List<vehicle> getAvailableVehicles(Long categoryId, String pickupLocation, ZonedDateTime pickupDate, ZonedDateTime dropoffDate) {
        List<vehicle> availableVehicles = vehicleDao.findAvailableVehiclesByCategory(categoryId);
        List<vehicle> filteredVehicles = new ArrayList<>();
        for (vehicle vehicle : availableVehicles) {
            if (vehicle.getAvailabilityStatus() == 1 &&
                vehicle.getLocation().getLocationName().equalsIgnoreCase(pickupLocation) &&
                isVehicleAvailableForBooking(vehicle.getVehicleId(), pickupDate, dropoffDate)) {
                filteredVehicles.add(vehicle);
            }
        }
        return filteredVehicles;
    }

    
    public boolean isVehicleAvailableForBooking(Long vehicleId, ZonedDateTime pickupDate, ZonedDateTime dropoffDate) {
        List<booking> bookings = bookingDao.findByVehicleId(vehicleId);
        for (booking booking : bookings) {
        	ZonedDateTime bookingPickupDate = booking.getPickupDate();
        	ZonedDateTime bookingDropoffDate = booking.getDropoffDate();
        	if (dropoffDate.isBefore(bookingPickupDate) || pickupDate.isAfter(bookingDropoffDate)) {
        	    continue;
        	} else {
        	    return false;
        	}
        }
        return true;
    }
    
  
}
