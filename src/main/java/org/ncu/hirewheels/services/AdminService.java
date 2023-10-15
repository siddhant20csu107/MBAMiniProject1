package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.vehicle;
import org.ncu.hirewheels.requests.VehicleRequest;

public interface AdminService {
    vehicle registerVehicle(vehicle vehicle);
    vehicle changeAvailability(long vehicleId, int status);
    vehicle convertToVehicleEntity(VehicleRequest vehicleRequest);
}
