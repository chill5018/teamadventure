import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // Set path of Layout
    String layout = "templates/layout.vtl";

    // GET: Show a page "/some/path"
    get("/", (request, response) -> {
      HashMap model = new HashMap();

      // path to page you wish to apply on the
      // layout aka. the body text
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
