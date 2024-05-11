package Tests;

import Pages.DashPage;
import Pages.LoginPage;
import Pages.ShipmentDetailPage;
import Pages.ShipmentsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SaveShipmentTest extends TestBase {
    LoginPage loginPage;
    DashPage dashPage;
    ShipmentsPage shipmentsPage;
    ShipmentDetailPage shipmentDetailPage;

    @Test
    public void VerifySaveShipment_asPdf() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");

        dashPage = new DashPage(driver);
        dashPage.Open_shipmentsPage();

        shipmentsPage = new ShipmentsPage(driver);
        shipmentsPage.OpenShipmentDetail();

        shipmentDetailPage = new ShipmentDetailPage(driver);
        shipmentDetailPage.PrintShipment();

        for(String handle: driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
        }
        Thread.sleep(5000);
        TakesScreenshot sc=(TakesScreenshot) driver;
        File screen = sc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File("./screenshots/VerifyPrint.png"));
    }
}
