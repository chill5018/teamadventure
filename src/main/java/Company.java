import java.util.ArrayList;
import java.util.*;

/**
 * Created by Benny and Dan on 9/29/2016.
 */
public class Company extends Customer {
    private String compName;
    private int numPeople;
    private static ArrayList<Company> instances = new ArrayList<>();
    private int id;

    public Company(String fName, String lName, int telNum, String reservationDate, int age)
    {
        super(fName, lName, telNum, reservationDate, age);
        this.id = instances.size();

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


    public static List<Company> allCompany() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
     return id;
    }
}
