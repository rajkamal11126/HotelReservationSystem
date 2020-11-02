package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int rate;

	public Hotel(String hotelName, int rate) {
		this.hotelName = hotelName;
		this.rate = rate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setCostWeekDay(int currentHotelCost) {
		
	}

	public int getWeekdayRate() {
		
		return 0;
	}

	public int getCostWeekday() {
		
		return 0;
	}

}
