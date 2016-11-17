package com.dmytro.andrusiv.helloWorld;

import org.junit.Assert;
import org.junit.Test;

import com.dmytro.andrusiv.service.ServiceTime;

public class TestServiceTime {

	private ServiceTime servTime;

	private String partOfTimeAndDays[][] = { { "23:00:00", "23:00:01", "05:59:59", "19:00:00", "19:00:01", "22:59:59", "09:00:00", "09:00:01", "18:59:59", "06:00:00", "06:00:01", "08:59:59" },
			{ "night", "night", "night", "evening", "evening", "evening", "day", "day", "day", "morning", "morning", "morning" } };

	@Test
	public void testPartOfTime() {
		int timeTest = 0;
		int partOfDayTest = 1;
		for (int i = 0; i < partOfTimeAndDays.length; i++) {
			for (int j = 0; j < partOfTimeAndDays[i].length; j++) {
				String time = partOfTimeAndDays[timeTest][j];
				String partOfDay = partOfTimeAndDays[partOfDayTest][j];
				servTime = servTime.newPartOfTime(time);
				Assert.assertEquals(partOfDay, servTime.getPartOfDay());
			}
		}
	}
}
