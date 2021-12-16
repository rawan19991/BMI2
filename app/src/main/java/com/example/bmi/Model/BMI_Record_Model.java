package com.example.bmi.Model;

public class BMI_Record_Model {
    String status;
    String weight,length;
    String date;
    String Id;

    public BMI_Record_Model() {
    }
    private static class Constrains{
        final static String underweight="Under Weight";
        final static String Healthy="Healthy";
        final static String OverWeight="Over Weight";
        final static String Obesity="Obesity";
        final static String LC="Little  Change";
        final static String SG="Still Good ";
        final static String GA="Go Ahead";
        final static String BC="Be Careful ";
        final static String SB="So Bad";


    }
    public double getBMI(){
        Double weights=Double.parseDouble(weight);
        Double Length=Double.parseDouble(length);
        return (weights/Math.pow((Length/100.0),2))*this.getAgePercent();


    }

    private double getAgePercent() {
        return 1;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }



    public BMI_Record_Model( String weight, String length, String date) {
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


