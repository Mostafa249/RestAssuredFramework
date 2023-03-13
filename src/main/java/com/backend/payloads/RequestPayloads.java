package com.backend.payloads;

import com.backend.pojos.Booking;
import com.backend.pojos.Bookingdates;
import com.backend.pojos.Token;
import com.backend.utils.TestUtils;
import com.google.gson.Gson;

public class RequestPayloads {
    private Gson gson = new Gson();
    private String firstName = "";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = TestUtils.generateUniqueName("Mostafa");
    }

    public String getCreateNewBookingPayload() {
        Booking booking = new Booking();
        booking.setFirstname(getFirstName());
        booking.setLastname("Salem");
        booking.setAdditionalneeds("Breakfast");
        booking.setDepositpaid(true);
        booking.setTotalprice(111);
        booking.setBookingdates(bookingDates());
        return gson.toJson(booking);
    }

    public Bookingdates bookingDates() {
        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2019-01-01");
        return (bookingdates);
    }
    public String getBookingTokenPayload(){
        Token  token = new Token();
        token.setUsername("admin");
        token.setPassword("password123");
        return gson.toJson(token);
    }
}
