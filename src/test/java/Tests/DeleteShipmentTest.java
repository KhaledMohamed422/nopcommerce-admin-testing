package Tests;

import Pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DeleteShipmentTest extends TestBase{
    LoginPage loginPage;
    DashPage dashPage;
    ShipmentsPage shipmentsPage;
    ShipmentDetailPage shipmentDetailPage;
    OrderDetailPage orderDetailPage;

    @Test
    public void VerifyDeleteShipment() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");

        dashPage = new DashPage(driver);
        dashPage.Open_shipmentsPage();

        shipmentsPage = new ShipmentsPage(driver);
        String id = shipmentsPage.GetShipmentId();
        System.out.println(id);
        shipmentsPage.OpenShipmentDetail();
        shipmentDetailPage = new ShipmentDetailPage(driver);
        shipmentDetailPage.DeleteShipment();

        orderDetailPage = new OrderDetailPage(driver);
        orderDetailPage.Open_shipmentsPage();

        shipmentsPage = new ShipmentsPage(driver);
        Assert.assertNotEquals(id, shipmentsPage.GetShipmentId());
    }
}
