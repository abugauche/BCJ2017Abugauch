package com.abugauch.bootcamp.Persistence;

import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.Atmosphere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Usuario on 24/1/2017.
 */
public class AtmosphereDAO implements defaultDAO<Atmosphere> {
    public static final String SQL_INSERT = "INSERT INTO db_abugauch.atmosphere (idAtmosphere, humidity, presseaure, rising, visibility) VALUES(?,?,?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.atmosphere WHERE idAtmosphere = ?";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.atmosphere";

    private static final DBConnection conn = DBConnection.getState();


    public boolean create(Atmosphere a){
        PreparedStatement ps;
        try {
            ps = conn.getCnn().prepareStatement(SQL_INSERT);
        ps.setInt(1,a.getIdAtmosphere());
        ps.setInt(2,a.getHumidity());
        ps.setFloat(3,a.getPresseure());
        ps.setInt(4,a.getRising());
        ps.setFloat(5,a.getVisibility());
        if (ps.executeUpdate() >0){return true;}
    }catch(SQLException ex){
        System.out.println("Storage error"+ex);
    }finally {
        conn.closeCnn();
    }
    return false;
    }

    public Atmosphere read(Object key){
    PreparedStatement ps;
    Atmosphere a = null;
    try {
        ResultSet res;
        ps = conn.getCnn().prepareStatement(SQL_READ);
        ps.setInt(1,Integer.parseInt(key.toString()));
        res = ps.executeQuery();
        while (res.next()){
            a = new Atmosphere(res.getInt(1),res.getInt(2),res.getFloat(3),res.getInt(4), res.getInt(5));
        }
    }catch(SQLException ex){
        System.out.println("Storage error"+ex);
    }finally {
        conn.closeCnn();
    }
    return a;
    }

    public ArrayList<Atmosphere> readAll(){
        PreparedStatement ps;
        ResultSet res;
        ArrayList <Atmosphere> atmospheres = new ArrayList();
        try {
            ps = conn.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                atmospheres.add(new Atmosphere(res.getInt(1),res.getInt(2),res.getFloat(3),res.getInt(4), res.getFloat(5)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            conn.closeCnn();
        }
        return atmospheres;
    }
}
