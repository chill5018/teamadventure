import java.util.*;

public class Booking {
  private Activity selectedActivity;
  private Customer customer;
  private Company company;
  private double totalPrice;
  private static ArrayList<Booking> instances = new ArrayList<Booking>();
  private int id;

  public Booking(Activity activity, Customer customer, Company company, double totalPrice) {
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
