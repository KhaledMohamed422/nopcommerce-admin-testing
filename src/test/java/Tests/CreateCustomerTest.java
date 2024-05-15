package Tests;

import Pages.CustomerCreatePage;
import Pages.CustomersPage;
import Pages.DashPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class CreateCustomerTest extends TestBase {
    LoginPage loginPage;
    DashPage dashPage;
    CustomersPage customersPage;
    CustomerCreatePage customerCreatePage;

    @Test
    public void TestCreateCustomer() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");

        dashPage = new DashPage(driver);
        dashPage.Open_customersPage();

        customersPage = new CustomersPage(driver);
        customersPage.Open_CreateCustomerPage();

        customerCreatePage = new CustomerCreatePage(driver);
        String customer_email = "test2@gmail.com";
        customerCreatePage.CreateCustomer("test", "test", true, customer_email, "1234", "this is comment test");

        customersPage = new CustomersPage(driver);
        customersPage.Search_email(customer_email);

        Thread.sleep(2000);

        WebElement table = driver.findElement(By.id("customers-grid"));
        List<WebElement> rows= table.findElements(By.tagName("tr"));
        Assert.assertTrue(rows.size() == 2);

        List<WebElement> cells = rows.get(1).findElements(By.tagName("td"));
        Assert.assertEquals(customer_email, cells.get(1).getText());
    }
}
