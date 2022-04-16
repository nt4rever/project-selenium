import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import page.HomePage;

public class LogOutTest extends BaseTest{
    @Test
    @DisplayName("TC03-logout-successfully")
    public void testLogOut(){
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        homePage.logOut();
        Alert alert = homePage.getAlert();
        Assertions.assertEquals(alert.getText(), "You Have Succesfully Logged Out!!");
    }
}
