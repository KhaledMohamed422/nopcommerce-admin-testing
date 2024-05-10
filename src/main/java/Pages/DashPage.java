package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class DashPage extends PageBase {
    @FindBy(css = "li.has-treeview:nth-child(3) > a:nth-child(1)")
    private WebElement sales_group;

    @FindBy(xpath = "//a[@href='/Admin/Order/List']")
    private  WebElement Orders;

    private void Collapse_group(WebElement list_group) {
        list_group.click();
        list_group.click();
    }

    public DashPage(WebDriver driver) {
        super(driver);
    }

    public void Open_ordersPage() {
        Collapse_group(sales_group);
        Orders.click();
    }
}
