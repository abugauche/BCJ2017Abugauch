/**
 * Created by Usuario on 11/1/2017.
 */
package com.abugauche.bootcamp.Main;
import java.sql.Connection;
import java.util.*;
import com.abugauche.bootcamp.Domain.*;
import com.abugauche.bootcamp.Builder.*;
import com.abugauche.bootcamp.Persistence.*;
import com.abugauche.bootcamp.Configuration.*;

public class Principal {
    public static void main(String[] args) {


        Scanner sd = new Scanner(System.in);
        System.out.println("----------WELCOME US02 BCJAbugauch----------");
        System.out.println("Dou you want to enter? [1:Y/2:N]");
        int op=sd.nextInt();
        while (op==1) {
            System.out.println("Option: 1) Load data 2) Check DB Connection 99)Exit)");
            int opcion = sd.nextInt();
            switch(opcion){
                case 1: {
                    Scanner sc = new Scanner(System.in);
                    DataSource dt = new DataSource();
                    Scanner scd = new Scanner(System.in);
                    System.out.println("------Day------");
                    System.out.println("Day: ");
                    int dayv = scd.nextInt();
                    System.out.println("Month: ");
                    int month = scd.nextInt();
                    System.out.println("Year: ");
                    int year = scd.nextInt();
                    DayBuilder day = new DayBuilder();
                    day.setNewDay(dayv);
                    day.setNewMonth(month);
                    day.setNewYear(year);
                    Day d = day.createDay();
                    dt.insertDay(d);

                    System.out.println("------Country------");
                    System.out.println("Enter country name: ");
                    String name  = sc.nextLine();
                    System.out.println("Two-digit country code: ");
                    String alpa2_code = sc.nextLine();
                    System.out.println("Three-digit country code: ");
                    String alpa3_code = sc.nextLine();
                    CountryBuilder country = new CountryBuilder();
                    country.setNewName(name);
                    country.setNewAlpa2_code(alpa2_code);
                    country.setNewAlpa3_code(alpa3_code);
                    Country c = country.createCountry();
                    dt.insertCountry(c);

                    System.out.println("------State------");
                    System.out.println("Name: ");
                    String nameS = sc.nextLine();
                    System.out.println("Abbreviation: ");
                    String abbr = sc.nextLine();
                    System.out.println("Capital: ");
                    String capital = sc.nextLine();
                    System.out.println("Area: ");
                    int area = sc.nextInt();
                    StateBuilder state = new StateBuilder();
                    state.setNewAbbr(abbr);
                    state.setNewArea(area);
                    state.setNewCapital(capital);
                    state.setNewCountry(c);
                    state.setNewName(nameS);
                    State s= state.createState();
                    dt.insertState(s,c);

                    System.out.println("------Wind------");
                    System.out.println("Id Wind: ");
                    int idWind = sc.nextInt();
                    System.out.println("Chill: ");
                    int chill = sc.nextInt();
                    System.out.println("Direction: ");
                    int direction = sc.nextInt();
                    System.out.println("Speed: ");
                    int speed = sc.nextInt();
                    WindBuilder wind = new WindBuilder();
                    wind.setNewChill(chill);
                    wind.setNewDirection(direction);
                    wind.setNewIdWind(idWind);
                    wind.setNewSpeed(speed);
                    Wind w = wind.createWind();
                    dt.insertWind(w);

                    System.out.println("------Atmosphere------");
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
                    AtmosphereBuilder atmosphere = new AtmosphereBuilder();
                    atmosphere.setNewHumidity(humidity);
                    atmosphere.setNewIdAtmosphere(idAtmosphere);
                    atmosphere.setNewPresseure(presseure);
                    atmosphere.setNewRising(rising);
                    atmosphere.setNewVisibility(visibility);
                    Atmosphere a = atmosphere.createAtmosphere();
                    dt.insertAtmosphere(a);

                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("------Weather------");
                    System.out.println("Description: ");
                    String description = sc2.nextLine();
                    System.out.println("IdWeather: ");
                    int idWeather = sc2.nextInt();
                    WeatherBuilder weather = new WeatherBuilder();
                    weather.setNewDescr(description);
                    weather.setNewIdWeather(idWeather);
                    Weather we = weather.createWeather();
                    dt.insertWeather(we);

                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("------Condition------");
                    System.out.println("Actually date: ");
                    String date = sc3.nextLine();
                    System.out.println("Temperature: ");
                    int temp = sc3.nextInt();
                    ConditionBuilder condition = new ConditionBuilder();
                    condition.setNewAtmosphere(a);
                    condition.setNewDate(d);
                    condition.setNewState(s);
                    condition.setNewTemp(temp);
                    condition.setNewWeather(we);
                    condition.setNewWind(w);
                    Condition co = condition.createCondition();
                    dt.insertCondition(d,temp,s,c,we,a,w);
                    System.out.println(co.toString());

                    System.out.println("------Extended Condition------");
                    ExtendedConditionBuilder  [] extendedCondition = new ExtendedConditionBuilder[10];
                    for(int i=0; i<extendedCondition.length;i++){
                        Scanner sc4 = new Scanner(System.in);
                        System.out.println("------Day " + (i+1)+"------");
                        System.out.println("Weather description: ");
                        String description1 = sc4.nextLine();
                        System.out.println("Id Weather: ");
                        int idWeather1 = sc4.nextInt();
                        WeatherBuilder weather1 = new WeatherBuilder();
                        weather1.setNewIdWeather(idWeather1);
                        weather1.setNewDescr(description1);
                        Weather w1 = weather1.createWeather();
                        System.out.println("Low: ");
                        int low = sc4.nextInt();
                        System.out.println("High: ");
                        int high = sc4.nextInt();
                        extendedCondition [i] = new ExtendedConditionBuilder();
                        extendedCondition [i].setNewDay((i+1));
                        extendedCondition [i].setNewWeather(w1);
                        extendedCondition [i].setNewCondition(co);
                        extendedCondition [i].setNewHigh(high);
                        extendedCondition [i].setNewLow(low);
                        ExtendedCondition exC = extendedCondition [i].createExtendedCondition();
                    }
                    for(ExtendedConditionBuilder iterador : extendedCondition){
                        System.out.println(iterador);
                    }



                    break;
                }
                case 2: {
                    Connection conn =new DBConnection().getConnection();
                    break;

                }
                case 99: {
                    System.out.println("Good bye!! Enter 2!");
                    return;
                }
                default: {
                    System.out.println("Invalid Option");
                    break;
                }

            }

            System.out.println("Continue?[1:Y/2:N]");
            op=sd.nextInt();
        }
    }

}

