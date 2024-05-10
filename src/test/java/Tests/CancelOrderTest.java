package Tests;

import Pages.DashPage;
import Pages.LoginPage;
import Pages.OrderDetailPage;
import Pages.OrdersPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class CancelOrderTest extends TestBase {
    LoginPage loginPage;
    DashPage dashPage;
    OrdersPage ordersPage;
    OrderDetailPage orderDetailPage;

    @Test
    public void VerfiyCancelOrder() throws IOException, InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.LogIn("admin@yourstore.com", "admin");

        dashPage = new DashPage(driver);
        dashPage.Open_ordersPage();

        ordersPage = new OrdersPage(driver);
        ordersPage.Goto_Order(5);

        orderDetailPage = new OrderDetailPage(driver);
        orderDetailPage.Cancel();

        Thread.sleep(3000);
        Assert.assertEquals(orderDetailPage.status.getText(),"Cancelled");
    }
}
