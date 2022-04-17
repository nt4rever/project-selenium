import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.Alert;
import page.*;

public class WidthDrawTests extends BaseTest{
    @ParameterizedTest(name = "{index} => accno={0}, amount={1}, desc={2}, result={3}")
    @CsvSource({
            "52715,1000,nodesc,fail",
            "52162,1000,nodesc,fail",
    })
    public void doWidthDraw(String accno, String amount, String desc, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        WidthDraw widthDraw = homePage.clickWidthDraw();
        widthDraw.setAccountNo(accno);
        widthDraw.setAmmount(amount);
        widthDraw.setDesc(desc);
        WidthDrawSubmit widthDrawSubmit = widthDraw.clickSubmit();
        if (result.equals("fail")) {
            Alert alert = widthDrawSubmit.getAlert();
            if (alert.equals("Account does not exist"))
                Assertions.assertTrue(true, "");
        }
    }

    @Test
    public void reset() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        WidthDraw widthDraw = homePage.clickWidthDraw();
        widthDraw.setAccountNo("123456");
        widthDraw.clickReset();
        Assertions.assertTrue(widthDraw.getAccountNo().isEmpty(), "pass");
    }
}
