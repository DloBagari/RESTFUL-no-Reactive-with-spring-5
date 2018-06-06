package org.springrest.simplerestAppnoReactive;

import java.util.List;

public interface ItemService {
    List<Item> getItems();
    Item getItem(Integer id);
    void addItem(Integer id, String name);
    void updateItem(Integer id, String name);
    boolean deleteItem(Integer id);
}
