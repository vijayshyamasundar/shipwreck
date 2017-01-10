package com.boot.controller;

import org.junit.Test;
import com.boot.controller.HomeController;

import static org.junit.Assert.assertEquals;

public class HomeControllerTest {

	@Test
	public void testHome() {
		assertEquals(new HomeController().home(), "Das Boot, reporting for duty!");
	}
}
