package com.dmytro.andrusiv.helloWorld;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.dmytro.andrusiv.service.ServiceTime;

public class HelloWorld {
	private static final Logger logger = Logger.getLogger(HelloWorld.class);

	public static void main(String[] args) {

		Locale localization = Locale.getDefault();

		ResourceBundle resource = ResourceBundle.getBundle("MessagesBundle", localization);

		ServiceTime serviceTime = new ServiceTime();

		String partOfTime = serviceTime.getPartOfDay();
		if (partOfTime != null) {
			if (partOfTime.equals("MORNING")) {
				System.out.println(resource.getString("morning"));
				logger.info("Showed morning message");
			} else if (partOfTime.equals("DAY")) {
				System.out.println(resource.getString("day"));
				logger.info("Showed day message");
			} else if (partOfTime.equals("EVENING")) {
				System.out.println(resource.getString("evening"));
				logger.info("Showed evening message");
			} else if (partOfTime.equals("NIGHT")) {
				System.out.println(resource.getString("night"));
				logger.info("Showed night message");
			} else {
				logger.error("not foung this part of day : " + partOfTime);
			}
		}
	}

}
