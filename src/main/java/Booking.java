import java.util.ArrayList;
import java.util.List;

public class Booking {
  private Activity selectedActivity;
  private Customer customer;
  private Customer company;
  private double totalPrice;
  private static ArrayList<Booking> instances = new ArrayList<Booking>();
  private int id;


  public Booking(Activity activity) {
    this.selectedActivity = activity;

    this.id = instances.size();
  }

  public Booking(Customer customer)
  {
    this.customer = customer;
  }

  public Booking( Activity activity, Customer customer)
  {
    this.customer = customer;
    this.selectedActivity = activity;
  }

  public void setSelectedActivity(Activity selectedActivity) {
    this.selectedActivity = selectedActivity;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Activity getActivity() {
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

  public void setId(int id) {
    this.id = id;
  }

  public double getTotalPrice() {
    return selectedActivity.getPrice() * customer.getNumOfPeople();
  }

}
