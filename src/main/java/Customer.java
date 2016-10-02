import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ClaudiuRBC and Gosia on 9/29/2016.
 */
public class Customer {
    private String fName;
    private String lName;
    private String telNum;
    private String reservationDate;
    private String email;
    private int age;
    private int numOfPeople;

    public Customer() {

    }

    public Customer(String fName, String lName, String telNum, String email, String reservationDate, int age, int numOfPeople) {
        this.fName = fName;
        this.lName = lName;
        this.telNum = telNum;
        this.email = email;
        this.age = age;
        this.numOfPeople = numOfPeople;
        this.reservationDate = reservationDate;
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

}
