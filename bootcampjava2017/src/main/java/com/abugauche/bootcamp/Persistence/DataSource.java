/**
 * Created by Usuario on 17/1/2017.
 */
package com.abugauche.bootcamp.Persistence;

import java.sql.*;

import com.abugauche.bootcamp.Configuration.*;

public class DataSource {

    Connection db = new DBConnection().getConnection();

    public ResultSet consult(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = db.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }        return resultado;
    }
    public void insertCountry(String name, String alpa2_code, String alpa3_code) {
        try {
                PreparedStatement st;
                st = db.prepareStatement("INSERT INTO db_abugauch.country (alpha3_code, name, alpha2_code) VALUES(" + alpa3_code + "," + name + "," + alpa2_code + ");");
                if (st.executeUpdate() == 1) {
                    System.out.println("Insertada.!");
                }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertState(String name, String abbr, int area, String capital, String country_name) {
        try {
            if((consult("select name from db_abugauch.country where name = "+country_name+";"))!=null){
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (name, abbr, capital, country_name) VALUES("+name+","+abbr+","+capital+","+country_name+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
            }else{
                System.out.println("Nonexistent countries.");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertAtmosphere(int idAtmosphere, int humidity, float presseure, int rising, float visibility) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (idAtmosphere, humidity, presseaure, rising, visibility) VALUES("+idAtmosphere+","+humidity+","+presseure+","+rising+","+visibility+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertWind(int idWind, int chill, int direction, int speed) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.wind (idWind, chill, direction, speed) VALUES("+idWind+","+chill+","+direction+","+speed+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }
    public void insertWeather(int idWeather, String descr) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.wheathers (idWeather, descr) VALUES("+idWeather+","+descr+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertCondition(int day,int month,int year, int temp, String state_name, String country_name, int idWeather, int idAtmosphere, int idWind) {
        try {
                PreparedStatement st;
                st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (temp, wind_idWind, atmosphere_idAtmosphere, weather_idWeather, state_name, state_country_name, day_day, day_month,day_year) VALUES("+temp+","+idWind+","+idAtmosphere+","+state_name+country_name+","+day+","+month+","+year+");" );
                if(st.executeUpdate()==1){
                    System.out.println("Success.! :)");
                }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertDay(int day, String month,int year) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.day (day, month, year) VALUES("+day+","+month+","+year+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertExtendedCondition(int day,int month,int year, int temp, String state_name, String country_name, int idWeather, int low, int high, int dayExtended) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.extendedcondtion (extendedDate, high, low, actuallyCondition_weather_idWeather, actuallyCondition_state_name, actuallyCondition_state_country_name, actuallyCondition_day_day, actuallyCondition_day_month,actuallyCondition_day_year) VALUES("+dayExtended+","+high +","+low+","+idWeather+","+state_name+","+country_name+","+low+","+state_name+country_name+","+day+","+month+","+year+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }
}
