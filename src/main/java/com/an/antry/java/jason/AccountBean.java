package com.an.antry.java.jason;

public class AccountBean {
    private int id;
    private String name;
    private String email;
    private String address;
    private Birthday birthday;

    public AccountBean() {
    }

    @Override
    public String toString() {
        return "AccountBean [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
                + (email != null ? "email=" + email + ", " : "") + (address != null ? "address=" + address + ", " : "")
                + (birthday != null ? "birthday=" + birthday : "") + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }
}
