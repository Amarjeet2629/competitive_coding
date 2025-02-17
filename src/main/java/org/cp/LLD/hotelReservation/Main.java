package org.cp.LLD.hotelReservation;

import org.cp.LLD.hotelReservation.entity.Booking;
import org.cp.LLD.hotelReservation.entity.Restaurant;
import org.cp.LLD.hotelReservation.service.BookingManager;
import org.cp.LLD.hotelReservation.service.Dineout;
import org.cp.LLD.hotelReservation.service.RestaurantManager;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class Main {
    public static void main(String ...args){
        Dineout driver = new Dineout(new BookingManager(), new RestaurantManager());


        Long startTime = LocalDateTime.now(ZoneId.systemDefault()).toInstant(ZoneOffset.UTC).getEpochSecond();
        List<Restaurant> restaurants = driver.getAllRestaurantsByDate("BLR", new Date(12323213231L),
                startTime, 5);

        restaurants.forEach(restaurant -> System.out.println(restaurant));

        Booking booking = driver.addBooking(restaurants.get(0), new Date(12323213231L), startTime, 5);
        System.out.println(booking);

        List<Restaurant> restaurants1 = driver.getAllRestaurantsByDate("BLR", new Date(12323213231L),
                startTime, 5);

        restaurants1.forEach(restaurant -> System.out.println(restaurant));
    }
}
