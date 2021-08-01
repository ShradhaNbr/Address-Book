package com.addressBook;

public class Contact {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    long zip;
    long phoneNumber;
    String email;

    //Using getters and setters
    public String getfirstName() {
        return firstName;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public String getcity() {
        return city;
    }
    public void setcity(String city) {
        this.city = city;
    }
    public String getstate() {
        return state;
    }
    public void setstate(String state) {
        this.state = state;
    }
    public long getzip() {
        return zip;
    }
    public void setzip(long zip) {
        this.zip = zip;
    }
    public long getphoneNumber() {
        return phoneNumber;
    }
    public void setphoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getemail() {
        return email;
    }
    public void setemail(String email) {
        this.email = email;
    }
}
