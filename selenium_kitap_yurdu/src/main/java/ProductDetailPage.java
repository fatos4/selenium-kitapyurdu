import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage extends BasePage {

    public WebDriverWait wait;
    By addToCartButtonLocator = By.id("button-cart");
    By cartLocator = new By.ByXPath("//*[@id=\"cart-items\"]");
    By goToCartLocator = new By.ByXPath("//a[@href='https://www.kitapyurdu.com/index.php?route=checkout/cart']");

    private By correctNumberControl = By.id("cart-items");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public CartPage goToCart() {
        click(cartLocator);
        return new CartPage(driver);
    }

    public CartPage clickCartPage(){
        wait.until(ExpectedConditions.elementToBeClickable(goToCartLocator));
        click(goToCartLocator);
        return new CartPage(driver);
    }

    /*public boolean isProductCountUp() {
        return getCartCount() > 0;

    }
    private int getCartCount(){
        wait.until(ExpectedConditions.presenceOfElementLocated(correctNumberControl));
        String correctNumber = driver.findElement(correctNumberControl).getText();
        return Integer.parseInt(correctNumber);
    }*/

}
