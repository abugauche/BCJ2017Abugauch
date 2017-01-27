package com.abugauch.bootcamp.Persistence;

/**
 * Created by Usuario on 24/1/2017.
 */
import com.abugauch.bootcamp.Configuration.DBConnection;
import com.abugauch.bootcamp.Domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Component
public class CountryDAO implements defaultDAO<Country> {
    public static final String SQL_INSERT = "INSERT INTO db_abugauch.country (alpha3_code, name, alpha2_code) VALUES(?,?,?)";
    public static final String SQL_READ = "SELECT * FROM db_abugauch.country W  HERE name = ?";
    public static final String SQL_READALL = "SELECT * FROM db_abugauch.country";
    @Autowired
    private  DBConnection dbCon;


    public boolean create(Country a){
        PreparedStatement ps;
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_INSERT);
            ps.setString(1,a.getAlpa3_code());
            ps.setString(2,a.getName());
            ps.setString(3,a.getAlpa2_code());
            if (ps.executeUpdate() >0){return true;}
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return false;
    }

    public Country read(Object key){
        PreparedStatement ps;
        Country a = null;
        try {
            ResultSet res;
            ps = dbCon.getConnection().prepareStatement(SQL_READ);
            ps.setString(1,key.toString());
            res = ps.executeQuery();
            while (res.next()){
                a = new Country(res.getString(1),res.getString(2),res.getString(3));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return a;
    }

    public List<Country> readAll(){
        PreparedStatement ps;
        ResultSet res;
        List <Country> countries = new ArrayList<Country>();
        try {
            ps = dbCon.getConnection().prepareStatement(SQL_READALL);
            res = ps.executeQuery();

            while (res.next()){
                countries.add(new Country(res.getString(1),res.getString(2),res.getString(3)));
            }
        }catch(SQLException ex){
            System.out.println("Storage error"+ex);
        }finally {
            dbCon.closeCnn();
        }
        return countries;
    }




}
