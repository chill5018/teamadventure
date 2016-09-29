import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Benny and Dan on 9/29/2016.
 */
public class Company extends Customer {
    private String compName;
    private int numPeople;
    private static ArrayList<Customer> instances = new ArrayList<>();
    private int id;

    public Company(String fName, String lName, int telNum, String reservationDate, int age)
    {
        super(fName, lName, telNum, reservationDate, age);

    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public static ArrayList<Customer> getInstances() {
        return instances;
    }

    public static void setInstances(ArrayList<Customer> instances) {
        Company.instances = instances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
