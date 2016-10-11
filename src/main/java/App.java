import spark.ModelAndView;
import template.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {
  private static ArrayList<Customer> customers = new ArrayList<>();
  private static ArrayList<Activity> activities = new ArrayList<>();
  private static ArrayList<Booking> bookings = new ArrayList<>();
  private static ArrayList<Item> items = new ArrayList<>();

  public static void main(String[] args) {
    // Set path of Layout
    String layout = "templates/layout.vtl";
    String layoutIndex = "templates/layout-index.vtl";
    staticFileLocation("/public");
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


    // -----------------------------------//
    //               HOMEPAGE             //
    //------------------------------------//
    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layoutIndex);
    }, new VelocityTemplateEngine());


      // -----------------------------------//
      //         Activity Overview          //
      //------------------------------------//

      get("/activityoverview/:id", (request, response) -> {
          HashMap model = new HashMap();
          int idBooking = Integer.parseInt(request.params(":id"));
          request.session().attribute("idBooking", idBooking);
          model.put("template", "templates/activityoverview.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

    post("/activityoverview",(request,response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/activityoverview.vtl");
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
        request.session().attribute("activities", activities);

     model.put("activities", activities);
     model.put("template", "templates/activities-with-edit.vtl");
     return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  //  // Show Selected Activity
        get("/activities/:id/view", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        int id = Integer.parseInt(request.params(":id"));
        Activity aux = activities.get(id);
        model.put("activity", aux);
        model.put("template", "templates/activity-view.vtl");
        return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
  //
  //  // Edit Selected Activity
  //  get("/activities/:id/edit", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   model.put("template", "templates/activites.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());
  //
  //  // "Save / Update" Selected Activity
  //  post("/activities/:id/edit", (request, response) -> {
  //   HashMap<String, Object> model = new HashMap<String, Object>();
  //   model.put("template", "templates/activites.vtl");
  //   return new ModelAndView(model, layout);
  // }, new VelocityTemplateEngine());


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
    get("/activities/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activity-new.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Show the Create new Activity Form
    get("/items/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/items-new.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // View All Bookings
   get("/bookings", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("bookings", bookings);
    model.put("template", "templates/bookings.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

//Edit Booking
  get("/bookings/:id/edit", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
      int idEditB = Integer.parseInt(request.params(":id"));
      model.put("booking", bookings.get(idEditB));
      request.session().attribute("idEditB", idEditB);
   model.put("template", "templates/bookings-edit.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

      post("/booking/edit/success", (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          int id = request.session().attribute("idEditB");
          //Activity edit
          String name = request.queryParams("Name");
          String sPrice = request.queryParams("price");
          String sTime = request.queryParams("time");
          String sCapacity = request.queryParams("capacity");
          String sMinAge = request.queryParams("minimum-age");

          Double price = Double.parseDouble(sPrice);
          int time = Integer.parseInt(sTime);
          int capacity = Integer.parseInt(sCapacity);
          int minAge = Integer.parseInt(sMinAge);
          String imgSrc = request.queryParams("image-path");

          bookings.get(id).getActivity().setName(name);
          bookings.get(id).getActivity().setImgSrc(imgSrc);
          bookings.get(id).getActivity().setCapacity(capacity);
          bookings.get(id).getActivity().setMinAge(minAge);
          bookings.get(id).getActivity().setPrice(price);
          bookings.get(id).getActivity().setTime(time);

          //Customer Edit
          String fName = request.queryParams("first-Name");
          String lName = request.queryParams("last-Name");
          String sNumOfPeople = request.queryParams("number-of-people");
          String sMinAgeC = request.queryParams("age-of-Youngest");
          String phoneNum = request.queryParams("Phone");
          String email = request.queryParams("email");


          int minAgeC = Integer.parseInt(sMinAgeC);
          int numPeople = Integer.parseInt(sNumOfPeople);

          bookings.get(id).getCustomer().setAge(minAgeC);
          bookings.get(id).getCustomer().setfName(fName);
          bookings.get(id).getCustomer().setlName(lName);
          bookings.get(id).getCustomer().setEmail(email);
          bookings.get(id).getCustomer().setNumOfPeople(numPeople);
          bookings.get(id).getCustomer().setTelNum(phoneNum);


          model.put("template", "templates/booking-success.vtl");
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
    String companyName = request.queryParams("comp_name");
    String fName = request.queryParams("first_name");
    String lName = request.queryParams("last_name");
    // int numOfPeople = Integer.parseInt(request.queryParams("family_size"));
    // int minAge = Integer.parseInt(request.queryParams("min_age"));
    String phoneNum = request.queryParams("phone_number-indiv");
    String email = request.queryParams("email-indiv");
    Customer newCustomer;
      if (companyName != null) {
          newCustomer = new Customer(companyName, fName, lName, phoneNum, email, null, 15, 2);
      }
      else {
          newCustomer = new Customer(fName, lName, phoneNum, email, null, 15, 2);
      }
    customers.add(newCustomer); // Add new Customer to list of Customers

    model.put("template", "templates/customer-success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/activity", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      activities = new ArrayList<Activity>();
      activities = request.session().attribute("activities");
      if (activities == null) {
          request.session().attribute("activities", activities);
      }

      String name = request.queryParams("name");
      String sPrice = request.queryParams("price");
      String sTime = request.queryParams("time");
      String sCapacity = request.queryParams("capacity");
      String sMinAge = request.queryParams("min-age");

      Double price = Double.parseDouble(sPrice);
      int time = Integer.parseInt(sTime);
      int capacity = Integer.parseInt(sCapacity);
      int minAge = Integer.parseInt(sMinAge);
      String imgSrc = request.queryParams("imgSrc");
      activities.add(new Activity(name,price,time,capacity,minAge,imgSrc));
      activities.get(activities.size()-1).setId(activities.size()-1);
      model.put("template", "templates/success-activity.vtl");

      return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


    post("/activity/:id/edit", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        int id = Integer.parseInt(request.params(":id"));
        String name = request.queryParams("name");
        String sPrice = request.queryParams("price");
        String sTime = request.queryParams("time");
        String sCapacity = request.queryParams("capacity");
        String sMinAge = request.queryParams("min-age");

        Double price = Double.parseDouble(sPrice);
        int time = Integer.parseInt(sTime);
        int capacity = Integer.parseInt(sCapacity);
        int minAge = Integer.parseInt(sMinAge);
        String imgSrc = request.queryParams("imgSrc");

        activities.get(id).setName(name);
        activities.get(id).setImgSrc(imgSrc);
        activities.get(id).setCapacity(capacity);
        activities.get(id).setMinAge(minAge);
        activities.get(id).setPrice(price);
        activities.get(id).setTime(time);
        model.put("template", "templates/success-activity.vtl");

        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

   // Booking Flow Step 2:
   get("/bookings/new/select-activity", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
       bookings = request.session().attribute("bookings");
       if (bookings == null) {
           bookings = new ArrayList<>();
           request.session().attribute("bookings", bookings);
       }

     model.put("activities", activities);
     model.put("template", "templates/activities-booking.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Select Customer Type
   post("/bookings/new/choose-customer-type", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     int id = request.session().attribute("idBooking");
     String sTime = request.queryParams("timebox");
     int time = Integer.parseInt(sTime);
     activities.get(id).setTime(time);
     Booking aux = new Booking(activities.get(id));
     bookings.add(aux);
     bookings.get(bookings.size()-1).setId(bookings.size()-1);
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


 // Save a customer entered in the form.
 post("/bookings/new/customers/add/individual", (request, response) -> {
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
     bookings.get(bookings.size()-1).setCustomer(newCustomer);
   model.put("template", "templates/customer-success.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

 // Save a company entered in the form
 post("/bookings/new/customers/add/company", (request, response) -> {
   Map<String, Object> model = new HashMap<String, Object>();

   /*
   If request.session().attribute("companies"); returned null, then our variable
   companies will be referencing null. So we can use if (companies == null) to create
   and save companies into the session. We create a new empty ArrayList of Customers
   with the line companies = new ArrayList<Task>();. Then, we save that new
   ArrayList of Customers into the session with
   request.session().attribute("companies", companies);.
   */

    customers = new ArrayList<Customer>();
    request.session().attribute("customers", customers);




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
   Customer newCompany = new Customer(compName,fName, lName, phoneNum, email, null, 15, 2);
   customers.add(newCompany); // Add new Company to list of Companies
   bookings.get(bookings.size()-1).setCustomer(newCompany);         
   model.put("template", "templates/company-success.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());





   // View All Customers
   get("/customers/all", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("customers", request.session().attribute("customers"));
     model.put("template", "templates/customer-list.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   // Bookings Overview
   get("/bookings/new/overview", (request, response) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("customers", request.session().attribute("customers"));
     model.put("companies", request.session().attribute("companies"));
     model.put("activities", activities);
     model.put("template", "templates/booking-overview.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // -----------------------------------//
   //             Items                  //
   //------------------------------------//

   // Show All items "with the view button"
   get("/items", (request, response) -> {
       boolean activityDemo=true;
    HashMap<String, Object> model = new HashMap<String, Object>();
       request.session().attribute("items",items);

    model.put("items", items);
    model.put("template", "templates/items.vtl");
    return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // handling user input for the add new item

   post("/new-item", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       items = new ArrayList<Item>();
       items = request.session().attribute("items");
       if (items == null) {
           request.session().attribute("items", items);
       }

       // getting data from the input fields
       String name = request.queryParams("name");
       String price = request.queryParams("price");
       String description = request.queryParams("description");
       String imageUrl = request.queryParams("imageUrl");

       items.add(new Item(name,Double.parseDouble(price),description,imageUrl));
       //items.get(items.size()-1).setId(items.size()-1);
       model.put("template", "templates/index.vtl");

       return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
