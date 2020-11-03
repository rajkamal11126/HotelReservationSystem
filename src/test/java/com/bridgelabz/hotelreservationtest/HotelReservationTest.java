package com.bridgelabz.hotelreservationtest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;

public class HotelReservationTest {
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 90);
		Assert.assertEquals(newHotel.getHotelName(), "Lakewood");
	}

	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 90);
		Assert.assertEquals(newHotel.weekRate, 110);
	}

	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekDayRate() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 90);
		Assert.assertEquals(newHotel.getWeekendRate(), 90);
	}

}
