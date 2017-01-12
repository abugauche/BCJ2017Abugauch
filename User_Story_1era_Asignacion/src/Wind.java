/**
 * Created by Usuario on 10/1/2017.
 */
public class Wind {
    private int idWind;
    private int chill;
    private int direction;
    private int speed;

    public Wind(int idWind, int chill, int direction, int speed) {
        this.idWind = idWind;
        this.chill = chill;
        this.direction = direction;
        this.speed = speed;
    }

    public int getIdWind() {
        return idWind;
    }

    public void setIdWind(int idWind) {
        this.idWind = idWind;
    }

    public int getChill() {
        return chill;
    }

    public void setChill(int chill) {
        this.chill = chill;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "idWind=" + idWind +
                ", chill=" + chill +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}
