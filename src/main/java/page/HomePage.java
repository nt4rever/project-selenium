package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By logoutHref = By.xpath("//a[contains(text(),'Log out')]");
    private By newCustomer = By.xpath("//a[contains(text(),'New Customer')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public Alert getAlert(){
        return driver.switchTo().alert();
    }

    public void logOut(){
        driver.findElement(logoutHref).click();
    }

    public AddCustomerPage clickNewCustomer(){
        driver.findElement(newCustomer).click();
        return new AddCustomerPage(driver);
    }
}