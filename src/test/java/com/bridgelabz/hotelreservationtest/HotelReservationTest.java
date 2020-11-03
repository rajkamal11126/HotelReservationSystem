package com.bridgelabz.hotelreservationtest;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;
import com.bridgelabz.hotelreservation.Result;

public class HotelReservationTest {
	/**
	 * return hotel name and rate
	 */
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 90, 3);
		Assert.assertEquals(newHotel.getHotelName(), "Lakewood");
	}

	/**
	 * return weekday rate of hotel
	 */
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 150, 4);
		Assert.assertTrue(newHotel.getWeekdayRate().equals(110));
		;
	}

	/**
	 * return the cheapest hotel name between given date range
	 */
	@Test
	public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() {
		HotelReservation hotelReservation = new HotelReservation();
		ArrayList<Hotel> hotelArray = new ArrayList<>();
		hotelArray.add(hotelReservation.addHotel("Lakewood", 110, 95, 4));
		hotelArray.add(hotelReservation.addHotel("Bridgewood", 160, 100, 4));
		hotelArray.add(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "11Sep2020", "12Sep2020");
		Assert.assertEquals("Lakewood", cheapestHotel.getHotelName());

	}

	/**
	 * return the cheapest hotel weekday rate given range of date
	 */
	@Test
	public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() {
		HotelReservation hotelReservation = new HotelReservation();
		ArrayList<Hotel> hotelArray = new ArrayList<>();
		hotelArray.add(hotelReservation.addHotel("Lakewood", 110, 95, 4));
		hotelArray.add(hotelReservation.addHotel("Bridgewood", 160, 100, 4));
		hotelArray.add(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "10Sep2020", "12Sep2020");
		Assert.assertEquals(110, cheapestHotel.getTotalCost());

	}

	/**
	 * return weekend and weekday rate of cheapest hotel given between date range
	 */
	@Test
	public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfWeekdaysAndWeekends() {
		HotelReservation hotelReservation = new HotelReservation();
		ArrayList<Hotel> hotelArray = new ArrayList<>();
		hotelArray.add(hotelReservation.addHotel("Lakewood", 110, 95, 4));
		hotelArray.add(hotelReservation.addHotel("Bridgewood", 160, 100, 20));
		hotelArray.add(hotelReservation.addHotel("Ridgewood", 220, 150, 5));
		Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray, "11Sep2020", "14Sep2020");
		Assert.assertEquals("Lakewood", cheapestHotel.getHotelName());
	}

	/**
	 * return hotel rating
	 */
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredRating() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110, 95, 4);
		Assert.assertTrue(newHotel.getRating().equals(4));
	}

}
