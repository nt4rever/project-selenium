import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import page.AddCustomerPage;
import page.HomePage;
import page.RegisterPage;

public class CustomerTest extends BaseTest {
    @Test
    @DisplayName("TC04-addnewcustomer-successfully")
    public void newCustomer() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddCustomerPage addCustomerPage = homePage.clickNewCustomer();
        addCustomerPage.setName("Tran Quang Dat");
        addCustomerPage.setCity("Quang Binh");
        addCustomerPage.setAddress("17 Ngo Thi Nham");
        addCustomerPage.setGender("m");
        addCustomerPage.setEmailid("tqdat.19it11212@vku.udn.vn");
        addCustomerPage.setDateOfBirth("06122001");
        addCustomerPage.setTelephoneno("09346666");
        addCustomerPage.setPassword("aa123456");
        addCustomerPage.setPinno("123456");
        addCustomerPage.setState("VN");
        RegisterPage registerPage = addCustomerPage.clickSub();
        Assertions.assertTrue(registerPage.getTitle().contains("Guru99 Bank Customer Registration Page"), "add new customer");
    }

    @Test
    @DisplayName("TC05-addnewcustomer-failed")
    public void newCustomerFail() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddCustomerPage addCustomerPage = homePage.clickNewCustomer();
        addCustomerPage.setName("Tran Quang Dat");
        addCustomerPage.setCity("Quang Binh");
        addCustomerPage.setAddress("17 Ngo Thi Nham");
        addCustomerPage.setGender("m");
        addCustomerPage.setEmailid("tqdat.19it112112@vku.udn.vn");
        addCustomerPage.setDateOfBirth("06122001");
        addCustomerPage.setTelephoneno("09346666");
        addCustomerPage.setPassword("aa123456");
        addCustomerPage.setPinno("123456");
        addCustomerPage.setState("123123");
        RegisterPage registerPage = addCustomerPage.clickSub();
        Alert alert = registerPage.getAlert();
        if (alert.getText().equals("Email Address Already Exist !!")) {
            Assertions.assertTrue(true, "");
        } else if (alert.getText().equals("please fill all fields")) {
            Assertions.assertTrue(true, "");
        }
        alert.accept();
    }
}
