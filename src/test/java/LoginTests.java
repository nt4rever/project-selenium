import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import page.HomePage;

public class LoginTests extends BaseTest {
    @Test
    @DisplayName("TC01-login-successfully")
    public void testLoginSuccessful() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        String title = homePage.getTitle();
        Assertions.assertTrue(title.contains("Guru99 Bank Manager HomePage"), "Welcome text is incorrect");
    }

    @Test
    @DisplayName("TC02-login-failed")
    public void testLoginFail() {
        loginPage.setUsername("taniutan");
        loginPage.setPassword("123456");
        HomePage homePage = loginPage.login();
        Alert alert = homePage.getAlert();
        Assertions.assertEquals(alert.getText(), "User or Password is not valid");
        alert.accept();
    }
}
