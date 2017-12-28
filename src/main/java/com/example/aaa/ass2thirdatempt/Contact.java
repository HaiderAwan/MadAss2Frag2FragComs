package com.example.aaa.ass2thirdatempt;

/**
 * Created by aaa on 10/17/2017.
 */

public class Contact {
    private String name, number,email;
    //private String image;
    private String call;

    public Contact() {
    }

    public Contact(String name, String number, String call,String email) {
        this.name = name;
        this.number = number;
        // this.year = year;
        //  this.image = image;
        this.email=email;
        this.call = call;
    }


    public String getName() {
        return name;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getCall() {
        return call;
    }

    public void setName(String name) {
        this.name = name;
    }
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;}
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

}
