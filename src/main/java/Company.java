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

    public Company(String compName, String fName, String lName, String telNum, String email, String reservationDate, int age, int numOfPeople)
    {
        super(fName, lName, telNum, email, reservationDate, age, numOfPeople);
        this.compName = compName;
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
