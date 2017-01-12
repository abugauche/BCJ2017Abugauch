/**
 * Created by Usuario on 11/1/2017.
 */
public class ExtendedCondition {
    private int day;
    private int high;
    private int low;
    private Condition condition;
    private Weather weather;

    public ExtendedCondition(int day, int high, int low, Condition condition, Weather weather) {
        this.day = day;
        this.high = high;
        this.low = low;
        this.condition = condition;
        this.weather = weather;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int extendedDate) {
        this.day = extendedDate;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "ExtendedCondition{" +
                "extendedDate=" + day +
                ", high=" + high +
                ", low=" + low +
                ", condition=" + condition +
                ", weather=" + weather +
                '}';
    }
}
