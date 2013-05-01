import org.junit.Test;
import play.test.TestBrowser;
import play.libs.F.Callback;
import static play.test.Helpers.HTMLUNIT;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.testServer;
import static play.test.Helpers.running;
import static org.fest.assertions.Assertions.assertThat;
import pages.IndexPage;

public class IntegrationTest {
  @Test
  public void test() {
    running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT,
        new Callback<TestBrowser>() {
          public void invoke(TestBrowser browser) {
            IndexPage indexPage = new IndexPage(browser.getDriver(), 3333);
            browser.goTo(indexPage);
            String name = "Test Name";
            String gender = "Female";
            indexPage.submitForm(name, gender);
            assertThat(browser.pageSource()).contains("Last Gender: " + gender);
            assertThat(browser.pageSource()).contains("Last Name: " + name);
          }
        });
  }
}
