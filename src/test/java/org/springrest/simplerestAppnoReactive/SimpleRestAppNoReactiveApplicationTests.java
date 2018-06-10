package org.springrest.simplerestAppnoReactive;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRestAppNoReactiveApplicationTests {
	@Autowired
	ItemService itemService;
	@Test
    //test business logic
	public void allItems() {
		List<Item> items = itemService.getItems();
        Assert.assertEquals(3, items.size());
	}

	@Test
    //test business logic
    public void getItem() {
	    Item item = itemService.getItem(2);
	    Assert.assertTrue(item.getName().equals("item2"));

    }

}
