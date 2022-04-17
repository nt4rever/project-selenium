package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class WidthDrawSubmit {
    private WebDriver driver;

    public WidthDrawSubmit(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }
}
