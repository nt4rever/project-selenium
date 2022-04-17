package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransfer {
    private WebDriver driver;

    public FundTransfer(WebDriver driver) {
        this.driver = driver;
    }

    private By payersaccount = By.xpath("//input[@name='payersaccount']");
    private By payeeaccount = By.xpath("//input[@name='payeeaccount']");
    private By ammount = By.xpath("//input[@name='ammount']");
    private By desc = By.xpath("//input[@name='desc']");
    private By submit = By.xpath("//input[@name='AccSubmit']");
    private By reset = By.xpath("//input[@name='res']");

    public void setPayersaccount(String no) {
        driver.findElement(payersaccount).sendKeys(no);
    }

    public void setPayeeaccount(String no) {
        driver.findElement(payeeaccount).sendKeys(no);
    }

    public void setAmmount(String a) {
        driver.findElement(ammount).sendKeys(a);
    }

    public void setDesc(String d) {
        driver.findElement(desc).sendKeys(d);
    }

    public void clickReset() {
        driver.findElement(reset).click();
    }

    public String getPayacc() {
        return driver.findElement(payersaccount).getAttribute("value");
    }

    public FundTransferSubmit clickSubmit() {
        driver.findElement(submit).click();
        return new FundTransferSubmit(driver);
    }
}