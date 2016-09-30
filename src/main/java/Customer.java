import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ClaudiuRBC and Gosia on 9/29/2016.
 */
public class Customer {
    private String fName;
    private String lName;
    private int telNum;
    private String reservationDate;
    private String eMail;
    private int age;
    private int numOfPeople;

    private static ArrayList<Customer> instances = new ArrayList<Customer>();
    private int id;

    public Customer() {

    }

    public Customer(String fName, String lName, int telNum, String reservationDate, int age) {
        this.fName = fName;
        this.lName = lName;
        this.telNum = telNum;
        this.age = age;
        this.reservationDate = reservationDate;
        this.id = instances.size();


    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getNumOfPeople() {
      return numOfPeople;
    }

    public static List<Customer> allCustomers() {
      return instances;
    }

    public static void clear() {
      instances.clear();
    }

    public int getId() {
     return id;
    }

}
