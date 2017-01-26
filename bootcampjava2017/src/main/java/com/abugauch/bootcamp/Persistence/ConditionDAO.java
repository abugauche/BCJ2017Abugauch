package com.abugauch.bootcamp.Persistence;

/**
 * Created by Usuario on 24/1/2017.
 */
import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConditionDAO {
    public static final String SQL_INSERT = "INSERT INTO db_abugauch.actuallycondition (temp, wind_idWind, atmosphere_idAtmosphere, weather_idWeather, state_name, state_country_name, day_day, day_month,day_year) VALUES(?,?,?,?,?,?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.actuallycondition WHERE (state_name = ? AND state_country_name= ? AND day_day = ? AND day_month= ? AND day_year= ?)";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.actuallycondition";
    private static final DBConnection conn = DBConnection.getState();


    public boolean create(Condition cd,Day d, int temp,State s, Country c,Weather we, Atmosphere a, Wind wi){
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1,cd.getTemp());
            ps.setInt(2,wi.getIdWind());
            ps.setInt(3,a.getIdAtmosphere());
            ps.setInt(2,we.getIdWeather());
            ps.setString(4,s.getName());
            ps.setString(5,c.getName());
            ps.setInt(4,d.getDay());
            ps.setInt(4,d.getMonth());
            ps.setInt(4,d.getYear());
            if (ps.executeUpdate() >0){return true;}
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return false;
    }

    public Condition read(String state_name,String country_name,int day,int month,int year){
        PreparedStatement ps;
        Condition a = null;
        try {
            ResultSet res;
            ps = conn.getCnn().prepareStatement(SQL_READ);
            ps.setString(1,state_name);
            ps.setString(1,country_name);
            ps.setInt(1,day);
            ps.setInt(1,month);
            ps.setInt(1,year);
            res = ps.executeQuery();
            while (res.next()){
                a = new Condition(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4), res.getString(5), res.getString(6), res.getInt(7), res.getInt(8), res.getInt(9));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return a;
    }

    public ArrayList<Condition> readAll(){
        PreparedStatement ps;
        ResultSet res;
        ArrayList <Condition> conditions = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                conditions.add(new Condition(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4), res.getString(5), res.getString(6), res.getInt(7), res.getInt(8), res.getInt(9)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return conditions;
    }

}
