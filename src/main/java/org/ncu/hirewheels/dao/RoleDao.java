package org.ncu.hirewheels.dao;

import org.ncu.hirewheels.entities.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<role, Long> {

}
