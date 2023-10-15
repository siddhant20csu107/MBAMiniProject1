package org.ncu.hirewheels.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.ncu.hirewheels.dao.BookingDao;
import org.ncu.hirewheels.dao.LocationDao;
import org.ncu.hirewheels.dao.UsersDao;
import org.ncu.hirewheels.dao.VehicleDao;
import org.ncu.hirewheels.entities.booking;
import org.ncu.hirewheels.entities.location;
import org.ncu.hirewheels.entities.users;
import org.ncu.hirewheels.entities.vehicle;
import org.ncu.hirewheels.requests.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
    private  BookingDao bookingDao;
	@Autowired
    private  UsersDao usersDao;
	@Autowired
    private  LocationDao locationDao;
	@Autowired
    private  VehicleDao vehicleDao;
	
	@Override
	    public booking convertToEntity(BookingRequest request) {
		 	booking booking = new booking();
	        location location = locationDao.findById(request.getLocationId()).get();
	        vehicle vehicle = vehicleDao.findById(request.getVehicleId()).get();
	        users user = usersDao.findById(request.getUserId()).get();
	        booking.setUser(user);
	        booking.setLocation(location);
	        booking.setVehicle(vehicle);
	        booking.setAmount(request.getAmount());
	        booking.setBookingDate(LocalDate.parse(request.getBookingDate()));
	        booking.setDropoffDate(request.getDropoffDate());
	        booking.setPickupDate(request.getPickupDate());
	        return booking;
	    }
	
	@Override
    public booking addBooking(booking booking) {
        @SuppressWarnings("deprecation")
		users user = usersDao.getById(booking.getUser().getUserId());
        if (BigDecimal.valueOf(user.getWalletMoney()).compareTo(booking.getAmount()) >= 0) {
            BigDecimal newBalance = BigDecimal.valueOf(user.getWalletMoney()).subtract(booking.getAmount());
            user.setWalletMoney(newBalance.doubleValue());
            usersDao.save(user);
            return bookingDao.save(booking);
        } else {
            System.out.println("Insufficient Balance. Please Check With Admin");
            return null;
        }
    }

}
