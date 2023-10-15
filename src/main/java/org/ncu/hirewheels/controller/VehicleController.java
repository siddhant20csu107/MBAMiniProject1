package org.ncu.hirewheels.controller;

import java.util.ArrayList;
import java.util.List;

import org.ncu.hirewheels.controller.VehicleSchema;
import org.ncu.hirewheels.entities.vehicle;
import org.ncu.hirewheels.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hirewheels/v1") 
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicles")
	public ResponseEntity<List<VehicleSchema>> getVehicles() {
		List<vehicle> vehicle = vehicleService.getAllVehicles();
	    List<VehicleSchema> vehicle1 = new ArrayList<>();
	    for (vehicle vehicle2 : vehicle) {
	    	VehicleSchema vehicleSchema = vehicleService.convertToDTO(vehicle2);
		    vehicle1.add(vehicleSchema);
	        }
	        return new ResponseEntity<>(vehicle1, HttpStatus.OK);
	    }
}
