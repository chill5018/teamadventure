import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 29-09-2016.
 */


public class Activity {
    private String name;
    private int capacity;
    private int minAge;
    private double price;
    private int time;
    private String imgSrc;
    private static ArrayList<Activity> instances = new ArrayList<Activity>();
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public static List<Activity> all() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
     return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public Activity(String name, String imgSrc)
    {
        this.name = name;
        this.id = instances.size();
        this.imgSrc = imgSrc;
    }
    public Activity(String name, double price, int time, int capacity, int minAge, String imgSrc){
        this.name = name;
        this.price = price;
        this.time = time;
        this.capacity = capacity;
        this.minAge = minAge;
        this.imgSrc = imgSrc;
    }
}
