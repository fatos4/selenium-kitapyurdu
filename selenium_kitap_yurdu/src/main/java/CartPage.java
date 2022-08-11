import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    WebDriverWait wait;
    By productNameLocator = new By.ByCssSelector("#cart > div.heading > div:nth-child(2)");
    By amountLocator = By.xpath("//input[@name='quantity']");
    By refreshLocator = new By.ByCssSelector("#cart_module > div.cart-info > table > tbody > tr > td.quantity > form > i");
    By alertLocator = new By.ByCssSelector("#swal-toast > div > div");
    By deleteButtonLocator = new By.ByXPath("//*[@id=\"cart_module\"]/div[1]/table/tbody/tr/td[8]/a/i");
    By deleteControlLocator = new By.ByCssSelector("#cart_module > div.content");

    public CartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public boolean checkIfProductAdded() {
        return getProducts().size()>0;
    }


    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }

    public void increasesTheAmount() {
        driver.findElement(amountLocator).clear();
        type(amountLocator,"2");
        click(refreshLocator);
    }

    public boolean checkIfAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(alertLocator));
        return isDisplayed(alertLocator);
    }

    public void deleteProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButtonLocator));
        click(deleteButtonLocator);

    }
    public boolean setDeleteControl(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteControlLocator));
        return isDisplayed(deleteControlLocator);
    }
}
