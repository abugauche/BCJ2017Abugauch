/**
 * Created by Usuario on 11/1/2017.
 */

import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("----------WELCOME US01 BCJAbugauch----------");
        System.out.println("Dou you want to enter? [Y/N]");
        while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))) {//change here
            System.out.println("Option: 1) Load data 2) Check DB Connection 99)Exit)");
            int opcion = sc.nextInt();
            switch(opcion){
                case 1: {
                    System.out.println("Country");
                    System.out.print("Ingrese el nombre del country: ");
                    String name  = sc.nextLine();
                    System.out.println("Ingrese el alpa2_code del country: ");
                    String alpa2_code = sc.nextLine();
                    System.out.println("Ingrese el alpa3_code del country: ");
                    String alpa3_code = sc.nextLine();
                    Country country = new Country(name, alpa2_code, alpa3_code);
                    System.out.println("State");
                    String res = "No se cargo ningun estado;";
                    System.out.println("Nombre del estado: ");
                    String nameS = sc.nextLine();
                    System.out.println("Abreviatura del estado " + nameS + ": ");
                    String abbr = sc.nextLine();
                    System.out.println("Area del estado " + nameS + ": ");
                    int area = sc.nextInt();
                    System.out.println("Capital del estado " + nameS + ": ");
                    String capital = sc.nextLine();

                    State state = new State(nameS, abbr, area, capital, country);
                    System.out.println("Wind");
                    System.out.println("Id Wind: ");
                    int idWind = sc.nextInt();
                    System.out.println("Chill: ");
                    int chill = sc.nextInt();
                    System.out.println("direction: ");
                    int direction = sc.nextInt();
                    System.out.println("speed: ");
                    int speed = sc.nextInt();
                    Wind wind = new Wind(idWind, chill, direction, speed);
                    System.out.println("Atmosphere");
                    System.out.println("idAtmosphere: ");
                    int idAtmosphere = sc.nextInt();
                    System.out.println("humidity: ");
                    int humidity = sc.nextInt();
                    System.out.println("presseure: ");
                    float presseure = sc.nextFloat();
                    System.out.println("rising: ");
                    int rising = sc.nextInt();
                    System.out.println("visibility: ");
                    float visibility = sc.nextFloat();
                    Atmosphere atmosphere = new Atmosphere(idAtmosphere, humidity, presseure, rising, visibility);
                    System.out.println("Weather");
                    System.out.println("idWeather");
                    int idWeather = sc.nextInt();
                    System.out.println("descr");
                    String descr = sc.nextLine();
                    Weather weather = new Weather(idWeather, descr);
                    System.out.println(weather.toString());
                    System.out.println("Condition");
                    System.out.println("actually date: ");
                    String date = sc.nextLine();
                    System.out.println("temp: ");
                    int temp = sc.nextInt();
                    Condition condition = new Condition(date, temp, state, weather, atmosphere, wind);
                    System.out.println(condition.toString());
                    System.out.println("Extended");
                    ExtendedCondition  [] extendedCondition = new ExtendedCondition[9];
                    for(int i=0; i<extendedCondition.length;i++){
                        System.out.println("Extended Condition day "+i+": ");
                        System.out.println("Id Weather: ");
                        int idWeather1 = sc.nextInt();
                        System.out.println("Weather description: ");
                        String descr1 = sc.nextLine();
                        Weather weather1 = new Weather(idWeather1,descr1);
                        System.out.println("low");
                        int low = sc.nextInt();
                        System.out.println("high");
                        int high = sc.nextInt();
                        System.out.println("Day " + i);
                        extendedCondition [0] = new ExtendedCondition(i, high, low, condition, weather1);
                    }
                    for (int i=0;i<extendedCondition.length;i++){
                        System.out.println(extendedCondition[i].toString());
                    }

                    break;
                }
                case 2: {
                    Connect conn =new Connect();
                    conn.Connect();

                }
                case 99: {
                    System.out.println("Good bye!!");
                    return;
                }
                default: {
                    System.out.println("Invalid Option");
                    break;
                }

            }

            System.out.println("Continue?[Y/N]");
        }

        /*try{
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
        }*/
    }

}

