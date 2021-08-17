package entity;

import java.util.ArrayList;

public class User {
//    private ArrayList<String> orderList;
    private String Email;
    private String FirstName;
    private String LastName;
    private String Password;
    private int Day;
    private int Month;
    private int Year;
    private String Company;
    private String Address;
    private String Address2;
    private String City;
    private int State;
    private int Country;
    private String Zip;
    private String AdditionalInfo;
    private String HomePhone;
    private String MobilePhone;
    private String Alias;

    public void setEmail(String email) {
        Email = email;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setDay(int day) {
        Day = day;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public void setYear(int year) {
        Year = year;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setState(int state) {
        State = state;
    }

    public void setCountry(int country) {
        Country = country;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public void setAdditionalInfo(String additionalInfo) {
        AdditionalInfo = additionalInfo;
    }

    public void setHomePhone(String homePhone) {
        HomePhone = homePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        MobilePhone = mobilePhone;
    }

    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getEmail() {
        return Email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPassword() {
        return Password;
    }

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return Month;
    }

    public int getYear() {
        return Year;
    }

    public String getCompany() {
        return Company;
    }

    public String getAddress() {
        return Address;
    }

    public String getAddress2() {
        return Address2;
    }

    public String getCity() {
        return City;
    }

    public int getState() {
        return State;
    }

    public int getCountry() {
        return Country;
    }

    public String getZip() {
        return Zip;
    }

    public String getAdditionalInfo() {
        return AdditionalInfo;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public String getMobilePhone() {
        return MobilePhone;
    }

    public String getAlias() {
        return Alias;
    }

    public User(String email, String firstName, String lastName, String password, int day, int month, int year, String company, String address, String address2, String city, int state, int country, String zip, String additionalInfo, String homePhone, String mobilePhone, String alias) {
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        Day = day;
        Month = month;
        Year = year;
        Company = company;
        Address = address;
        Address2 = address2;
        City = city;
        State = state;
        Country = country;
        Zip = zip;
        AdditionalInfo = additionalInfo;
        HomePhone = homePhone;
        MobilePhone = mobilePhone;
        Alias = alias;
    }


}
