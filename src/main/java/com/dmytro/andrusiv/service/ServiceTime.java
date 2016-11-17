package com.dmytro.andrusiv.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.dmytro.andrusiv.model.PartOfDay;

public class ServiceTime {
	private static final Logger logger = Logger.getLogger(ServiceTime.class);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	private Date current;
	private Date morningTime;
	private Date dayTime;
	private Date eveningTime;
	private Date nightTime;
	private Date currentDate;

	public ServiceTime() {
		currentDate = new Date();
	}

	public ServiceTime(String time) {
		try {
			currentDate = dateFormat.parse(time);
		} catch (ParseException pe) {
			logger.error("ERROR PARSING : ", pe);
		}
	}

	public String getPartOfDay() {
		try {
			PartOfDay partOfDay = new PartOfDay();
			current = dateFormat.parse(dateFormat.format(currentDate));
			morningTime = dateFormat.parse(partOfDay.getMorning());
			dayTime = dateFormat.parse(partOfDay.getDay());
			eveningTime = dateFormat.parse(partOfDay.getEvening());
			nightTime = dateFormat.parse(partOfDay.getNight());
		} catch (ParseException pe) {
			logger.error("ERROR parsing date : " + pe);
		}
		if (current.equals(morningTime) || current.after(morningTime) && current.before(dayTime)) {
			logger.info("made : morning, World!!!");
			return "MORNING";
		} else if (current.equals(dayTime) || current.after(dayTime) && current.before(eveningTime)) {
			logger.info("made : Good day, World!");
			return "DAY";
		} else if (current.equals(eveningTime) || current.after(eveningTime) && current.before(nightTime)) {
			logger.info("made : Good evening, World!");
			return "EVENING";
		} else {
			logger.info("made : Good night, World!");
			return "NIGHT";
		}
	}

	public static ServiceTime newPartOfTime(String time) {
		return new ServiceTime(time);
	}

}
