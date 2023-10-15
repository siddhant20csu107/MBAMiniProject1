package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.vehicle_subcategory;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VehicleSubcategoryDao extends JpaRepository<vehicle_subcategory, Long> {

}
