package org.cp.LLD.hotelReservation.entity;

import java.util.Date;

public class Booking {
    int id;
    Restaurant restaurant;
    Date date;
    long startTime;
    long endTime;
    Status status;
    int guestCount;

    private final static int DURATION =  3600 * 1000;

    public Booking(int id, Restaurant restaurant, Date date, long startTime, int guestCount){
        this.id = id;
        this.restaurant = restaurant;
        this.date = date;
        this.startTime = startTime;
        this.endTime = startTime + DURATION;
        this.guestCount = guestCount;
        this.status = Status.SCHEDULED;
    }

    public int getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Date getDate() {
        return date;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public Status getStatus() {
        return status;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", restaurant=" + restaurant +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", guestCount=" + guestCount +
                '}';
    }
}
