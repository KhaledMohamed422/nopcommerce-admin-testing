package Tests;


import Pages.DashPage;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductListPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class DeleteAllProductTest extends TestBase {

    LoginPage loginPage;
    ProductListPage products;
    DashPage dashPage;


    @BeforeMethod
    public void setUp() {
        products = new ProductListPage(driver);
        loginPage = new LoginPage(driver);
        dashPage = new DashPage(driver);
    }

    @Test
    public void test_IfAllTheChosenProductsCanBeDeletedWhenPressingDeleteButton() {
        loginPage.LogIn("admin@yourstore.com", "admin");
        dashPage = new DashPage(driver);
        dashPage.Open_productPage();

        products.selectProductLength();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        products.selectTableItems();

        products.clickDeleteBtn();

        products.clickConfirmBtn();

        products.clickOk();

        System.out.println("validation started");
        String expectedMessage = "No data available in table";
//        String actualMessage = driver.findElement(By.xpath("//*[text()='No data available in table']")).getText();

//        if(actualMessage.equals(expectedMessage))
//        {
//            System.out.println("Delete all the products test Passed");
//            Assert.assertTrue(true);
//        }
//        else
//        {
//            System.out.println("Delete all the products test failed");
//            Assert.assertTrue(false);
//        }

    }

}

