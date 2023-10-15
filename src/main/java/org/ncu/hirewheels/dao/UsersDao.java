package org.ncu.hirewheels.dao;

import java.util.List;

import org.ncu.hirewheels.entities.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<users, Long> {
	
    List<users> findByFirstNameIgnoreCase(String firstName);
    List<users> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);
    users findByEmailIgnoreCase(String email);
    List<users> findByMobileNoIgnoreCase(String mobileNo);

}
