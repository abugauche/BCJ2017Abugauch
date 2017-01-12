/**
 * Created by Usuario on 11/1/2017.
 */

import java.util.Scanner;
import java.sql.*;
public class Principal {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
     /*   System.out.println("Seleccione una opcion: ");

          while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))) {//change here

            System.out.println("Enter first name");
            String name = sc.nextLine();

            System.out.println("Enter surname");
            String surname = sc.nextLine();

            System.out.println("Enter number");

            int number=0;

            try {
                number = Integer.parseInt(sc.nextLine());//read int as string using nextLine() and parse
            }catch(NumberFormatException nfe) {
                nfe.printStackTrace();
            }

            System.out.println("Continue?[Y/N]");
        }*/
      /*  System.out.println("Ingrese el nombre del estado: ");
         String nameC=sc.nextLine();
        System.out.println("Ingrese el alpa2_code del estado: ");
        String alpa2_code=sc.nextLine();
        System.out.println("Ingrese el alpa3_code del estado: ");
        String alpa3_code=sc.nextLine();
        Country country = new Country(nameC,alpa2_code,alpa3_code);
        System.out.println(country.toString());
        System.out.println("");

        String res= "No se cargo ningun estado;";
        System.out.println("Nombre del estado: ");
        String nameS = sc.nextLine();
        System.out.println("Abreviatura del estado "+nameS+ ": ");
        String abbr = sc.nextLine();
        System.out.println("Area del estado "+nameS+": ");
        int area= sc.nextInt();
        System.out.println("Capital del estado "+nameS+ ": ");
        String capital = sc.nextLine();
        State state = new State(nameS,abbr,area,capital,country);
        System.out.println(state.toString());
        System.out.println("");

        System.out.println("Id Wind: ");
        int idWind= sc.nextInt();
        System.out.println("Chill: ");
        int chill= sc.nextInt();
        System.out.println("direction: ");
        int direction= sc.nextInt();
        System.out.println("speed: ");
        int speed= sc.nextInt();
        Wind wind = new Wind(idWind,  chill,  direction,  speed);
        System.out.println(wind.toString());
        System.out.println("");///////

        System.out.println("idAtmosphere: ");
        int idAtmosphere= sc.nextInt();
        System.out.println("humidity: ");
        int humidity= sc.nextInt();
        System.out.println("presseure: ");
        float presseure= sc.nextFloat();
        System.out.println("rising: ");
        int rising= sc.nextInt();
        System.out.println("visibility: ");
        float visibility= sc.nextFloat();
        Atmosphere atmosphere = new  Atmosphere( idAtmosphere,  humidity,  presseure,  rising,  visibility);
        System.out.println(atmosphere.toString());
        System.out.println("");///////

        System.out.println("idWeather");
        int idWeather= sc.nextInt();
        System.out.println("descr");
        String descr = sc.nextLine();
        Weather weather = new Weather(idWeather, descr);
        System.out.println(weather.toString());
        System.out.println("");/////

        System.out.println("actually date: ");
        String date = sc.nextLine();
        System.out.println("temp: ");
        int temp= sc.nextInt();
        Condition condition = new Condition( date,  temp,  state,  weather,  atmosphere,  wind);
        System.out.println(condition.toString());
        System.out.println("");////

        System.out.println("Extended Condition: ");
        int day= 0;
        day++;
        System.out.println("low");
        int low= sc.nextInt();
        System.out.println("high");
        int high= sc.nextInt();
        System.out.println("Day "+day);
        ExtendedCondition extendedCondition = new ExtendedCondition(day,  high,  low,  condition,  weather);
        System.out.println(extendedCondition.toString());
        for (int i=0; i<9;i++){*/

        try{
            System.out.println("Intento de conexion a la base de datos");
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root", "cuevana");
            System.out.println("Conexion exitosa");
        }
        catch(SQLException e){
            System.out.println("Error de MySQL");

        }
        catch(ClassNotFoundException e){
            System.out.println("Error al conectar"+e);
            e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("Se encontro el siguiente error " + e.getMessage());
        }
        }



    public String cargaEstado(Country country){
        Scanner sc = new Scanner(System.in);
        String res= "No se cargo ningun estado;";
        System.out.println("Nombre del estado: ");
        String name = sc.nextLine();
        System.out.println("Abreviatura del estado "+name+ ": ");
        String abbr = sc.nextLine();
        System.out.println("Area del estado "+name+": ");
        int area= sc.nextInt();
        System.out.println("Capital del estado "+name+ ": ");
        String capital = sc.nextLine();
        State state = new State(name,abbr,area,capital,country);
        return  state.toString();
    }






    }


