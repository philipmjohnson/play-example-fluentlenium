package pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  

/**
 * Illustration of the Page Object Pattern in Fluentlenium.  
 * @author Philip Johnson
 */
public class IndexPage extends FluentPage {
  private String url;
  
  public IndexPage (WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port;
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assert(title().equals("Index"));
  }
  
  public void submitForm(String name, String gender) {
    // Fill the input field with id "name" with the passed name string.
    fill("#name").with(name);
    // Find the menu with id "gender", and click the menu item equal to the passed gender string.
    find("select", withId().equalTo("gender")).find("option", withText().equalTo(gender)).click();
    //Submit the form whose id is "submit"
    submit("#submit");
  }
  
  
}
