package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class Hotel {
	private String hotelName;
	private int weekDayRate;
	private int weekendRate;
	private int costWeekday;

	public Hotel(String hotelName, int weekday , int weekend) {
		this.hotelName = hotelName;
		this.weekDayRate = weekday;
		this.weekendRate = weekend;
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
	public Integer getTotalRate(LocalDate dateStart , LocalDate dateEnd , long difference) { //calculates total cost for hotel
        Optional<Integer> totalcost = Stream.iterate(dateStart , date -> date.plusDays(difference)).limit(dateEnd.getDayOfMonth() - dateStart.getDayOfMonth() + 1 ).map(date -> { if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) return this.getWeekendRate();return this.getWeekdayRate();}).reduce((total , next) -> total+next);
        return totalcost.get();
    }
}
