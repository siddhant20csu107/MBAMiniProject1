package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao extends JpaRepository<city, Long> {

}
