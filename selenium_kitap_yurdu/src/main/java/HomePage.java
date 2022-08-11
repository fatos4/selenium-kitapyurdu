import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By searchBoxLocator = By.id("search-input");
    By submitButtonLocator = new By.ByCssSelector("span.common-sprite:nth-child(3)");


    public HomePage(WebDriver driver) {
        super(driver);

    }
    public void setSearchField(String word){
        type(searchBoxLocator,word);
    }
    public void clickSearchButton(){
        click(submitButtonLocator);
    }


}
