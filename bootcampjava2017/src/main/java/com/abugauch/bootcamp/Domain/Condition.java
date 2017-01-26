/**
 * Created by Abugauch Emmanuel  on 10/1/2017.
 * Se trata de la condicion del dia actual
 */
package com.abugauch.bootcamp.Domain;

public class Condition {
    private int temp;
    private int idWind;
    private  int idAtmosphere;
    private int idWeather;
    private String name_state;
    private String name_country;
    private int day;
    private int month;
    private int year;


    public Condition() {
    }

    public Condition(int temp, int idWind, int idAtmosphere, int idWeather, String name_state, String name_country, int day, int month, int year) {
        this.temp = temp;
        this.idWind = idWind;
        this.idAtmosphere = idAtmosphere;
        this.idWeather = idWeather;
        this.name_state = name_state;
        this.name_country = name_country;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getIdWind() {
        return idWind;
    }

    public void setIdWind(int idWind) {
        this.idWind = idWind;
    }

    public int getIdAtmosphere() {
        return idAtmosphere;
    }

    public void setIdAtmosphere(int idAtmosphere) {
        this.idAtmosphere = idAtmosphere;
    }

    public int getIdWeather() {
        return idWeather;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    public String getName_state() {
        return name_state;
    }

    public void setName_state(String name_state) {
        this.name_state = name_state;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "temp=" + temp +
                ", idWind=" + idWind +
                ", idAtmosphere=" + idAtmosphere +
                ", idWeather=" + idWeather +
                ", name_state='" + name_state + '\'' +
                ", name_country='" + name_country + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
