package com.dmytro.andrusiv.helloWorld;

import org.junit.Assert;
import org.junit.Test;

import com.dmytro.andrusiv.service.ServiceTime;

public class TestServiceTime {

	private ServiceTime servTime;

	@Test
	public void testPartOfTimeNight1() {
		servTime = servTime.newPartOfTime("23:01:00");
		Assert.assertEquals("NIGHT", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeNight2() {
		servTime = servTime.newPartOfTime("23:00:01");
		Assert.assertEquals("NIGHT", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeNight3() {
		servTime = servTime.newPartOfTime("05:59:59");
		Assert.assertEquals("NIGHT", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeEvening1() {
		servTime = servTime.newPartOfTime("19:01:00");
		Assert.assertEquals("EVENING", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeEvening2() {
		servTime = servTime.newPartOfTime("19:00:01");
		Assert.assertEquals("EVENING", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeEvening3() {
		servTime = servTime.newPartOfTime("22:59:59");
		Assert.assertEquals("EVENING", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeDay1() {
		servTime = servTime.newPartOfTime("09:01:00");
		Assert.assertEquals("DAY", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeDay2() {
		servTime = servTime.newPartOfTime("09:00:01");
		Assert.assertEquals("DAY", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeDay3() {
		servTime = servTime.newPartOfTime("18:59:59");
		Assert.assertEquals("DAY", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeMorning1() {
		servTime = servTime.newPartOfTime("06:01:01");
		Assert.assertEquals("MORNING", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeMorning2() {
		servTime = servTime.newPartOfTime("06:00:01");
		Assert.assertEquals("MORNING", servTime.getPartOfDay());
	}

	@Test
	public void testPartOfTimeMorning3() {
		servTime = servTime.newPartOfTime("08:59:59");
		Assert.assertEquals("MORNING", servTime.getPartOfDay());
	}

}
