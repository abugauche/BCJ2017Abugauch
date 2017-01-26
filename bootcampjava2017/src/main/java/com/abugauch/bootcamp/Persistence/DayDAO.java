package com.abugauch.bootcamp.Persistence;

/**
 * Created by Usuario on 24/1/2017.
 */
import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.Day;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DayDAO implements defaultDAO<Day> {
    public static final String SQL_INSERT = "INSERT INTO db_abugauch.day (day, month, year) VALUES(?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.day WHERE day = ?";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.day";
    private static final DBConnection conn = DBConnection.getState();


    public boolean create(Day a){
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1,a.getDay());
            ps.setInt(2,a.getMonth());
            ps.setInt(4,a.getYear());
            if (ps.executeUpdate() >0){return true;}
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return false;
    }

    public Day read(Object key){
        PreparedStatement ps;
        Day a = null;
        try {
            ResultSet res;
            ps = conn.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1,Integer.parseInt(key.toString()));
            res = ps.executeQuery();
            while (res.next()){
                a = new Day(res.getInt(1),res.getInt(2),res.getInt(3));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return a;
    }

    public ArrayList<Day> readAll(){
        PreparedStatement ps;
        ResultSet res;
        ArrayList <Day> days = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                days.add(new Day(res.getInt(1),res.getInt(2),res.getInt(3)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return days;
    }

}
