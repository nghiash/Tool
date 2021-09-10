package com.command;

import org.apache.log4j.PropertyConfigurator;

public  class ConfigLogger {
	public static void readConfigFile() {
		String log4jString = "src/resources/log4j.properties";
		PropertyConfigurator.configure(log4jString);

	}
}
