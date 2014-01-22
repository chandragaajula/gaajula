package com.gaajula.sample.mongodb;

import org.apache.log4j.Logger;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class LogWithMongoDB {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(LogWithMongoDB.class);

		logger.error("Hello World!!");
	}
}