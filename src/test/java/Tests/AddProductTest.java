package Tests;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTest extends TestBase {


    AddProductPage addProductPage;
    LoginPage loginPage;
    DashPage dashPage;

    @BeforeMethod
    public void setUp() {
        addProductPage = new AddProductPage(driver);
        loginPage = new LoginPage(driver);
        dashPage = new DashPage(driver);
    }

    @Test
    public void testAddProduct() {
        loginPage.LogIn("admin@yourstore.com", "admin");
        dashPage = new DashPage(driver);
        dashPage.Open_productPage();

        addProductPage.clickAddNewProduct();
        addProductPage.addProductName("lab4");
        addProductPage.clickAddSaveProduct();

    }
}
