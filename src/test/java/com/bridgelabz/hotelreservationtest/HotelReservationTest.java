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
		Assert.assertEquals(220, cheapestHotel.getTotalCost());

	}
}
