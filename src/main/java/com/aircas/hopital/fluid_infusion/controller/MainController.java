package com.aircas.hopital.fluid_infusion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @RequestMapping("/{info}")
    public void updateDevice(@PathVariable String info){   
    	if (info.length() != 12){
    		logger.info("Exception of info length: " + info);
    	} else {
    		logger.info("GOTCHA..." + info);
    	}
    }

}