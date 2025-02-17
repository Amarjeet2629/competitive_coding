package org.cp.LLD.hotelReservation.service;

import org.cp.LLD.hotelReservation.entity.Booking;
import org.cp.LLD.hotelReservation.entity.Restaurant;
import org.cp.LLD.hotelReservation.entity.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookingManager {
    List<Booking> bookings;

    public BookingManager(){
        this.bookings = new ArrayList<>();
    }

    public Booking addBooking(Restaurant restaurant, long startTime, Date date, int guests){
        this.bookings.add(new Booking(this.bookings.size(), restaurant, date, startTime, guests));

        return this.bookings.get(bookings.size() - 1);
    }

    public void updateBookingStatus(int bookingId, Status status){
        Booking booking = this.bookings.get(bookingId);
        booking.setStatus(status);
    }

    public Booking getBookingById(int bookingId){
        return this.bookings.get(bookingId);
    }

}
