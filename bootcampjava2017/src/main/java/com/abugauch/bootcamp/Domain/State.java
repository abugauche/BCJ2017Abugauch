/**
 * Created by Abugauch Emmanuel  on 11/1/2017.
 */
package com.abugauch.bootcamp.Domain;
public class State {
    private String name;
    private String abbr;//abbreviation
    private int area;//size
    private String capital;
    private String country_name;

    public State() {
    }

    public State(String name, String abbr, int area, String capital, String country_name) {
        this.name = name;
        this.abbr = abbr;
        this.area = area;
        this.capital = capital;
        this.country_name = country_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", area=" + area +
                ", capital='" + capital + '\'' +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
