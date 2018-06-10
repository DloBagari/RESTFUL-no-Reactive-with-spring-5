package org.springrest.simplerestAppnoReactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//define this class is RUST controller
@RestController
//define the request path
@RequestMapping("/")
public class ItemController {
    @Autowired
    ItemService itemService;
    //define this method is the response for empty string
    @ResponseBody
    @RequestMapping("")
    public Map<String, Object> state() {
        Map<String, Object> map = new HashMap<>();
        map.put("state", "ok");
        return map;
    }
    @ResponseBody
    @RequestMapping("/items")
    public List<Item> allItems() {
        return itemService.getItems();
    }

    @ResponseBody
    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable("id") Integer id) {
        return itemService.getItem(id);
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Map<String, Object> addItem(@RequestParam(value="id") Integer id, @RequestParam(value="name") String name) {
        itemService.addItem(id, name);
        Map<String, Object> map = new HashMap<>();
        map.put("POST ok", "new Item Added");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Map<String, Object> updateItem(@RequestParam(value="id") Integer id,
                                           @RequestParam(value="name") String name) {
        itemService.updateItem(id, name);
        Map<String, Object> map = new HashMap<>();
        map.put("PUT ok", "item's name is updated");
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteItem(@PathVariable("id") Integer id) {
        boolean result = itemService.deleteItem(id);
        Map<String, Object> map = new HashMap<>();
        if (result) {
            map.put("DELETE ok", "Item is deleted");
        } else {
            map.put("DELETE Failure", "Item not available");
        }
        return map;
    }
}