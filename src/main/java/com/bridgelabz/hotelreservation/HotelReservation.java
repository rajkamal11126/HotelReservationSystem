package com.bridgelabz.hotelreservation;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class HotelReservation {
	public Hotel addHotel(String name, String type, int weekday, int weekend, int rating) {
		return new Hotel(name, type, weekday, weekend, rating);
	}

	/**
	 * method to find cheapest hotel in the basis of given date range
	 */
	public Result findCheapestHotel(ArrayList<Hotel> hotelArray, String dateS, String dateE) {
		Integer cost;
		LocalDate dateStart = null, dateEnd = null;

		try {
			dateStart = LocalDate.parse(dateS);
		} catch (Exception e) {
			System.out.println("Please enter correct starting date");
		}
		try {
			dateEnd = LocalDate.parse(dateE);
		} catch (Exception e) {
			System.out.println("Please enter correct ending date");
		}
		long difference = Duration.between(dateStart.atStartOfDay(), dateEnd.atStartOfDay()).toDays();

		for (Hotel hotel : hotelArray) {
			cost = hotel.getTotalRate(dateStart, dateEnd, difference);
			hotel.setTotalCost(cost);
		}
		Result result = this.getCheapestHotel(hotelArray);
		result = this.cheapestBestRatedHotel(hotelArray, result);
		return result;
	}

	/**
	 * hotelArray method to get the cheapest hotel
	 */
	public Result getCheapestHotel(ArrayList<Hotel> hotelArray) {
		Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
		Result result = new Result();
		result.setHotelName(cheapestHotel.get().getHotelName());
		result.setTotalCost(cheapestHotel.get().getTotalCost());
		System.out.println(result.getHotelName() + result.getTotalCost());
		return result;
	}

	/**
	 * method to get the cheapest and best rated hotel
	 */
	public Result cheapestBestRatedHotel(ArrayList<Hotel> hotelArray, Result result) {
		Optional<Hotel> maxCostHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
		Optional<Hotel> minRatingHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getRating()));
		for (Hotel hotel : hotelArray) {
			if (hotel.getTotalCost() < maxCostHotel.get().getTotalCost()
					&& hotel.getRating() > minRatingHotel.get().getRating()) {
				result.setRating(hotel.getRating());
				result.setHotelName(hotel.getHotelName());
				result.setTotalCost(hotel.getTotalCost());
			}
		}
		return result;
	}

}