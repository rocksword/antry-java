package com.an.antry.java.cmd;

public class CommandResult {
    public static final int EXIT_VALUE_TIMEOUT = 1;
    public static final int EXIT_VALUE_EXCEPTION = 2;
    private int exitValue;
    private String output;
    private String error;

    public CommandResult() {
    }

    @Override
    public String toString() {
        return "CommandResult [exitValue=" + exitValue + ", " + (output != null ? "output=" + output + ", " : "")
                + (error != null ? "error=" + error : "") + "]";
    }

    public int getExitValue() {
        return exitValue;
    }

    public void setExitValue(int exitValue) {
        this.exitValue = exitValue;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
