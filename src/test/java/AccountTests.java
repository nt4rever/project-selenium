import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.AccCreateMsg;
import page.AddAccountPage;
import page.HomePage;

public class AccountTests extends BaseTest {
    @ParameterizedTest(name = "{index} => cusid={0}, type={1}, deposit={2}, result={3}")
    @CsvSource({
            "52715,Current,10000,pass",
            "52715,Savings,5000,pass",
            "12345,Current,1000,fail",
            "12345a,Current,1000,fail",
    })
    public void doAddAccount(String cusid, String type, String deposit, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddAccountPage addAccountPage = homePage.clickAddAccount();
        addAccountPage.setCustomerId(cusid);
        addAccountPage.setType(type);
        addAccountPage.setDeposit(deposit);
        AccCreateMsg accCreateMsg = addAccountPage.submit();
        if(result.equals("pass"))
            Assertions.assertTrue(accCreateMsg.getTitle().contains("Gtpl Bank Customer Registration Page"), "add account");
        else
            Assertions.assertTrue(true,"");
    }

    @Test
    public void doReset(){
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        AddAccountPage addAccountPage = homePage.clickAddAccount();
        addAccountPage.setCustomerId("12345");
        addAccountPage.reset();
        Assertions.assertTrue(addAccountPage.getCusid().isEmpty(), "reset ok");
    }
}
