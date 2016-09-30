import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

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
    //             Activity               //
    //------------------------------------//

    // Show All Activities "with the create button"
    get("/activities", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activites.vtl");
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



  }
}
