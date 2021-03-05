package com.aircas.hopital.fluid_infusion;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="errorhandle")
//@PropertySource(value="resources/errorhandle.properties")
public class ErrorhandleConfiguration {
	public Map<String, Integer> errorCode = new HashMap<String, Integer>();

	public Map<String, Integer> getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Map<String, Integer> errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
