package org.ncu.hirewheels.services;

import org.ncu.hirewheels.dao.FuelTypeDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.dao.VehicleSubcategoryDao;
import org.ncu.hirewheels.entities.fuel_type;
import org.ncu.hirewheels.entities.location;
import org.ncu.hirewheels.entities.vehicle;
import org.ncu.hirewheels.entities.vehicle_subcategory;
import org.ncu.hirewheels.requests.VehicleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private VehicleDao vehicleDao;
	
	@Autowired
	private LocationDao locationDao;
	
	@Autowired 
	private VehicleSubcategoryDao vehicleSubcategoryDao;
	
	@Autowired
	private FuelTypeDao fuelTypeDao;

	public vehicle convertToVehicleEntity(VehicleRequest vehicleRequest) {
		vehicle vehicle = new vehicle();
        vehicle_subcategory subcategory = vehicleSubcategoryDao.findById(vehicleRequest.getVehicleSubCategoryId()).get();
        vehicle.setVehicleSubcategory(subcategory);
        location location = locationDao.findById(vehicleRequest.getLocationId()).get();
        vehicle.setLocation(location);
        fuel_type fuelType = fuelTypeDao.findById(vehicleRequest.getFuelTypeId()).get();
        vehicle.setFuelType(fuelType);
        vehicle.setColor(vehicleRequest.getColor());
        vehicle.setVehicleModel(vehicleRequest.getVehicleModel());
        vehicle.setVehicleNumber(vehicleRequest.getVehicleNumber());
        vehicle.setAvailabilityStatus(vehicleRequest.getAvailabilityStatus());
        vehicle.setVehicleImageUrl(vehicleRequest.getVehicleImageUrl());
        return vehicle;
    }
	
	@Override
	public vehicle registerVehicle(vehicle vehicle) {
		vehicle.setAvailabilityStatus(1);
		return vehicleDao.save(vehicle);
	}
	
	  @Override
	    public vehicle changeAvailability(long vehicleId, int status) {
	        vehicle vehicle = vehicleDao.findById(vehicleId).orElse(null);
	        if (vehicle != null) {
	        	vehicle.setAvailabilityStatus(status);
	            return vehicleDao.save(vehicle);
	        }
	        return null;
	    }
}
