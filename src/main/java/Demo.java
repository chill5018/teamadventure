import java.util.*;

public class Demo {
  public static ArrayList<Customer> customers = new ArrayList<>();
  public static ArrayList<Customer> companies = new ArrayList<>();
  public static ArrayList<Activity> activities = new ArrayList<>();
  public static ArrayList<Booking> bookings = new ArrayList<>();
  public static ArrayList<Item> items = new ArrayList<>();

  public Demo(){

    activities.add(new Activity("Kart-Go",370, 21, 6, 12,"/images/kart-go.jpg"));
    activities.get(activities.size()-1).setId(activities.size()-1);
    activities.add(new Activity("Mini-Golf",210, 18, 20, 6,"/images/minigolf.jpg"));
    activities.get(activities.size()-1).setId(activities.size()-1);
    activities.add(new Activity("Paintball",200, 5, 20, 23, "/images/paintball.jpg"));
    activities.get(activities.size()-1).setId(activities.size()-1);
    activities.add(new Activity("Sumo",180, 6, 06, 18, "/images/sumo.png"));
    activities.get(activities.size()-1).setId(activities.size()-1);

    items.add(new Item("Popcorn", 20.00, "Deliciously fresh baked movie like butter popcorn", "/images/popcorn.jpg"));
    items.add(new Item("Bacon", 13.99, "Fresh and saucy pig rear bacon", "/images/bacon.jpg"));
    items.add(new Item("Coca-Cola", 13.32, "World wide knonw refreshment drink","images/coca-cola.JPG"));
    items.add(new Item("Sparkling water", 15.43, "Refreshing and cooling natural source sparkling water","images/water.JPG"));

    customers.add(new Customer("Extreme Tech Nerds" ,"Bill","Clinton","453323443", "Customer1@Customer.com","12-10-2016-20:30",42, 34));
    customers.add(new Customer("Rainmaking Lofts" ,"Per","Larsen","45134124", "Customer2@Customer.com","11-10-2016-20:30",23, 15));
    customers.add(new Customer("Rocket Labs" ,"Javier","Rivera","451391341", "Customer3@Customer.com","11-10-2016-20:30",18, 24));
    customers.add(new Customer("Nerds R Us" ,"Andrei","Dogaru","4569812423", "Customer4@Customer.com","18-10-2016-20:30",19, 4));
    customers.add(new Customer("individual","Claudiu","Robciuc","455678302", "cust1@customers.com","16-10-2016-12:30",20, 4));
    customers.add(new Customer("Individual","Fred","Smith","455678303", "cust2@customers.com","18-10-2016-18:30",15, 2));
    customers.add(new Customer("Individual","Bob","Larsen","455678304", "cust3@customers.com","20-10-2016-18:30",12, 3));
    customers.add(new Customer("Individual","Alice","Hill","455678305", "cust4@customers.com","11-10-2016-17:30",16, 1));
    customers.add(new Customer("Individual","Tonje","Peterson","455634303", "cust5@customers.com","02-10-2016-13:30",20, 1));

    bookings.add(new Booking(activities.get(0), customers.get(0)));
    bookings.add(new Booking(activities.get(1), customers.get(1)));
    bookings.add(new Booking(activities.get(2), customers.get(2)));
    bookings.add(new Booking(activities.get(3), customers.get(3)));
    bookings.add(new Booking(activities.get(0), customers.get(4)));
    bookings.add(new Booking(activities.get(1), customers.get(5)));
    bookings.add(new Booking(activities.get(2), customers.get(6)));
    bookings.add(new Booking(activities.get(3), customers.get(7)));
    bookings.add(new Booking(activities.get(1), customers.get(3)));
    bookings.add(new Booking(activities.get(0), customers.get(2)));
  }

  public static ArrayList<Customer> getCustomers() {
    return customers;
  }

  public static ArrayList<Customer> getCompanies() {
    return companies;
  }

  public static ArrayList<Activity> getActivities() {
    return activities;
  }

  public static ArrayList<Booking> getBookings() {
    return bookings;
  }

  public static ArrayList<Item> getItems() {
    return items;
  }
}
