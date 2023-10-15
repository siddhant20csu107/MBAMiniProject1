package org.ncu.hirewheels.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleSchema {
    private Long vehicleId;
    private String vehicleModel;
    private String vehicleNumber;
    private String vehicleSubcategoryName;
    private String color;
    private String locationName;
    private String fuelTypeName;
    private Integer availabilityStatus;
    private String vehicleImageUrl;
}
