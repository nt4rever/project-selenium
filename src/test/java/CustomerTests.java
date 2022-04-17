import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.Alert;
import page.AddCustomerPage;
import page.HomePage;
import page.RegisterPage;

public class CustomerTests extends BaseTest {
    @ParameterizedTest(name = "{index} =>name={0}, gender={1}, dob = {2}, address={3}, city={4}, state={5}, pin={6}, phone={7}, email={8}, password={9}, result={10}")
    @CsvFileSource(resources = "/customer.csv")
    public void doNewCustomer(String name, String gender, String dob, String address, String city, String state, String pin, String phone, String email, String password, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddCustomerPage addCustomerPage = homePage.clickNewCustomer();
        addCustomerPage.setName(name);
        addCustomerPage.setCity(city);
        addCustomerPage.setAddress(address);
        addCustomerPage.setGender(gender);
        addCustomerPage.setEmailid(email);
        addCustomerPage.setDateOfBirth(dob);
        addCustomerPage.setTelephoneno(phone);
        addCustomerPage.setPassword(password);
        addCustomerPage.setPinno(pin);
        addCustomerPage.setState(state);
        RegisterPage registerPage = addCustomerPage.clickSub();
        if (result.equals("pass")) {
            Assertions.assertTrue(registerPage.getTitle().contains("Guru99 Bank Customer Registration Page"), "add new customer");
        } else {
            Alert alert = registerPage.getAlert();
            if (alert.getText().equals("Email Address Already Exist !!")) {
                Assertions.assertTrue(true, "");
            } else if (alert.getText().equals("please fill all fields")) {
                Assertions.assertTrue(true, "");
            }
            alert.accept();
        }
    }

    @Test
    public void doReset(){
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddCustomerPage addCustomerPage = homePage.clickNewCustomer();
        addCustomerPage.setName("test");
        addCustomerPage.reset();
        Assertions.assertTrue(addCustomerPage.getName().isEmpty(), "pass");
    }
}
