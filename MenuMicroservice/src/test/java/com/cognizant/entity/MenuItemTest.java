package com.cognizant.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuItemTest {
	
	MenuItem menu = new MenuItem();
	
	@Test
	public void testMenuConstructor() {
		MenuItem menu1 = new MenuItem(1,"apple",200,true);
		assertEquals(menu1.getMenuId(), 1);
	}
	
	
	@Test
	public void testMenuId() {
		menu.setMenuId(1);
		assertEquals(menu.getMenuId(),1);
	}
	

	@Test
	public void testMenuName() {
		menu.setName("shoes");
		assertEquals(menu.getName(),"shoes");
	}
	
	@Test
	public void testMenuPrice() {
		menu.setPrice(200);
		assertEquals(menu.getPrice(),200);
	}

	@Test
	public void testMenuActive() {
		menu.setActive(true);
		assertEquals(menu.isActive(),true);
	}

}