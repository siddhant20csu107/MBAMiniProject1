package org.ncu.hirewheels.services;

import org.ncu.hirewheels.dao.UsersDao;
import org.ncu.hirewheels.entities.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  UsersDao usersDao;
	
	@Override
	public users createUser(users user) {
        if (user.getFirstName() == null || user.getLastName() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("Username and password are required.");
        }
        users savedUser = usersDao.save(user);
        return savedUser;
	}
	
	@Override
    public users getUser(String email, String password) {
        users user = usersDao.findByEmailIgnoreCase(email);
        if (user == null) {
            System.out.println("User not Registered");
            return null; // User with the given email is not registered
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Unauthorized User");
            return null; // Password is incorrect
        }
        return user;
    }
}
