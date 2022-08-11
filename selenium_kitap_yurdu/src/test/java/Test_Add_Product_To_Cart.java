import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import java.io.FileReader;
import java.io.IOException;

public class Test_Add_Product_To_Cart extends BaseTest {
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void search_a_product() throws IOException, CsvException {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);

        String path = "../selenium_kitap_yurdu/src/main/resources/roman.csv";
        CSVReader csvReader = new CSVReader(new FileReader(path));
        String [] data;
        data = csvReader.readNext();
        homePage.setSearchField(data[0]);
        homePage.clickSearchButton();
        Assertions.assertTrue(productsPage.isOnProductPage(),
                "Not on product page!");
    }

    @Test
    @Order(2)
    public void select_a_product(){
        productDetailPage = new ProductDetailPage(driver);
        productsPage.selectProduct(0);
        Assertions.assertTrue(productDetailPage.isOnProductDetailPage(),
                "Not on product detail page!");
    }

    @Test
    @Order(3)
    public void add_product_to_cart(){
        productDetailPage.addToCart();
        //Assertions.assertTrue(productDetailPage.isProductCountUp(),
          //      "Product count did not increase!");

    }
    @Test
    @Order(4)
    public void go_to_cart(){
        productDetailPage = new ProductDetailPage(driver);
        cartPage = new CartPage(driver);

        productDetailPage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),
             "Product was not added to cart!");
        productDetailPage.clickCartPage();
    }


    @Test
    @Order(5)
    public void increases_the_amount(){
        cartPage.increasesTheAmount();
        Assertions.assertTrue(cartPage.checkIfAlert(),
               "Alert not turned on!");
    }

    @Test
    @Order(6)
    public void delete_product(){
        cartPage.deleteProduct();
        Assertions.assertTrue(cartPage.setDeleteControl(),
                "Cart could not be emptied!");
    }



}
