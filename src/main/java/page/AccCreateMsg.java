package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AccCreateMsg {
    private WebDriver driver;

    public AccCreateMsg(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public Alert getAlert() {
        return driver.switchTo().alert();
    }
}
