import java.util.ArrayList;
import java.util.List;

/**
 * Created by ClaudiuRBC and Gosia on 9/29/2016.
 * Updated by Benny and Oana on 10/6/2016.
 */
public class Customer {
    private String companyName;
    private String fName;
    private String lName;
    private String telNum;
    private String reservationDate;
    private String email;
    private int age;
    private int numOfPeople;

    private static ArrayList<Customer> instances = new ArrayList<Customer>();
    private int id;

    public Customer() {

    }

    public Customer(String companyName, String fName, String lName, String telNum, String email, String reservationDate, int age, int numOfPeople) {
        this.companyName = companyName;
        this.fName = fName;
        this.lName = lName;
        this.telNum = telNum;
        this.email = email;
        this.age = age;
        this.numOfPeople = numOfPeople;
        this.reservationDate = reservationDate;
        this.id = instances.size();
    }

    public Customer(String fName, String lName, String telNum, String email, String reservationDate, int age, int numOfPeople) {
        this.fName = fName;
        this.lName = lName;
        this.telNum = telNum;
        this.email = email;
        this.age = age;
        this.numOfPeople = numOfPeople;
        this.reservationDate = reservationDate;
        this.id = instances.size();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
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
