package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.users;

public interface UserService {
	
	// Registration Functionality	
    users createUser(users user);
    
    // Login Functionality    
    users getUser(String email, String password);
}
