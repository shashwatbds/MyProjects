package com.lloyds.clock.HumanFriendlyClock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lloyds.clock.HumanFriendlyClock.service.HumanFriendlyClockService;

/**
 * Rest Controller for converting time in numeric format to human readable format.
 * @Input: expected hh:mm format
 * @Return: Time in Human Readable format.
 * */
@RestController
public class HumanFriendlyClockController {

    private Logger logger = LoggerFactory.getLogger(HumanFriendlyClockController.class);
    
    @Autowired
    private HumanFriendlyClockService service;
    
    private static final String URL_MAPPING ="/clock/";

    /**
	 * Rest API to return time in Human Readable format.
	 * */
    @RequestMapping(method=RequestMethod.GET, value=URL_MAPPING , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getHumanReadableTime(@RequestParam(required=false) String time) {
    	return service.getHumanReadableTime(time);
	}
}
