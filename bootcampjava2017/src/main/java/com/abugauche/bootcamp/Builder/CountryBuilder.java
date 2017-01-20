package com.abugauche.bootcamp.Builder;

import com.abugauche.bootcamp.Domain.Country;

/**
 * Created by Usuario on 20/1/2017.
 */
public class CountryBuilder {

    private String newName;
    private String newAlpa2_code;
    private String newAlpa3_code;

    public CountryBuilder() {
    }

    public CountryBuilder setNewName(String newName) {
        this.newName = newName;
        return this;
    }


    public CountryBuilder setNewAlpa2_code(String newAlpa2_code) {
        this.newAlpa2_code = newAlpa2_code;
        return this;
    }


    public CountryBuilder setNewAlpa3_code(String newAlpa3_code) {
        this.newAlpa3_code = newAlpa3_code;
        return this;
    }

    public Country createCountry() {
        return new Country(newName, newAlpa2_code, newAlpa3_code);
    }

}
