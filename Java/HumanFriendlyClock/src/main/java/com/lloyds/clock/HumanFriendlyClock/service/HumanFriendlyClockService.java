package com.lloyds.clock.HumanFriendlyClock.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HumanFriendlyClockService {

    private Logger logger = LoggerFactory.getLogger(HumanFriendlyClockService.class);

    private static final String TIME_DELIMETER = ":";

	public String getHumanReadableTime(String time) {
		if(Objects.nonNull(time)) {//In case input is received from client.
			if(validateInput(time)) {
				String[] timeArr = time.split(TIME_DELIMETER);
				logger.info("Input received, returning given time in human readable format.");
				return getTimeInHumanFriendlyFormat(Integer.parseInt(timeArr[0]), Integer.parseInt(timeArr[1]));
			} else {// If input is received in incorrect format from client, return current time in human readable format.
				logger.info("Incorrect Logging input, please enter time in hh:mm format.");
				return getCurrentTimeInHumanFriendlyFormat();
			}
		} else { // If no input is received from client, return current time in human readable format.
			logger.info("No Input recieved, returning current time in human readable format.");
			return getCurrentTimeInHumanFriendlyFormat();
		}
	}
	
	/**
	 * Get current time and return human readable format in text.
	 * */
	private String getCurrentTimeInHumanFriendlyFormat() {
		LocalDateTime now =  LocalDateTime.now();
		return getTimeInHumanFriendlyFormat(now.getHour(), now.getMinute());
	}

	/**
	 * Main method to convert input hour and minutes to human readable format.
	 * */
	private String getTimeInHumanFriendlyFormat(int hour, int minutes) {

		String textualNumbers[] = {"one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine", "thirty",
            };
		
		int effectiveHour = hour;
		effectiveHour = getEffectiveHourValue(hour, effectiveHour);
		
		int effectiveMinutes = minutes;
		effectiveMinutes = getEffectiveMinuteValue(minutes, effectiveMinutes);
		
		if (minutes == 0) { 
			return formatOutput(textualNumbers[effectiveHour] + " o' clock ");
		}

		else if (minutes == 30)
			return formatOutput("half past " + textualNumbers[effectiveHour]);

		else if (minutes > 30)
			return formatOutput(textualNumbers[effectiveMinutes] + " to " +    
			textualNumbers[(effectiveHour+1)]);
		
		else  
			return formatOutput(textualNumbers[effectiveMinutes] + " past " +    
			textualNumbers[(effectiveHour)]);
	}

	/**
	 * Get effective minute value to match index of the array containing the number in text format.
	 * */
	private int getEffectiveMinuteValue(int minutes, int effectiveMinutes) {
		if(minutes>30) {
			effectiveMinutes = 60 - effectiveMinutes -1;
		} else {
			effectiveMinutes-=1;
		}
		return effectiveMinutes;
	}

	/**
	 * Get effective hour value to match index of the array containing the number in text format.
	 * */
	private int getEffectiveHourValue(int hour, int effectiveHour) {
		if(hour>12) {
			effectiveHour = effectiveHour-12-1;
		} else {
			effectiveHour -=1;
		}
		return effectiveHour;
	}
	
	/**
	 * Capitalise the first character of the output  
	 * */
	private String formatOutput(String time) {
		return time.substring(0, 1).toUpperCase() + time.substring(1);
	}

	/**
	 * Check if input time is in hh:mm format.
	 * */
	private boolean validateInput(String time) {
		return time.split(TIME_DELIMETER).length==2;
	}
}
