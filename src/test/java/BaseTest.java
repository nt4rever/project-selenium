import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import page.LoginPage;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demo.guru99.com/V4/index.php");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
