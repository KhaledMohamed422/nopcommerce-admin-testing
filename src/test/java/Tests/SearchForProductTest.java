package Tests;

import Pages.CustomersPage;
import Pages.DashPage;
import Pages.LoginPage;
import Pages.ProductListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchForProductTest extends TestBase {
    ProductListPage productListPage;
    LoginPage loginPage;
    DashPage dashPage;

    @BeforeMethod
    public void setUp() {
        productListPage = new ProductListPage(driver);
        loginPage = new LoginPage(driver);
        dashPage = new DashPage(driver);
    }

    @Test
    public void testSearchProduct() {
        loginPage.LogIn("admin@yourstore.com", "admin");
        dashPage = new DashPage(driver);
        dashPage.Open_productPage();

        productListPage.enterProductName("Sample Product");
        productListPage.clickSearchButton();

        if (productListPage.searchProductByName("Sample Product")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Product not found in table");
        }
    }
}
