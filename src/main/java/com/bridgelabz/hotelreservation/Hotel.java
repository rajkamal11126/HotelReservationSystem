package com.bridgelabz.hotelreservation;

public class Hotel {
	private String hotelName;
	private int rate;
	private int weekDayRate;
	private int weekendRate;
	private int costWeekday;

	public Hotel(String hotelName, int rate, int weekDayRate, int weekendRate) {
		this.hotelName = hotelName;
		this.rate = rate;
		this.weekDayRate = weekDayRate;
		this.weekendRate = weekendRate;
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

	public int getWeekDayRate() {
		return weekDayRate;
	}

	public int getWeekdayRate() {
		return weekDayRate;
	}

	public int getCostWeekday() {
		return getCostWeekday();
	}

	public void setCostWeekDay(int costWeekday) {
		this.costWeekday = costWeekday;
	}
}
