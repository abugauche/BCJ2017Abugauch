/**
 * Created by Abugauch Emmanuel  on 17/1/2017.
 */
package com.abugauche.bootcamp.Persistence;
import java.sql.*;

import com.abugauche.bootcamp.Configuration.*;
import com.abugauche.bootcamp.Domain.*;

public class DataSource {

   private Connection db = new DBConnection().getConnection();

    public DataSource() {
        this.db = db;
    }

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
    public void insertCountry(Country c) {
        try {
                PreparedStatement st;
                st = db.prepareStatement("INSERT INTO db_abugauch.country (alpha3_code, name, alpha2_code) VALUES(" + c.getAlpa3_code() + "," + c.getName() + "," + c.getAlpa2_code() + ");");
                if (st.executeUpdate() == 1) {
                    System.out.println("Insertada.!");
                }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertState(State s, Country c) {
        try {
            if((consult("select name from db_abugauch.country where name = "+c.getName()+";"))!=null){
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (name, abbr, capital, country_name) VALUES("+s.getName()+","+s.getAbbr()+","+s.getCapital()+","+c.getName()+");" );
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

    public void insertAtmosphere(Atmosphere a) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (idAtmosphere, humidity, presseaure, rising, visibility) VALUES("+a.getIdAtmosphere()+","+a.getHumidity()+","+a.getPresseure()+","+a.getRising()+","+a.getVisibility()+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertWind(Wind w) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.wind (idWind, chill, direction, speed) VALUES("+w.getIdWind()+","+w.getChill()+","+w.getDirection()+","+w.getSpeed()+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }
    public void insertWeather(Weather w) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.wheathers (idWeather, descr) VALUES("+w.getIdWeather()+","+w.getDescr()+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertCondition(Day d, int temp,State s, Country c,Weather we, Atmosphere a, Wind wi) {
        try {
                PreparedStatement st;
                st = db.prepareStatement("INSERT INTO db_abugauch.atmosphere (temp, wind_idWind, atmosphere_idAtmosphere, weather_idWeather, state_name, state_country_name, day_day, day_month,day_year) VALUES("+temp+","+wi.getIdWind()+","+a.getIdAtmosphere()+","+s.getName()+c.getName()+","+d.getDay()+","+d.getMonth()+","+d.getYear()+");" );
                if(st.executeUpdate()==1){
                    System.out.println("Success.! :)");
                }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertDay(Day d) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.day (day, month, year) VALUES("+d.getDay()+","+d.getMonth()+","+d.getYear()+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }
        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }

    public void insertExtendedCondition(Day d, State s, Country c, Weather w, int low, int high, int dayExtended) {
        try {
            PreparedStatement st;
            st = db.prepareStatement("INSERT INTO db_abugauch.extendedcondtion (extendedDate, high, low, actuallyCondition_weather_idWeather, actuallyCondition_state_name, actuallyCondition_state_country_name, actuallyCondition_day_day, actuallyCondition_day_month,actuallyCondition_day_year) VALUES("+dayExtended+","+high +","+low+","+w.getIdWeather()+","+s.getName()+","+c.getName()+","+d.getDay()+","+d.getMonth()+","+d.getYear()+");" );
            if(st.executeUpdate()==1){
                System.out.println("Success.! :)");
            }

        } catch (SQLException ex) {
            System.out.println("Storage error"+ex);
        }
    }
}
