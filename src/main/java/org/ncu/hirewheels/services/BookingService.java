package org.ncu.hirewheels.services;

import org.ncu.hirewheels.entities.booking;
import org.ncu.hirewheels.requests.BookingRequest;

public interface BookingService {
	
	public booking convertToEntity(BookingRequest request);
    public booking addBooking(booking booking);
}
