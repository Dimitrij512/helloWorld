package com.dmytro.andrusiv.helloWorld;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.dmytro.andrusiv.service.ServiceTime;

public class HelloWorld {
	private static final Logger logger = Logger.getLogger(HelloWorld.class);
	private static final String[] arrPartOfDay = { "morning", "day", "evening", "night" };

	public static void main(String[] args) {

		Locale localization = Locale.getDefault();
		ResourceBundle resource = ResourceBundle.getBundle("MessagesBundle", localization);
		ServiceTime serviceTime = new ServiceTime();
		String partOfTime = serviceTime.getPartOfDay();

		if (partOfTime != null) {

			for (int i = 0; i < arrPartOfDay.length; i++) {
				String partOfDay = arrPartOfDay[i];
				if (partOfTime.equals(partOfDay)) {
					System.out.println(resource.getString(partOfDay));
					logger.info("Showed " + partOfDay + " message");
					break;
				}
			}
		}
	}

}
