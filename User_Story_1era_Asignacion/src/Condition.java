/**
 * Created by Usuario on 10/1/2017.
 * Se trata de la condicion del dia actual
 */
import java.*;
import java.util.Date;

public class Condition {
    private String date;
    private int temp;
    private State state;
    private Weather weather;
    private  Atmosphere atmosphere;
    private Wind wind;

    public Condition(String date, int temp, State state, Weather weather, Atmosphere atmosphere, Wind wind) {
        this.date = date;
        this.temp = temp;
        this.state = state;
        this.weather = weather;
        this.atmosphere = atmosphere;
        this.wind = wind;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "date='" + date + '\'' +
                ", temp=" + temp +
                ", state=" + state +
                ", weather=" + weather +
                ", atmosphere=" + atmosphere +
                ", wind=" + wind +
                '}';
    }
}
