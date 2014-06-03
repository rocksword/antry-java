package com.an.antry.java.log4j;

import org.apache.log4j.Logger;

public class Log4jMain {
    public static void main(String args[]) {
        Logger logger = Logger.getLogger(com.an.antry.java.log4j.Log4jMain.class);
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}