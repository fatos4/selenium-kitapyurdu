import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    static WebDriver driver;
    HomePage homePage;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","../selenium_kitap_yurdu/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }
}


