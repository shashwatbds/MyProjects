package com.lloyds.clock.HumanFriendlyClock;

import java.util.Objects;

import com.lloyds.clock.HumanFriendlyClock.service.HumanFriendlyClockService;

public class HumanFriendlyClockCommandLineAPI {
	
	public static void main(String[] args) {
		HumanFriendlyClockService service = new HumanFriendlyClockService();
		String time;
		if(Objects.nonNull(args) && args.length>0) {
			time=args[0];
		} else {
			time="";
		}
		System.out.println(service.getHumanReadableTime(time));
	}

}
