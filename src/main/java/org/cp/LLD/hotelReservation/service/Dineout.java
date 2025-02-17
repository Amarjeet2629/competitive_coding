package org.cp.LLD.hotelReservation.service;

import org.cp.LLD.hotelReservation.entity.Booking;
import org.cp.LLD.hotelReservation.entity.Restaurant;

import java.util.*;

public class Dineout {
    BookingManager bookingManager;
    RestaurantManager restaurantManager;
    Random random = new Random();

    public Dineout(BookingManager bookingManager, RestaurantManager restaurantManager){
        this.bookingManager = bookingManager;
        this.restaurantManager = restaurantManager;

        initialize();
    }

    private void initialize(){
        List<String> city = new ArrayList<>(Arrays.asList("BLR", "MUM", "DLH", "PAT", "BPL"));
        List<String> names = new ArrayList<>(Arrays.asList("Social", "Biergarten", "pinds", "kapoors", "naan cha"));

        for(int i = 0; i < 25; i++){
            restaurantManager.addRestaurant(
                    city.get(random.nextInt(0, city.size())),
                    names.get(random.nextInt(0, names.size())),
                    15);
        }
    }

    public List<Restaurant> getAllRestaurantsByDate(String city, Date date, long startTime, int guests){
        List<Restaurant> restaurants = restaurantManager.getAvailableRestaurant(city, date, startTime, guests);

        return restaurants;
    }

    public Booking addBooking(Restaurant restaurant, Date date, long startTime, int guests){
        Booking booking = bookingManager.addBooking(restaurant, startTime, date, guests);
        restaurantManager.addBooking(booking);

        return booking;
    }


}
