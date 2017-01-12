/**
 * Created by Usuario on 11/1/2017.
 */
public class Weather {
    private int idWeather;
    private String descr;

    public Weather(int idWeather, String descr) {
        this.idWeather = idWeather;
        this.descr = descr;
    }

    public int getIdWeather() {
        return idWeather;
    }

    public void setIdWeather(int idWeather) {
        this.idWeather = idWeather;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String toString() {
        return "Weather{" +
                "idWeather=" + idWeather +
                ", descr='" + descr + '\'' +
                '}';
    }
}
