package org.example;

import java.util.Objects;

public class Guest implements Identifiable {
    private String id;
    private String Name;
    private String phoneNumber;

    public Guest(String id, String name, String phoneNumber) {
        this.id = id;
        this.Name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return getId().equals(guest.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
