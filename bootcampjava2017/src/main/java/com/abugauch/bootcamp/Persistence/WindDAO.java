package com.abugauch.bootcamp.Persistence;

/**
 * Created by Usuario on 24/1/2017.
 */
import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.Wind;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WindDAO implements defaultDAO<Wind> {
    public static final String SQL_INSERT = "INSERT INTO db_abugauch.wind (idWind, chill, direction, speed) VALUES(?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.wind WHERE idWind = ?";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.wind";
    private  DBConnection dbCon;


    public boolean create(Wind a){
        PreparedStatement ps;
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_INSERT);
            ps.setInt(1,a.getIdWind());
            ps.setInt(2,a.getChill());
            ps.setInt(4,a.getDirection());
            ps.setInt(5,a.getSpeed());
            if (ps.executeUpdate() >0){return true;}
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return false;
    }

    public Wind read(Object key){
        PreparedStatement ps;
        Wind a = null;
        try {
            ResultSet res;
            ps = dbCon.getConnection().prepareStatement(SQL_READ);
            ps.setInt(1,Integer.parseInt(key.toString()));
            res = ps.executeQuery();
            while (res.next()){
                a = new Wind(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return a;
    }

    public ArrayList<Wind> readAll(){
        PreparedStatement ps;
        ResultSet res;
        ArrayList <Wind> winds = new ArrayList();
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                winds.add(new Wind(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return winds;
    }


}
