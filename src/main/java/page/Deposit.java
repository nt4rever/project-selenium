package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Deposit {
    private WebDriver driver;

    private By accountNo = By.xpath("//input[@name='accountno']");
    private By ammount = By.xpath("//input[@name='ammount']");
    private By desc = By.xpath("//input[@name='desc']");

    private By submit = By.xpath("//input[@name='AccSubmit']");
    private By reset = By.xpath("//input[@name='res']");

    public Deposit(WebDriver driver) {
        this.driver = driver;
    }

    public void setAccountNo(String no) {
        driver.findElement(accountNo).sendKeys(no);
    }

    public void setAmmount(String ammount) {
        driver.findElement(this.ammount).sendKeys(ammount);
    }

    public void setDesc(String d) {
        driver.findElement(desc).sendKeys(d);
    }

    public void clickReset() {
        driver.findElement(reset).click();
    }

    public DepositSubmit clickSubmit(){
        driver.findElement(submit).click();
        return new DepositSubmit(driver);
    }

    public String getAccountNo(){
        return driver.findElement(accountNo).getAttribute("value");
    }

}


