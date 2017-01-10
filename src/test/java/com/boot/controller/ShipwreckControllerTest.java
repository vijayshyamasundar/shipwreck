package com.boot.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;

	@Mock
	private ShipwreckRepository shipwreckRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testList() {
		Shipwreck sw1 = new Shipwreck();
		sw1.setId(1L);
		Shipwreck sw2 = new Shipwreck();
		sw1.setId(2L);
		List<Shipwreck> lst = new ArrayList<Shipwreck>();
		lst.add(sw1);
		lst.add(sw2);
		when(shipwreckRepository.findAll()).thenReturn(lst);

		List<Shipwreck> lstResult = sc.list();
		verify(shipwreckRepository).findAll();

		assertThat(lstResult.size(), is(2));
	}

	@Test
	public void testGet() {
		Shipwreck sw1 = new Shipwreck();
		sw1.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw1);

		Shipwreck sw2 = sc.get(1L);
		verify(shipwreckRepository).findOne(1L);

		assertThat(sw2.getId(), is(1l));
	}
}
