package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class FundTransferSubmit {
    private WebDriver driver;

    public FundTransferSubmit(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public Alert getAlert(){
        return driver.switchTo().alert();
    }
}
