package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.AddManufacturer;
import Pages.LoginPage;
import Pages.DashPage;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;


public class AddManufacturerTest extends TestBase {
    LoginPage loginPage;
    AddManufacturer addManufacturer;
    DashPage dashPage;

    @Test
    public void test_addManufacturer() throws AWTException, InterruptedException {

//        addManufacturer.clickLnkCatalog();
//        addManufacturer.clickLnkManufacturers();



        addManufacturer.clickAddNew();

        addManufacturer.addManufacturerName("Samsung");
//        addManufacturer.loadImage("D:\\Programming Languages\\Java\\nopcommerceApp\\images\\samsung.png");
//
//        addManufacturer.pageSize();
//        addManufacturer.pageSizeOptions("6,10,30");
//        addManufacturer.priceRanges("10000-20000");
//        addManufacturer.displayOrder();


        addManufacturer.clickSaveButton();

        System.out.println("validation started");
        String expMessage = "The new manufacturer has been added successfully.";
        String actualMessage = driver.findElement(By.tagName("body")).getText();

        if(actualMessage.contains(expMessage))
        {
            System.out.println("Add Manufacturer test Passed");
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Add Manufacturer test Failed");
            Assert.assertTrue(false);
        }
    }
    @BeforeMethod
    public void beforeMethod() {

        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");

        dashPage = new DashPage(driver);
        dashPage.Open_manufacturerPage();

        addManufacturer = new AddManufacturer(driver);

    }

    @AfterMethod
    public void afterMethod() {

        System.out.println("Load Add Manufacturer Test Completed");
    }
}
