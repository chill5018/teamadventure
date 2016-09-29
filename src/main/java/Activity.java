/**
 * Created by Filip on 29-09-2016.
 */
public class Activity {
    private String name;
    private String place;
    private int capacity;
    private int minAge;
    private double price;
    private int time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }


    public Activity(String name, String place, double price, int time, int capacity, int minAge){
        this.name = name;
        this.place = place;
        this.price = price;
        this.time = time;
        this.capacity = capacity;
        this.minAge = minAge;
    }
}