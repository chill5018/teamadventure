import java.util.HashMap;

import spark.ModelAndView;
import template.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // Set path of Layout
    String layout = "templates/layout.vtl";
    staticFileLocation("/public");

    get("/home", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/index", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/activities", (request, response) -> {
      HashMap model = new HashMap();

      model.put("template", "templates/activities.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
