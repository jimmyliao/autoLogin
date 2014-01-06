package com.ibm.ftm;

//import org.joda.time.LocalTime;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class HelloWebDriver {
    //private static Logger logger = Logger.getLogger("name");
    static Logger logger = Logger.getLogger(HelloWorld.class);
    
    public static void main(String[] args) {
    	//DOMConfigurator is used to configure logger from xml configuration file
    	DOMConfigurator.configure("./log4j-config.xml");

	//System.out.println("Hello!");

	//Log in console in and log file	
	//logger.info("logger info msg here.");
	logger.debug("Log4j appender configuration is successful !!");
    //LocalTime currentTime = new LocalTime();
    //System.out.println("The current local time is: " + currentTime);

    //Greeter greeter = new Greeter();
    //System.out.println(greeter.sayHello());
  }
}
