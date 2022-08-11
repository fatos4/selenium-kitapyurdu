import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {
    By shippingOptionLocator = By.id("normal-filter");
    By productNameLocator = new By.ByCssSelector("#product-607844 > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > span:nth-child(1)");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(shippingOptionLocator);
    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
