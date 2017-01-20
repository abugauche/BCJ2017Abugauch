/**
 * Created by Abugauch Emmanuel  on 10/1/2017.
 */
package com.abugauche.bootcamp.Domain;
public class Country {
    private String name;
    private String alpa2_code;
    private String alpa3_code;

    public Country() {
    }

    public Country(String name, String alpa2_code, String alpa3_code) {
        this.name = name;
        this.alpa2_code = alpa2_code;
        this.alpa3_code = alpa3_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpa2_code() {
        return alpa2_code;
    }

    public void setAlpa2_code(String alpa2_code) {
        this.alpa2_code = alpa2_code;
    }

    public String getAlpa3_code() {
        return alpa3_code;
    }

    public void setAlpa3_code(String alpa3_code) {
        this.alpa3_code = alpa3_code;
    }

    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", alpa2_code='" + alpa2_code + '\'' +
                ", alpa3_code='" + alpa3_code + '\'' +
                '}';
    }
}
