package com.an.antry.java.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommandHelper {
    private static final Log logger = LogFactory.getLog(CommandHelper.class);
    // default time out, in millseconds
    public static final int DEFAULT_TIMEOUT = 5000;
    public static final int DEFAULT_INTERVAL = 1000;

    public static CommandResult exec(String command) {
        logger.info("exec: " + command);
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            CommandResult commandResult = wait(process);
            return commandResult;
        } catch (IOException e) {
            logger.info("Error: " + e);
        } finally {
            if (process != null) {
                logger.info("destroy: " + process);
                process.destroy();
            }
        }
        return null;
    }

    private static CommandResult wait(Process process) {
        CommandResult result = new CommandResult();
        BufferedReader errorReader = null;
        BufferedReader inputReader = null;
        try {
            errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // timeout control
            long startTime = System.currentTimeMillis();
            boolean isFinished = false;

            for (;;) {
                if ((System.currentTimeMillis() - startTime) >= DEFAULT_TIMEOUT) {
                    logger.info("Time out.");
                    result.setExitValue(CommandResult.EXIT_VALUE_TIMEOUT);
                    result.setOutput("Command process timeout");
                    return result;
                }

                if (isFinished) {
                    logger.info("isFinished: " + isFinished);
                    result.setExitValue(process.waitFor());

                    // parse error info
                    if (errorReader.ready()) {
                        StringBuilder buffer = new StringBuilder();
                        String line;
                        while ((line = errorReader.readLine()) != null) {
                            buffer.append(line);
                        }
                        result.setError(buffer.toString());
                    }

                    // parse info
                    if (inputReader.ready()) {
                        StringBuilder buffer = new StringBuilder();
                        String line;
                        while ((line = inputReader.readLine()) != null) {
                            buffer.append(line);
                        }
                        result.setOutput(buffer.toString());
                    }
                    return result;
                }

                try {
                    isFinished = true;
                    int exitValue = process.exitValue();
                    logger.info("exitValue: " + exitValue);
                } catch (IllegalThreadStateException e) {
                    // process hasn't finished yet
                    isFinished = false;
                    logger.info("sleep: " + DEFAULT_INTERVAL);
                    Thread.sleep(DEFAULT_INTERVAL);
                }
            }
        } catch (Exception e) {
            logger.info("Error: " + e);
            result.setExitValue(CommandResult.EXIT_VALUE_EXCEPTION);
            result.setError(e.getMessage());
        } finally {
            if (errorReader != null) {
                try {
                    errorReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputReader != null) {
                try {
                    inputReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
