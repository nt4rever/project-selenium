import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import page.Deposit;
import page.DepositSubmit;
import page.HomePage;

public class DepositTests extends BaseTest {
    @ParameterizedTest(name = "{index} => accno={0}, amount={1}, desc={2}, result={3}")
    @CsvSource({
            "52715,1000,nodesc,fail",
            "52162,1000,nodesc,fail",
    })
    public void doDeposit(String accno, String amount, String desc, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        Deposit deposit = homePage.clickDeposit();
        deposit.setAccountNo(accno);
        deposit.setAmmount(amount);
        deposit.setDesc(desc);
        DepositSubmit depositSubmit = deposit.clickSubmit();
        if (result.equals("fail")) {
            Alert alert = depositSubmit.getAlert();
            if (alert.equals("Account does not exist"))
                Assertions.assertTrue(true, "");
        }
    }

    @Test
    public void reset() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        Deposit deposit = homePage.clickDeposit();
        deposit.setAccountNo("123456");
        deposit.clickReset();
        Assertions.assertTrue(deposit.getAccountNo().isEmpty(), "pass");
    }
}
