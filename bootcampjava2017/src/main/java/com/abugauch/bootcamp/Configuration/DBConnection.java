/**
 * Created by Usuario on 17/1/2017.
 */
package com.abugauch.bootcamp.Configuration;

import java.sql.Connection;
import java.sql.*;
public class DBConnection {

    private  Connection con;
    private   String driver="com.mysql.jdbc.Driver";
    private   String user="root";
    private   String password="cuevana";
    private   String url="jdbc:mysql://localhost:3306/mydb";

    public Connection getConnection(){
        try{
                Class.forName(driver);
                con = DriverManager.getConnection(url,user,password);
                System.out.println("Connect :)");
            }
        catch(SQLException e){
            System.out.println("Error de MySQL " +e);

        }
        catch(ClassNotFoundException e){
            System.out.println("Error al conectar "+e);
            e.printStackTrace();
        }
        catch (NullPointerException e){
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println("Se encontro el siguiente error " + e.getMessage());
        }
        return con;
        }

    public  void closeCnn(){
        con = null;
    }
}
