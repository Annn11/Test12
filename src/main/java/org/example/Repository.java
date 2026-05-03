package org.example;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
public class Repository<T extends Identifiable> {
    private List<T> items = new ArrayList<>();
    public void add(T item) {
        items.add(item);
    }
    public Optional<T> findById(String id) {
        return  items.stream().filter(item -> item.getId().equals(id)).findFirst();
    }
    public List<T> findAll() {
        return items;
    }
}
