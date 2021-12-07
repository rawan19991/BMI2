package com.example.bmi.Model;

import java.util.Date;

public class UserModel {
String status;
    String weight,length;
    String date;

    public UserModel( String status, String weight, String length, String date) {
        this.status = status;
        this.weight = weight;
        this.length = length;
        this.date = date;
    }
    public String getStatus() {

        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
