package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class StatementFormSubmit {
    private WebDriver driver;

    public StatementFormSubmit(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }
}