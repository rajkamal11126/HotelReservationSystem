package com.bridgelabz.hotelreservationtest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.hotelreservation.Hotel;
import com.bridgelabz.hotelreservation.HotelReservation;
import com.bridgelabz.hotelreservation.Result;

public class HotelReservationTest {
	@Test
	public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
		HotelReservation hotelReservation = new HotelReservation();
		Hotel newHotel = hotelReservation.addHotel("Lakewood", 110);
		Assert.assertEquals(newHotel.getHotelName(), "Lakewood");
	}
	 @Test
	    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
	        HotelReservation hotelReservation = new HotelReservation() ;
	        Hotel newHotel = hotelReservation.addHotel("Lakewood" , 110 , 150) ;
	        Assert.assertEquals(newHotel.getWeekdayRate() , 110) ;
	    }

	    @Test
	    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() {
	        HotelReservation hotelReservation = new HotelReservation();
	        ArrayList<Hotel> hotelArray = new ArrayList<>();
	        hotelArray.add(hotelReservation.addHotel("Lakewood" , 110 , 90 ));
	        hotelArray.add(hotelReservation.addHotel("Bridgewood" , 160 , 60 ));
	        hotelArray.add(hotelReservation.addHotel("Ridgewood" , 220 , 150 ));
	        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10Sep2020" , "12Sep2020");
	        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());

	    }

	    @Test
	    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() {
	        HotelReservation hotelReservation = new HotelReservation();
	        ArrayList<Hotel> hotelArray = new ArrayList<>();
	        hotelArray.add(hotelReservation.addHotel("Lakewood" , 110 , 90));
	        hotelArray.add(hotelReservation.addHotel("Bridgewood"  , 160 , 60));
	        hotelArray.add(hotelReservation.addHotel("Ridgewood"  , 220 , 150 ));
	        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10Sep2020" , "14Sep2020");
	        Assert.assertEquals(110*4 , cheapestHotel.getTotalCost());

	    }
	    @Test
	    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
	        HotelReservation hotelReservation = new HotelReservation();
	        Hotel firstHotel = hotelReservation.addHotel("Lakewood", 110 , 90 );
	        Hotel secondHotel = hotelReservation.addHotel("Bridgewood", 160 , 50 );
	        Hotel thirdHotel = hotelReservation.addHotel("Ridgewood" , 220 , 150 );
	        Assert.assertEquals(50 , secondHotel.getWeekendRate());
	    }
	    @Test
	    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName1() {
	        HotelReservation hotelReservation = new HotelReservation();
	        ArrayList<Hotel> hotelArray = new ArrayList<>();
	        hotelArray.add(hotelReservation.addHotel("Lakewood" , 110 , 90 ));
	        hotelArray.add(hotelReservation.addHotel("Bridgewood" , 160 , 60 ));
	        hotelArray.add(hotelReservation.addHotel("Ridgewood" , 220 , 150 ));
	        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"11Sep2020" , "12Sep2020");
	        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());

	    }

	    @Test
	    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate1() {
	        HotelReservation hotelReservation = new HotelReservation();
	        ArrayList<Hotel> hotelArray = new ArrayList<>();
	        hotelArray.add(hotelReservation.addHotel("Lakewood", 110 , 90));
	        hotelArray.add(hotelReservation.addHotel("Bridgewood" , 160 , 60));
	        hotelArray.add(hotelReservation.addHotel("Ridgewood" , 220 , 150 ));
	        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10Sep2020" , "12Sep2020");
	        Assert.assertEquals(110+90+110 , cheapestHotel.getTotalCost());

	    }
	    @Test
	    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate1() {
	        HotelReservation hotelReservation = new HotelReservation();
	        Hotel firstHotel = hotelReservation.addHotel("Lakewood"  , 110 , 90 );
	        Hotel secondHotel = hotelReservation.addHotel("Bridgewood" , 160 , 50 );
	        Hotel thirdHotel = hotelReservation.addHotel("Ridgewood" , 220 , 150 );
	        Assert.assertTrue( secondHotel.getWeekendRate().equals(50));
	    }

	    @Test
	    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfWeekdaysAndWeekends() {
	        HotelReservation hotelReservation = new HotelReservation();
	        ArrayList<Hotel> hotelArray = new ArrayList<>();
	        hotelArray.add(hotelReservation.addHotel("Lakewood" , 110 , 90 ));
	        hotelArray.add(hotelReservation.addHotel("Bridgewood" , 160 , 50 ));
	        hotelArray.add(hotelReservation.addHotel("Ridgewood" , 220 , 150  ));
	        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray , "11Sep2020" , "14Sep2020");
	        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());
	    }
	  
	    @Test
	    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredRating() {
	        HotelReservation hotelReservation = new HotelReservation();
	        Hotel newHotel = hotelReservation.addHotel("Lakewood", 110 , 90 , 3);
	        Assert.assertTrue(newHotel.getRating().equals(3));
	    }


}
