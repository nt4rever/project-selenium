package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAccountPage {
    private WebDriver driver;
    private By customerId = By.xpath("//input[@name='cusid']");
    private By deposit = By.xpath("//input[@name='inideposit']");
    private By type = By.xpath("//select[@name='selaccount']");
    private By submit = By.xpath("//input[@name='button2']");
    private By reset = By.xpath("//input[@name='reset']");
    public AddAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCustomerId(String id){
        driver.findElement(customerId).sendKeys(id);
    }

    public void setDeposit(String d){
        driver.findElement(deposit).sendKeys(d);
    }

    public void setType(String t){
        driver.findElement(type).sendKeys(t);
    }

    public void reset(){
        driver.findElement(reset).click();
    }

    public String getCusid(){
        return driver.findElement(customerId).getAttribute("value");
    }
    public AccCreateMsg submit(){
        driver.findElement(submit).click();
        return new AccCreateMsg(driver);
    }
}
