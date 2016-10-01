import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

// This will be the home for running the more complex
// tests, making sure the UI works the way it should
public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  // Check to make sure that the server is working
  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Adventure Zone");
  }

  // Check to see if the form is proccessed
  // and is showing the success page [WIP]
  // @Test
  // public void customerIsCreatedTest() {
  //   goTo("http://localhost:4567/bookings/new/create-family");
  //   fill("#first_name").with("Colin");
  //   submit(".btn-blue");
  //   assertThat(pageSource()).contains("Customer");
  // }
  //
  // // Test to see if our newly created task
  // // is visible on the home page
  // @Test
  // public void taskIsDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  // }
  //
  // // Create a test that can display multiple tasks
  // @Test
  // public void multipleTasksAreDisplayedTest() {
  //   goTo("http://localhost:4567/");
  //   fill("#description").with("Mow the lawn");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   fill("#description").with("Buy groceries");
  //   submit(".btn");
  //   click("a", withText("Go Back"));
  //   assertThat(pageSource()).contains("Mow the lawn");
  //   assertThat(pageSource()).contains("Buy groceries");
  // }

}
