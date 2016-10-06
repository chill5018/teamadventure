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
    assertThat(pageSource()).contains("Adventure Alley");
  }

  // Check to see if the form is proccessed
  // and is showing the success page [WIP]
  @Test
  public void customerIsCreatedTest() {
    goTo("http://localhost:4567/bookings/new/create-family");
    fill("#first_name").with("John");
    submit(".btn-blue");
    goTo("http://localhost:4567/customers/all");
    assertThat(pageSource()).contains("John");
  }

  @Test
  public void companyIsCreatedTest() {
    goTo("http://localhost:4567/bookings/new/create-company");
    fill("#company_name").with("Nike");
    submit(".btn-blue");
    goTo("http://localhost:4567/companies/all");
    assertThat(pageSource()).contains("Nike");
  }
  //
  //Activity tests
  @Test
  public  void activityKartTest(){

    goTo("http://localhost:4567/activities");
    assertThat(pageSource()).contains("Kart-Go");
  }

  @Test
  public  void activitySumoTest(){
    goTo("http://localhost:4567/activities");
    assertThat(pageSource()).contains("Sumo");
  }

  @Test
  public  void activityPaintballTest(){
    goTo("http://localhost:4567/activities");
    assertThat(pageSource()).contains("Paintball");
  }

  @Test
  public  void activityMinigolfTest(){
    goTo("http://localhost:4567/activities");
    assertThat(pageSource()).contains("Mini-Golf");
  }

  @Test
  public void createActivityTest()
  {

    goTo("http://localhost:4567/activities");
    click(".btn", withText("Add activity"));
    fill("#name").with("Judo");
    fill("#price").with("20");
    fill("#time").with("17");
    fill("#capacity").with("30");
    fill("#min-age").with("12");
    fill("#imgSrc").with("/Images/paintball.jpg");
    submit(".btn-blue");
    goTo("http://localhost:4567/activities");
    assertThat(pageSource().contains("Judo"));

  }

  @Test
  public void editActivityPaintBallTest()
  {
    createActivityTest();
    goTo("http://localhost:4567/activities");
    click(".btn", withText("Paintball"));
    fill("#name").with("Swimming");
    fill("#price").with("22");
    fill("#time").with("18");
    fill("#capacity").with("12");
    fill("#min-age").with("16");
    submit(".btn-blue");
    goTo("http://localhost:4567/activities");
    click(".btn", withText("Swimming"));
    assertThat(pageSource().contains("Swimming"));


  }
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
