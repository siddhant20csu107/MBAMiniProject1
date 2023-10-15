package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.vehicle_category;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface VehicleCategoryDao extends JpaRepository<vehicle_category, Long> {

}
