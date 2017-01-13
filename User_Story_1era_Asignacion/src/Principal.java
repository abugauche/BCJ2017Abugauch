/**
 * Created by Usuario on 11/1/2017.
 */

import java.util.*;
public class Principal {
    public static void main(String[] args) {

        Scanner sd = new Scanner(System.in);
        System.out.println("----------WELCOME US01 BCJAbugauch----------");
        System.out.println("Dou you want to enter? [Y/N]");
        while (sd.hasNext() && (sd.nextLine().equalsIgnoreCase("y"))) {
            System.out.println("Option: 1) Load data 2) Check DB Connection 99)Exit)");
            int opcion = sd.nextInt();
            switch(opcion){
                case 1: {
                    Scanner sc = new Scanner(System.in);

                    System.out.println("Country");
                    System.out.println("Enter country name: ");
                    String name  = sc.nextLine();
                    System.out.println("Two-digit country code: ");
                    String alpa2_code = sc.nextLine();
                    System.out.println("Three-digit country code: ");
                    String alpa3_code = sc.nextLine();
                    Country country = new Country(name, alpa2_code, alpa3_code);

                    System.out.println("State");
                    System.out.println("Name: ");
                    String nameS = sc.nextLine();
                    System.out.println("Abbreviation: ");
                    String abbr = sc.nextLine();
                    System.out.println("Capital: ");
                    String capital = sc.nextLine();
                    System.out.println("Area: ");
                    int area = sc.nextInt();
                    State state = new State(nameS, abbr, area, capital, country);

                    System.out.println("Wind");
                    System.out.println("Id Wind: ");
                    int idWind = sc.nextInt();
                    System.out.println("Chill: ");
                    int chill = sc.nextInt();
                    System.out.println("Direction: ");
                    int direction = sc.nextInt();
                    System.out.println("Speed: ");
                    int speed = sc.nextInt();
                    Wind wind = new Wind(idWind, chill, direction, speed);

                    System.out.println("Atmosphere");
                    System.out.println("IdAtmosphere: ");
                    int idAtmosphere = sc.nextInt();
                    System.out.println("Humidity: ");
                    int humidity = sc.nextInt();
                    System.out.println("Presseure: ");
                    float presseure = sc.nextFloat();
                    System.out.println("Rising: ");
                    int rising = sc.nextInt();
                    System.out.println("Visibility: ");
                    float visibility = sc.nextFloat();
                    Atmosphere atmosphere = new Atmosphere(idAtmosphere, humidity, presseure, rising, visibility);

                    System.out.println("Weather");
                    System.out.println("Description: ");
                    String description = sc.nextLine();
                    System.out.println("IdWeather: ");
                    int idWeather = sc.nextInt();
                    Weather weather = new Weather(idWeather, description);

                    System.out.println("Condition ");
                    System.out.println("Actually date: ");
                    String date = sc.nextLine();
                    System.out.println("Temperature: ");
                    int temp = sc.nextInt();
                    Condition condition = new Condition(date, temp, state, weather, atmosphere, wind);
                    System.out.println(condition.toString());

                    System.out.println("Extended Condition");
                    ExtendedCondition  [] extendedCondition = new ExtendedCondition[10];
                    for(int i=0; i<extendedCondition.length;i++){
                        System.out.println("------Day " + (i+1)+"------");
                        System.out.println("Weather description: ");
                        String description1 = sc.nextLine();
                        System.out.println("Id Weather: ");
                        int idWeather1 = sc.nextInt();
                        Weather weather1 = new Weather(idWeather1,description1);
                        System.out.println("Low: ");
                        int low = sc.nextInt();
                        System.out.println("High: ");
                        int high = sc.nextInt();
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

