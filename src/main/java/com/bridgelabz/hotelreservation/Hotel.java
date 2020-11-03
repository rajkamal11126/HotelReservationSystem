package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;

public class Hotel {
	private String hotelName;
	private int weekdayRate;
	private int weekendRate;
	public int costWeekday;

	public Hotel() {

	}

	public Hotel(String hotelName, int weekdayRate, int weekendRate) {
		this.hotelName = hotelName;
		this.weekdayRate = weekdayRate;
		this.weekendRate = weekendRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
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

	public void setTotalCost(Integer cost) {

	}

	public int getTotalCost() {
		return 0;
	}

	public Integer getTotalRate(LocalDate dateStart, LocalDate dateEnd, long difference) {
		Optional<Integer> totalcost = Stream.iterate(dateStart, date -> date.plusDays(difference))
				.limit(dateEnd.getDayOfMonth() - dateStart.getDayOfMonth() + 1).map(date -> {
					if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY))
						return this.getWeekendRate();
					return this.getWeekdayRate();
				}).reduce((total, next) -> total + next);
		return totalcost.get();
	}


}
