package org.cp.LLD.hotelReservation.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    int id;
    String name;
    String city;
    int capacity;
    List<Booking> bookings;

    public Restaurant(int id, String name, String city, int capacity){
        this.id = id;
        this.name = name;
        this.city = city;
        this.capacity = capacity;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
