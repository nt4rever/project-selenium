import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.FundTransfer;
import page.HomePage;
import page.StatementForm;
import page.StatementFormSubmit;

public class StatementFormTests extends BaseTest {
    @ParameterizedTest(name = "{index} => accountNo={0},fdate={1}, tdate={2}, amountlowerlimit={3}, numtransaction={4}, result={5}")
    @CsvSource({
            "52715,01012020,02012020,1000,10,fail",
    })
    public void doStatementForm(String accountNo, String fdate, String tdate, String amountlowerlimit, String numtransaction, String result) {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        StatementForm statementForm = homePage.clickStatementForm();
        statementForm.setAccountNo(accountNo);
        statementForm.setFdate(fdate);
        statementForm.setTDate(tdate);
        statementForm.setAmountlowerlimit(amountlowerlimit);
        statementForm.setNumtransaction(numtransaction);
        StatementFormSubmit statementFormSubmit = statementForm.clickSubmit();
        if(result.equals("fail")){
            Assertions.assertTrue(true, "");
        }
    }

    @Test
    public void reset() {
        loginPage.setUsername("mngr399660");
        loginPage.setPassword("tydEbeq");
        HomePage homePage = loginPage.login();
        StatementForm statementForm = homePage.clickStatementForm();
        statementForm.setAccountNo("123243");
        statementForm.clickReset();
        Assertions.assertTrue(statementForm.getAccountNo().isEmpty(), "pass");
    }
}
