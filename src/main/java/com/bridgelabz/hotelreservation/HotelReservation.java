package com.bridgelabz.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Optional;

public class HotelReservation {
	public Hotel addHotel(String name, int rate) {
		return new Hotel(name, rate);
	}

	public Result findCheapestHotel(ArrayList<Hotel> hotelArray, String dateStarting, String dateEnding)
			throws ParseException {
		int daysInBetween = getDaysInBetween(dateStarting, dateEnding);
		Result cheapestHotel = getCheapestHotel(daysInBetween, hotelArray);
		System.out.println(
				"Hotel Name: " + cheapestHotel.getHotelName() + " Total Rate is: " + cheapestHotel.getTotalCost());
		return cheapestHotel;
	}

	/**
	 * @param dateStarting
	 * @param dateEnding
	 * @return days between starting and ending date
	 * @throws ParseException
	 */
	private static int getDaysInBetween(String dateStarting, String dateEnding) throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date dateStart = new Date();
		try {
			dateStart = formatter.parse(dateStarting);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Date dateEnd = new Date();
		try {
			dateEnd = formatter.parse(dateEnding);
		} catch (Exception e) {
			// TODO: handle exception
		}

		long difference = dateEnd.getTime() - dateStart.getTime();
		System.out.println(difference);
		int daysInBetween = (int) Math.ceil(difference / (1000 * 60 * 60 * 24));
		return daysInBetween;
	}

	
	/**
	 * @param daysInBetween
	 * @param hotelArray
	 * @return cheapest hotel
	 */
	private static Result getCheapestHotel(int daysInBetween, ArrayList<Hotel> hotelArray) {
		int currentHotelCost;
		for (Hotel currentHotel : hotelArray) { 
			currentHotelCost = daysInBetween * currentHotel.getWeekDayRate();
			currentHotel.setCostWeekDay(currentHotelCost);
		}
		
		Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparing(Hotel::getCostWeekday));
		Result result = new Result();
		result.setHotelName(cheapestHotel.get().getHotelName());
		result.setTotalCost(cheapestHotel.get().getCostWeekday());
		return result;
	}

}