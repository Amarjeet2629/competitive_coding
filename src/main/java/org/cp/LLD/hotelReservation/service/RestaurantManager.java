package org.cp.LLD.hotelReservation.service;

import org.cp.LLD.hotelReservation.entity.Booking;
import org.cp.LLD.hotelReservation.entity.Restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RestaurantManager {
    List<Restaurant> restaurants;

    public RestaurantManager(){
        this.restaurants = new ArrayList<>();
    }

    public List<Restaurant> getAllRestaurants(){
        return this.restaurants;
    }

    public Restaurant addRestaurant(String city, String name, int capacity){
        this.restaurants.add(new Restaurant(this.restaurants.size(), name, city, capacity));

        return this.restaurants.get(this.restaurants.size() - 1);
    }

    public void addBooking(Booking booking){
        Restaurant restaurant = this.restaurants.get(booking.getRestaurant().getId());
        restaurant.addBooking(booking);
    }

    public List<Restaurant> getAvailableRestaurant(String city, Date date, long startTime, int guests){
        return this.restaurants.stream().filter(restaurant -> {
            if(!Objects.equals(restaurant.getCity(), city)) return false;
            List<Booking> bookings = restaurant.getBookings();

            //check if there are available slots on that day;
            long endTime = startTime + 3600 * 1000;
            int cnt = 0;

            for (Booking booking : bookings) {
                if (!isAvailable(booking, date, startTime, endTime)) {
                    cnt += 1;
                }
            }

            return restaurant.getCapacity() - cnt >= guests;
        }).toList();
    }

    private boolean isAvailable(Booking booking, Date date, long startTime, long endTime){
        if(booking.getDate().equals(date)){
            return booking.getEndTime() < startTime || booking.getStartTime() > endTime;
        }

        return true;
    }
}
