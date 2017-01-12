/**
 * Created by Usuario on 11/1/2017.
 */
public class State {
    private String name;
    private String abbr;//abbreviation
    private int area;//size
    private String capital;
    private Country country;

    public State(String name, String abbr, int area, String capital, Country country) {
        this.name = name;
        this.abbr = abbr;
        this.area = area;
        this.capital = capital;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", abbr='" + abbr + '\'' +
                ", area=" + area +
                ", capital='" + capital + '\'' +
                ", country=" + country +
                '}';
    }
}
