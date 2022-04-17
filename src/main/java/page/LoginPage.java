package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameTxt = By.xpath("//input[@name='uid']");
    private By passwordTxt = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@name='btnLogin']");

    private By resetBtn = By.xpath("//input[@name='btnReset']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameTxt).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public String getUsername(){
        return driver.findElement(usernameTxt).getAttribute("value");
    }
    public HomePage login() {
        WebElement buttonSubmitElement = driver.findElement(loginBtn);
        buttonSubmitElement.click();
        return new HomePage(driver);
    }

    public void reset(){
        driver.findElement(resetBtn).click();
    }
}
