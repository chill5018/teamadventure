<<<<<<< 385fb2d125ad54c53dd4cf1b4f1c98b5b97adb0b
import java.util.ArrayList;
import java.util.Date;
=======
import java.util.*;

public class Booking {
  private Activity selectedActivity;
  private Customer customer;
  private Company company;
  private double totalPrice;
  private static ArrayList<Booking> instances = new ArrayList<Booking>();
  private int id;

  public Booking(Activity activity, Customer customer, Company company) {
    this.selectedActivity = activity;
    this.customer = customer;
    this.company = company;
    this.totalPrice = totalPrice;
    this.id = instances.size();
  }

  public Activity getSelectedActivity() {
    return selectedActivity;
  }

  public Customer getCustomer() {
    return customer;
  }

  public double getTotalPriceFamily() {
    return selectedActivity.getPrice() * customer.getNumOfPeople();
  }

  public double getTotalPriceCompany() {
    return selectedActivity.getPrice() * company.getNumOfPeople();


  public static List<Booking> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
   return id;
  }

  public double getTotalPrice() {
    return selectedActivity.getPrice() * customer.getNumOfPeople();
  }

}
