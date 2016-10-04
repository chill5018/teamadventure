import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import template.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  private static ArrayList<Customer> customers = new ArrayList<>();
  private static ArrayList<Company> companies = new ArrayList<>();
  private static ArrayList<Activity> activities = new ArrayList<>();
  private static ArrayList<Booking> bookings = new ArrayList<>();

  public static void main(String[] args) {
    // Set path of Layout
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    // -----------------------------------//
    //               HOMEPAGE             //
    //------------------------------------//
    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


      // -----------------------------------//
      //         Activity Overview          //
      //------------------------------------//

      get("/activityoverview", (request, response) -> {
          HashMap model = new HashMap();
          model.put("template", "templates/activityoverview.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/activityoverview",(request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      activities = request.session().attribute("activityoverview");

      if ( activities == null)
      {
        activities = new ArrayList<Activity>();
        request.session().attribute("activityoverview", activities);
      }

      String time = request.queryParams("timetex  tbox");
      Activity newActivity = new Activity("", "", 10 , 10, 10, 10 );
      activities.add(newActivity);

      model.put("template", "templates/activitysave.vtl");
      return new ModelAndView(model,layout);
    },new VelocityTemplateEngine());

    get("/activitysave", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/activitysave.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



    // -----------------------------------//
    //             Activity               //
    //------------------------------------//

    // Show All Activities "with the create button"
    get("/activities", (request, response) -> {
        boolean activityDemo=true;
     HashMap<String, Object> model = new HashMap<String, Object>();
     HashSet<Activity> activities = request.session().attribute("activities");
        if (activities == null) {
            activities = new HashSet<Activity>();
            request.session().attribute("activities", activities);
            activities.add(new Activity("Kart-Go","Copenhagen",370, 21, 6, 12,"/Images/kart-go.jpg"));
            activities.add(new Activity("Mini Golf","Copenhagen",210, 18, 20, 6,"/Images/minigolf.jpg"));
            activities.add(new Activity("Paintball","Copenhagen",200, 5, 20, 23, "/Images/paintball.jpg"));
            activities.add(new Activity("Sumo","Copenhagen",180, 6, 06, 18, "/Images/sumo.png"));
        }

     model.put("activities", request.session().attribute("activities"));
     model.put("template", "templates/activities-with-edit.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   // Show Selected Activity
   get("/activities/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activities.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

   // Edit Selected Activity
   get("/activities/:id/edit", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activities.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

   // "Save / Update" Selected Activity
   post("/activities/:id/edit", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activities.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  // -----------------------------------//
  //             Booking                //
  //------------------------------------//

   // Activity Selector for Booking
    get("/bookings/new/choose-activity", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activities.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Show the Create new Activity Form
    get("/activity-new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activity-new.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // View All Bookings
   get("/bookings", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/bookings.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // View Booking with ID
  get("/bookings/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/bookings.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


   get("/bookings/new/create-family", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/individuals.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/customers", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    /*
    If request.session().attribute("customers"); returned null, then our variable
    customers will be referencing null. So we can use if (customers == null) to create
    and save customers into the session. We create a new empty ArrayList of Customers
    with the line customers = new ArrayList<Task>();. Then, we save that new
    ArrayList of Customers into the session with
    request.session().attribute("customers", customers);.
    */

    ArrayList<Customer> customers = request.session().attribute("customers");
    if (customers == null) {
      customers = new ArrayList<Customer>();
      request.session().attribute("customers", customers);
    }

    /*
    Next, we create our Task object as we were already doing before,
    sand then we add it into customers with: customers.add(newTask);
    */
    String fName = request.queryParams("first_name");
    String lName = request.queryParams("last_name");
    // int numOfPeople = Integer.parseInt(request.queryParams("family_size"));
    // int minAge = Integer.parseInt(request.queryParams("min_age"));
    String phoneNum = request.queryParams("phone_number-indiv");
    String email = request.queryParams("email-indiv");
    Customer newCustomer = new Customer(fName, lName, phoneNum, email, null, 15, 2);
    customers.add(newCustomer); // Add new Customer to list of Customers

    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/companies", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();

    /*
    If request.session().attribute("companies"); returned null, then our variable
    companies will be referencing null. So we can use if (companies == null) to create
    and save companies into the session. We create a new empty ArrayList of Customers
    with the line companies = new ArrayList<Task>();. Then, we save that new
    ArrayList of Customers into the session with
    request.session().attribute("companies", companies);.
    */

    ArrayList<Company> companies = request.session().attribute("companies");
    if (companies == null) {
      companies = new ArrayList<Company>();
      request.session().attribute("companies", companies);
    }

    /*
    Next, we create our Task object as we were already doing before,
    sand then we add it into companies with: companies.add(newTask);
    */
    String compName = request.queryParams("company_name");
    String fName = request.queryParams("first_name");
    String lName = request.queryParams("last_name");
    //int numOfPeople = Integer.parseInt(request.queryParams("company_size"));
    // int minAge = Integer.parseInt(request.queryParams("min_age"));
    String phoneNum = request.queryParams("phone_number");
    String email = request.queryParams("email");
    Company newCompany = new Company(compName,fName, lName, phoneNum, email, null, 15, 2);
    companies.add(newCompany); // Add new Company to list of Companies

    model.put("template", "templates/company-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

      post("/activity", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          ArrayList<Activity> activities = request.session().attribute("activities");
          if (activities == null) {
              activities = new ArrayList<>();
              request.session().attribute("activity", activities);
          }

          String name = request.queryParams("name");
          String place = request.queryParams("place");
          Double price = Double.parseDouble(request.params("price"));
          int time = Integer.parseInt(request.queryParams("time"));
          int capacity = Integer.parseInt(request.queryParams("capacity"));
          int minAge = Integer.parseInt(request.queryParams("min-age"));
          String imgSrc = request.queryParams("imgSrc");
          activities.add(new Activity(name,place,price,time,capacity,minAge,imgSrc));
          model.put("template", "templates/success-activity.vtl");

          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

  // Show the Create new Activity Form
   get("/activities/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activites-new.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  // View All Bookings (Existing Bookings)
  get("/bookings", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/bookings.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

   // Booking Flow Step 2:
   get("/bookings/new/select-activity", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/activities-booking.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Select Customer Type
   get("/bookings/new/choose-customer-type", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/customers-select.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Create a Company
   get("/bookings/new/create-company", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/customers-create-company.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // Create a Person
  get("/bookings/new/create-family", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/customers-create-individual.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

  // Create a Person
  get("/bookings/new/create-family", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/customers-create-individual.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 // Save a customer entered in the form.
 post("/customers", (request, response) -> {
   Map<String, Object> model = new HashMap<String, Object>();

   /*
   If request.session().attribute("customers"); returned null, then our variable
   customers will be referencing null. So we can use if (customers == null) to create
   and save customers into the session. We create a new empty ArrayList of Customers
   with the line customers = new ArrayList<Task>();. Then, we save that new
   ArrayList of Customers into the session with
   request.session().attribute("customers", customers);.
   */

   customers = request.session().attribute("customers");
   if (customers == null) {
     customers = new ArrayList<Customer>();
     request.session().attribute("customers", customers);
   }

   /*
   Next, we create our Task object as we were already doing before,
   sand then we add it into customers with: customers.add(newTask);
   */
   String fName = request.queryParams("first_name");
   String lName = request.queryParams("last_name");
   // int numOfPeople = Integer.parseInt(request.queryParams("family_size"));
   // int minAge = Integer.parseInt(request.queryParams("min_age"));
   String phoneNum = request.queryParams("phone_number-indiv");
   String email = request.queryParams("email-indiv");
   Customer newCustomer = new Customer(fName, lName, phoneNum, email, null, 15, 2);
   customers.add(newCustomer); // Add new Customer to list of Customers

   model.put("template", "templates/booking-overview.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 // Save a company entered in the form
 post("/bookings/new/customers/add", (request, response) -> {
   Map<String, Object> model = new HashMap<String, Object>();

   /*
   If request.session().attribute("companies"); returned null, then our variable
   companies will be referencing null. So we can use if (companies == null) to create
   and save companies into the session. We create a new empty ArrayList of Customers
   with the line companies = new ArrayList<Task>();. Then, we save that new
   ArrayList of Customers into the session with
   request.session().attribute("companies", companies);.
   */

   companies = request.session().attribute("companies");
   if (companies == null) {
     companies = new ArrayList<Company>();
     request.session().attribute("companies", companies);
   }

   /*
   Next, we create our Task object as we were already doing before,
   sand then we add it into companies with: companies.add(newTask);
   */
   String compName = request.queryParams("company_name");
   String fName = request.queryParams("first_name");
   String lName = request.queryParams("last_name");
   //int numOfPeople = Integer.parseInt(request.queryParams("company_size"));
   // int minAge = Integer.parseInt(request.queryParams("min_age"));
   String phoneNum = request.queryParams("phone_number");
   String email = request.queryParams("email");
   Company newCompany = new Company(compName,fName, lName, phoneNum, email, null, 15, 2);
   companies.add(newCompany); // Add new Company to list of Companies

   model.put("template", "templates/booking-overview.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());


   // "Save / Update" a booking
   post("/bookings", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/booking-success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   // View All Customers
   get("/customers/all", (request, repsonse) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("customers", request.session().attribute("customers"));
     model.put("template", "templates/customer-list.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // View All Customers
   get("/companies/all", (request, repsonse) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("companies", request.session().attribute("companies"));
     model.put("template", "templates/company-list.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
