package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private String typeOfCustomer;
	private int weekdayRate;
	public int costWeekday;
	public Object weekRate;

	public Hotel() {

	}

	public Hotel(String hotelName, int weekdayRate) {
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getTypeOfCustomer() {
		return typeOfCustomer;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public int getCostWeekday() {
		return costWeekday;
	}

	public void setCostWeekDay(int costWeekday) {
		this.costWeekday = costWeekday;
	}
}
