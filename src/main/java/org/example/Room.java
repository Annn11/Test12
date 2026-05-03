package org.example;

import java.util.Objects;

public class Room {
    private String id;
    private int number;
    boolean avaiable;
    public Room(String id, int number, boolean avaiable) {
        this.id = id;
        this.number = number;
        this.avaiable = avaiable;
    }
    public String getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }
    public boolean isAvaiable() {
        return avaiable;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getId().equals(room.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
