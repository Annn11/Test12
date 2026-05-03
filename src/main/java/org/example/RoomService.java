package org.example;
import java.util.List;
import java.util.Optional;
public class RoomService {
    private Repository<Room> rooms = new Repository<>();
    public Room createRoom(String id, int number, boolean avaiable) {
        if(id == null || id.isBlank()) {
            throw new BookingException("Room id cannot be blank");
        }
        if(number <=0) {
            throw new BookingException("Room number must be greater than zero");
        }
        Room room = new Room(id, number, avaiable);
        rooms.add(room);
        return room;
    }
    private Optional<Room> findById(String id) {
        return rooms.findById(id);
    }
    public List<Room> findAll() {
        return rooms.findAll();
    }
}
