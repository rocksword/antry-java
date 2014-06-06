package com.an.antry.java.cmd;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommandMain {
    private static final Log logger = LogFactory.getLog(CommandMain.class);

    public static void main(String[] args) {
        CommandResult result = CommandHelper.exec("mkdir testdir");
        if (result != null) {
            if (result.getOutput() != null) {
                logger.info("Output: " + result.getOutput());
            }
            if (result.getError() != null) {
                logger.error("Error: " + result.getError());
            }
        }
    }
}
