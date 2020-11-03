package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	public String typeOfCustomer;
	public int weekRate;
	private int weekendRate;

	public Hotel(String hotelName, int weekRate, int weekendRate) {
		this.setHotelName(hotelName);
		this.weekRate = weekRate;
		this.setWeekendRate(weekendRate);
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}
}
