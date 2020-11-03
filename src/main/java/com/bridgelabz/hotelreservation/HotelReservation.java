package com.bridgelabz.hotelreservation;

public class HotelReservation {
	public Hotel addHotel(String name, int weekday, int weekend) {
		return new Hotel(name, weekday, weekend);
	}

}