package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<location, Long> {

}
