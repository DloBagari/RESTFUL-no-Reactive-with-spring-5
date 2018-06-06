package org.springrest.simplerestAppnoReactive;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//define this class as service
@Service
public class itemHandler implements  ItemService {
    private List<Item> items = new ArrayList<>();

    public itemHandler() {
        items.add(new Item(1, "item1"));
        items.add(new Item(2, "item2"));
        items.add(new Item(3, "item3"));
    }
    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public Item getItem(Integer id) {
        return items.stream().filter(item -> item.getId() == id)
                .findAny().orElse(new Item(0, "item not found"));
    }

    @Override
    public void addItem(Integer id, String name) {
        items.add(new Item(id, name));
    }

    @Override
    public void updateItem(Integer id, String name) {
        items.stream().filter(item -> item.getId() == id).findAny()
                .orElseThrow(() -> new RuntimeException("item not found")).setName(name);
    }

    @Override
    public boolean deleteItem(Integer id) {
        return items.removeIf((Item item) -> item.getId() == id);

    }
}
