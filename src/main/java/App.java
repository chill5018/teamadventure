import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import template.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    // Set path of Layout
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    // GET: Show a page "/some/path"
    // Default landing page.
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


    // -----------------------------------//
    //             Activity               //
    //------------------------------------//

    // Show All Activities "with the create button"
    get("/activities", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activities.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Show Selected Activity
   get("/activities/:id", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activites.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

   // Edit Selected Activity
   get("/activities/:id/edit", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activites.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

   // "Save / Update" Selected Activity
   post("/activities/:id/edit", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activites.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());


  // -----------------------------------//
  //             Booking                //
  //------------------------------------//

   // Activity Selector for Booking
    get("/bookings/new/choose-activity", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activites.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // Show the Create new Activity Form
    get("/activities/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activites-new.vtl");
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

  // Show the Create new Activity Form
   get("/activities/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/activites-new.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // View All Bookings
  get("/bookings", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/bookings.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());


  get("/bookings/new/create-company", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/companies.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

   get("/bookings/new/choose-customer-type", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/customers.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   // "Save / Update" a booking
   post("/bookings", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/booking-success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


   get("/customers/all", (request, repsonse) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("customers", request.session().attribute("customers"));
     model.put("template", "templates/customer-list.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/companies/all", (request, repsonse) -> {
     Map<String, Object> model = new HashMap<String, Object>();
     // Get the task created from the session and show it on the homepage
     model.put("companies", request.session().attribute("companies"));
     model.put("template", "templates/company-list.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
