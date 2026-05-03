package org.example;

import java.util.Objects;

public class Booking implements Identifiable {
    private String id;
    private Guest guest;
    private Room room;
    public Booking(String id, Guest guest, Room room) {
        this.id = id;
        this.guest = guest;
        this.room = room;
    }
    public String getId() {
        return id;
    }
    public Guest getGuest() {
        return guest;
    }
    public Room getRoom() {
        return room;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return id.equals(booking.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
