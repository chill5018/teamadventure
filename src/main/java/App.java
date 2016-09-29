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
    get("/", (request, response) -> {
      HashMap model = new HashMap();

      // path to page you wish to apply on the
      // layout aka. the body text
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/activities", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activites.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    get("/activities/new", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     model.put("template", "templates/activites-new.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/bookings", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/bookings.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

   get("/bookings/new/individuals/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/individuals.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/bookings/new/companies/new", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();
   model.put("template", "templates/companies.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());

   get("/bookings/customers", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/customers.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   post("/bookings", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
    //  model.put("bookings", Booking.all());
     model.put("template", "templates/booking-success.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

  }
}
