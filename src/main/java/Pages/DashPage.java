package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DashPage extends PageBase {
    @FindBy(css = "li.has-treeview:nth-child(3) > a:nth-child(1)")
    WebElement sales_group;

    @FindBy(css = "li.has-treeview:nth-child(4) > a:nth-child(1)")
    WebElement customers_group;

    @FindBy(xpath = "//a[@href='/Admin/Order/List']")
    WebElement Orders;

    @FindBy(xpath = "//a[@href='/Admin/Order/ShipmentList']")
    WebElement Shipments;

    @FindBy(xpath = "//a[@href='/Admin/Customer/List']")
    WebElement Customers;


    private void Collapse_group(WebElement list_group) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list_group.click();
    }

    public DashPage(WebDriver driver) {
        super(driver);
    }

    public void Open_ordersPage() {
        Collapse_group(sales_group);
        Orders.click();
    }

    public void Open_shipmentsPage() {
        Collapse_group(sales_group);
        Shipments.click();
    }

    public void Open_customersPage() {
        Collapse_group(customers_group);
        Customers.click();
    }
}
