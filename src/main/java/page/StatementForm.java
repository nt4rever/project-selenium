package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatementForm {
    private WebDriver driver;
    private By accountNo = By.xpath("//input[@name='accountno']");
    private By fdate = By.xpath("//input[@name='fdate']");
    private By tdate = By.xpath("//input[@name='tdate']");

    private By amountlowerlimit = By.xpath("//input[@name='amountlowerlimit']");
    private By numtransaction = By.xpath("//input[@name='numtransaction']");
    private By submit = By.xpath("//input[@name='AccSubmit']");
    private By reset = By.xpath("//input[@name='res']");

    public StatementForm(WebDriver driver) {
        this.driver = driver;
    }

    public void setAccountNo(String no) {
        driver.findElement(accountNo).sendKeys(no);
    }

    public String getAccountNo(){
        return driver.findElement(accountNo).getAttribute("value");
    }
    public void setFdate(String a) {
        driver.findElement(fdate).sendKeys(a);
    }

    public void setTDate(String a) {
        driver.findElement(tdate).sendKeys(a);
    }

    public void setAmountlowerlimit(String a) {
        driver.findElement(amountlowerlimit).sendKeys(a);
    }

    public void setNumtransaction(String a) {
        driver.findElement(numtransaction).sendKeys(a);
    }

    public StatementFormSubmit clickSubmit(){
        driver.findElement(submit).click();
        return new StatementFormSubmit(driver);
    }

    public void clickReset() {
        driver.findElement(reset).click();
    }
}
