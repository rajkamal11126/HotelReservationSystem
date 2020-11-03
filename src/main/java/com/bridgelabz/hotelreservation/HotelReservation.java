package com.bridgelabz.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class HotelReservation {
	public Hotel addHotel(String name, int weekday, int weekend, int rating) {
		return new Hotel(name, weekday, weekend, rating);
	}

	public Result findCheapestHotel(ArrayList<Hotel> hotelArray, String Startdate, String Enddate) {

		Integer cost;
		LocalDate dateStart = null, dateEnd = null;

		try {
			dateStart = LocalDate.parse(Startdate);
		} finally {
			System.out.println("Please enter correct starting date");
		}
		try {
			dateEnd = LocalDate.parse(Enddate);
		} finally {
			System.out.println("Please enter correct ending date");
		}
		long difference = Duration.between(dateStart.atStartOfDay(), dateEnd.atStartOfDay()).toDays();

		for (Hotel hotelInfos : hotelArray) {
			cost = hotelInfos.getTotalRate(dateStart, dateEnd, difference);
			hotelInfos.setTotalCost(cost);
		}
		return this.getCheapestHotel(hotelArray);
	}

	public Result getCheapestHotel(ArrayList<Hotel> hotelArray) {
		Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
		Result result = new Result();
		result.setHotelName(cheapestHotel.get().getHotelName());
		result.setTotalCost(cheapestHotel.get().getTotalCost());
		System.out.println(result.getHotelName() + result.getTotalCost());
		return result;
	}

}