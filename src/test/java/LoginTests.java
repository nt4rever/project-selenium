import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.Alert;
import page.HomePage;

public class LoginTests extends BaseTest {
    @ParameterizedTest(name = "{index} => username={0}, password={1}, result={2}")
    @CsvFileSource(resources = "/login_data.csv")
    public void doTestLogin(String username, String password, String result) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        HomePage homePage = loginPage.login();
        if (result.equals("pass")) {
            String title = homePage.getTitle();
            Assertions.assertTrue(title.contains("Guru99 Bank Manager HomePage"), "Welcome text is incorrect");
        } else if (result.equals("fail")) {
            Alert alert = homePage.getAlert();
            Assertions.assertEquals(alert.getText(), "User or Password is not valid");
            alert.accept();
        }
    }

    @Test
    public void doTestReset(){
        loginPage.setUsername("demo");
        loginPage.setPassword("demo");
        loginPage.reset();
        Assertions.assertTrue(loginPage.getUsername().isEmpty(), "pass");
    }
}
