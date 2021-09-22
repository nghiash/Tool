package com.spring.logger;

import org.apache.log4j.PropertyConfigurator;

public class ConfigLogger {
  public static void setLogConfig() {
	  String logProperties = "src/resource/log4j.properties";
	  PropertyConfigurator.configure(logProperties);
  }
}
