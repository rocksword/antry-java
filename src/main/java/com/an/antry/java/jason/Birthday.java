package com.an.antry.java.jason;

public class Birthday {
    private String birthday;

    public Birthday(String birthday) {
        this.birthday = birthday;
    }

    public Birthday() {
    }

    @Override
    public String toString() {
        return "Birthday [" + (birthday != null ? "birthday=" + birthday : "") + "]";
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
