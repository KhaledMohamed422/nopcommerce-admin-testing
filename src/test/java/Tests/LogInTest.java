package Tests;

import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        loginPage.LogIn("admin@yourstore.com", "admin");

        // Add assertion to verify login is successful
        String expectedTitle = "Dashboard / nopCommerce administration";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Login was not successful");
    }
}
