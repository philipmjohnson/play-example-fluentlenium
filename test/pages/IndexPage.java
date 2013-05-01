package pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import static org.fluentlenium.core.filter.FilterConstructor.withId;
import static org.fluentlenium.core.filter.FilterConstructor.withText;

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
  
  public void submitForm() {
    fill("#name").with("My Name");
    find("select", withId("gender")).find("option", withText("Female")).click();
    submit("#submit");
  }
  
  
}
