import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import page.*;

public class FundTransferTests extends BaseTest{
    @ParameterizedTest(name = "{index} => payersaccount={0},payeeaccount={1}, amount={2}, desc={3}, result={4}")
    @CsvSource({
            "52715,52162,1000,nodesc,fail",
            "52162,52715,1000,nodesc,fail",
    })
    public void doFundTransfer(String payersaccount,String payeeaccount, String amount, String desc, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        FundTransfer fundTransfer = homePage.clickFundTransfer();
        fundTransfer.setPayersaccount(payersaccount);
        fundTransfer.setPayeeaccount(payeeaccount);
        fundTransfer.setAmmount(amount);
        fundTransfer.setDesc(desc);
        FundTransferSubmit fundTransferSubmit = fundTransfer.clickSubmit();
        if (result.equals("fail")) {
            Alert alert = fundTransferSubmit.getAlert();
            Assertions.assertEquals(alert.getText().contains("does not exist!!!"),"pass");
        }
    }

    @Test
    public void reset() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        FundTransfer fundTransfer = homePage.clickFundTransfer();
        fundTransfer.setPayersaccount("123456");
        fundTransfer.clickReset();
        Assertions.assertTrue(fundTransfer.getPayacc().isEmpty(), "pass");
    }
}
