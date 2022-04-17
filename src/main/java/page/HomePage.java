package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private WebDriver driver;
    private By logoutHref = By.xpath("//a[contains(text(),'Log out')]");
    private By newCustomer = By.xpath("//a[contains(text(),'New Customer')]");

    private By newAccount = By.xpath("//a[contains(text(),'New Account')]");

    private By deposit = By.xpath("//a[contains(text(),'Deposit')]");

    private By widthDraw = By.xpath("//a[contains(text(),'Withdrawal')]");

    private By fundTransfer = By.xpath("//a[contains(text(),'Fund Transfer')]");

    private By statementForm = By.xpath("//a[contains(text(),'Customised Statement')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }

    public void logOut() {
        driver.findElement(logoutHref).click();
    }

    public AddCustomerPage clickNewCustomer() {
        driver.findElement(newCustomer).click();
        return new AddCustomerPage(driver);
    }

    public AddAccountPage clickAddAccount() {
        driver.findElement(newAccount).click();
        return new AddAccountPage(driver);
    }

    public Deposit clickDeposit() {
        driver.findElement(deposit).click();
        return new Deposit(driver);
    }

    public WidthDraw clickWidthDraw() {
        driver.findElement(widthDraw).click();
        return new WidthDraw(driver);
    }

    public FundTransfer clickFundTransfer() {
        driver.findElement(fundTransfer).click();
        return new FundTransfer(driver);
    }

    public StatementForm clickStatementForm(){
        driver.findElement(statementForm).click();
        return new StatementForm(driver);
    }
}