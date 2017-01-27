package com.abugauch.bootcamp.Persistence;

/**
 * Created by Usuario on 24/1/2017.
 */
import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.State;
import com.abugauch.bootcamp.Domain.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDAO {

    public static final String SQL_INSERT = "INSERT INTO db_abugauch.state (name, abbr, area, capital, country_name) VALUES(?,?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.state WHERE name = ? AND country_name = ?";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.state";
    private  DBConnection dbCon;


    public boolean create(State a,Country c){
        PreparedStatement ps;
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1,a.getName());
            ps.setString(2,a.getAbbr());
            ps.setInt(3,a.getArea());
            ps.setString(4,a.getCapital());
            ps.setString(5,c.getName());
            if (ps.executeUpdate() >0){return true;}
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return false;
    }

    public State read(Object key1, Object key2){
        PreparedStatement ps;
        State a = null;
        try {
            ResultSet res;
            ps = dbCon.getConnection().prepareStatement(SQL_READ);
            ps.setString(1,key1.toString());
            ps.setString(2,key2.toString());
            res = ps.executeQuery();
            while (res.next()){
                a = new State(res.getString(1),res.getString(2),res.getInt(3),res.getString(4),res.getString(5));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return a;
    }

    public List<State> readAll(){
        PreparedStatement ps;
        ResultSet res;
        List<State> states = new ArrayList<State>();
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                states.add(new State(res.getString(1),res.getString(2),res.getInt(3),res.getString(4),res.getString(5)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return states;
    }

}
