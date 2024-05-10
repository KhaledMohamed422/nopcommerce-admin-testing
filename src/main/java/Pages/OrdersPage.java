package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrdersPage extends PageBase {
    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="GoDirectlyToCustomOrderNumber")
    WebElement goto_input;

    @FindBy(id = "go-to-order-by-number")
    WebElement go_button;

    public void Goto_Order(Integer id) {
        goto_input.sendKeys(Integer.toString(id));
        go_button.click();
    }
}
