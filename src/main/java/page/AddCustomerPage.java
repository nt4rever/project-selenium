package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddCustomerPage {
    private WebDriver driver;

    private By name = By.xpath("//input[@name='name']");
    private By city = By.xpath("//input[@name='city']");
    private By state = By.xpath("//input[@name='state']");
    private By pinno = By.xpath("//input[@name='pinno']");
    private By telephoneno = By.xpath("//input[@name='telephoneno']");
    private By emailid = By.xpath("//input[@name='emailid']");
    private By password = By.xpath("//input[@name='password']");
    private By rad1 = By.xpath("//input[@name='rad1']");
    private By dob = By.xpath("//input[@name='dob']");
    private By addr = By.xpath("//textarea[@name='addr']");

    private By submit = By.xpath("//input[@name='sub']");

    private By resetBtn = By.xpath("//input[@name='res']");

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String n) {
        driver.findElement(name).sendKeys(n);
    }

    public void setCity(String n) {
        driver.findElement(city).sendKeys(n);
    }

    public void setState(String n) {
        driver.findElement(state).sendKeys(n);
    }

    public void setPinno(String n) {
        driver.findElement(pinno).sendKeys(n);
    }

    public void setTelephoneno(String n) {
        driver.findElement(telephoneno).sendKeys(n);
    }

    public void setEmailid(String n) {
        driver.findElement(emailid).sendKeys(n);
    }

    public void setPassword(String n) {
        driver.findElement(password).sendKeys(n);
    }

    public void setGender(String n) {
        driver.findElement(rad1).sendKeys(n);
    }

    public void setDateOfBirth(String n) {
        WebElement dobElement = driver.findElement(dob);
        dobElement.clear();
        dobElement.sendKeys(n);
    }

    public void setAddress(String n) {
        driver.findElement(addr).sendKeys(n);
    }

    public RegisterPage clickSub(){
        driver.findElement(submit).click();
        return new RegisterPage(driver);
    }

    public String getName(){
        return driver.findElement(name).getAttribute("value");
    }

    public void reset(){
        driver.findElement(resetBtn).click();
    }
}
