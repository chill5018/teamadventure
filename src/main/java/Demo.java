import java.util.*;

public class Demo {
  public static ArrayList<Customer> customers = new ArrayList<>();
  public static ArrayList<Customer> companies = new ArrayList<>();
  public static ArrayList<Activity> activities = new ArrayList<>();
  public static ArrayList<Booking> bookings = new ArrayList<>();

  {
    Customer cust1 = new Customer("Claudiu","Robciuc","455678302", "cust1@customers.com","16-10-2016-12:30",20, 4);
    Customer cust2 = new Customer("Fred","Smith","455678303", "cust2@customers.com","18-10-2016-18:30",15, 2);
    Customer cust3 = new Customer("Bob","Larsen","455678304", "cust3@customers.com","20-10-2016-18:30",12, 3);
    Customer cust4 = new Customer("Alice","Hill","455678305", "cust4@customers.com","11-10-2016-17:30",16, 1);
    Customer cust5 = new Customer("Tonje","Peterson","455634303", "cust5@customers.com","02-10-2016-13:30",20, 1);
    Customer cust6 = new Customer("Ida","Thompson","455674503", "cust6@customers.com","02-10-2016-16:30",27, 1);
    Customer cust7 = new Customer("Bill","Williams","455673303", "cust7@customers.com","02-10-2016-15:30",56, 2);
    Customer cust8 = new Customer("Scott","Smith","4556783453", "cust8@customers.com","02-10-2016-18:30",24, 3);
    Customer cust9 = new Customer("John","Jones","455676353", "cust8@customers.com","02-10-2016-19:30",26, 2);
    Customer cust10 = new Customer("Zander","Edwards","455645363", "cust10@customers.com","02-10-2016-11:30",23, 1);

    customers.add(cust1);
    customers.add(cust2);
    customers.add(cust3);
    customers.add(cust4);
    customers.add(cust5);
    customers.add(cust6);
    customers.add(cust7);
    customers.add(cust8);
    customers.add(cust9);
    customers.add(cust10);

    Customer comp1 = new Customer("Extreme Tech Nerds" ,"Bill","Clinton","453323443", "Customer1@Customer.com","12-10-2016-20:30",42, 34);
    Customer comp2 = new Customer("Rainmaking Lofts" ,"Per","Larsen","45134124", "Customer2@Customer.com","11-10-2016-20:30",23, 15);
    Customer comp3 = new Customer("Rocket Labs" ,"Javier","Rivera","451391341", "Customer3@Customer.com","11-10-2016-20:30",18, 24);
    Customer comp4 = new Customer("Nerds R Us" ,"Andrei","Dogaru","4569812423", "Customer4@Customer.com","18-10-2016-20:30",19, 4);

    companies.add(comp1);
    companies.add(comp2);
    companies.add(comp3);
    companies.add(comp4);


    Activity paintball = new Activity("Paintball", 500, 1500, 15, 12,"images/kart-g.jpg");
    Activity sumo = new Activity("Sumo", 200, 1500, 15, 12, "images/minigolf.jpg");
    Activity miniGolf = new Activity("MiniGolf", 200, 1500, 15, 2, "images/paintball.jpg");
    Activity goKarts = new Activity("Go-Kart", 200, 1500, 15, 12, "images/sumo.png");

    activities.add(paintball);
    activities.add(sumo);
    activities.add(miniGolf);
    activities.add(goKarts);


    Booking book1 = new Booking(paintball, cust1);
    Booking book2 = new Booking(paintball, cust3);
    Booking book3 = new Booking(sumo, cust5);
    Booking book4 = new Booking(sumo, cust3);
    Booking book5 = new Booking(paintball, cust2);
    Booking book6 = new Booking(miniGolf, cust6);
    Booking book7 = new Booking(miniGolf, cust7);
    Booking book8 = new Booking(goKarts, cust8);
    Booking book9 = new Booking(goKarts, cust10);
    Booking book10 = new Booking(paintball, cust9);
    Booking book11 = new Booking(sumo, cust4);
    Booking book12 = new Booking(paintball, comp2);
    Booking book13 = new Booking(miniGolf, comp3);
    Booking book14 = new Booking(goKarts, comp1);
    Booking book15 = new Booking(sumo, comp4);

    bookings.add(book1);
    bookings.add(book2);
    bookings.add(book3);
    bookings.add(book4);
    bookings.add(book5);
    bookings.add(book6);
    bookings.add(book7);
    bookings.add(book8);
    bookings.add(book9);
    bookings.add(book10);
    bookings.add(book11);
    bookings.add(book12);
    bookings.add(book13);
    bookings.add(book14);
    bookings.add(book15);
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
}
