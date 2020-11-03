package com.bridgelabz.hotelreservationtest;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;
import com.bridgelabz.hotelreservation.Result;

public class HotelReservationTest {
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110);
		Assert.assertEquals(newHotel.getHotelName(), "Lakewood");
	}

	@Test
	public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		ArrayList<Hotel> hotelArray = new ArrayList<>();
		hotelArray.add(hotelReservation.addHotel("Lakewood", 110));
		hotelArray.add(hotelReservation.addHotel("Bridgewood", 160));
		hotelArray.add(hotelReservation.addHotel("Ridgewood", 220));
		Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "10Sep2020", "12Sep2020");
		Assert.assertEquals(110, cheapestHotel.getTotalCost());
	}

	@Test
	public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() throws ParseException {
		HotelReservation hotelReservation = new HotelReservation();
		ArrayList<Hotel> hotelArray = new ArrayList<>();
		hotelArray.add(hotelReservation.addHotel("Lakewood", 110));
		hotelArray.add(hotelReservation.addHotel("Bridgewood", 60));
		hotelArray.add(hotelReservation.addHotel("Ridgewood", 150));
		Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "10Sep2020", "12Sep2020");
		Assert.assertEquals("Lakewood", cheapestHotel.getHotelName());
	}

	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel firstHotel = hotelReservation.addHotel("Lakewood", 110, 90);
		Hotel secondHotel = hotelReservation.addHotel("Bridgewood", 160, 50);
		Hotel thirdHotel = hotelReservation.addHotel("Ridgewood",220, 150);
		Assert.assertTrue(secondHotel.getWeekendRate().equals(50));
	}
}
