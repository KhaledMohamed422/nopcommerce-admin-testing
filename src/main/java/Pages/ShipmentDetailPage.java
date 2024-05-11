package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShipmentDetailPage extends PageBase {
    public ShipmentDetailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        act = new Actions(driver);
        executor = (JavascriptExecutor) driver;
    }

    @FindBy(css = "a.btn:nth-child(1)")
    WebElement print_btn;

    @FindBy(css = "#shipment-delete")
    WebElement delete_btn;


    @FindBy(css = "button.btn-danger")
    WebElement delete_btn_confirmation;

    public void PrintShipment() {
        print_btn.click();
    }

    public void DeleteShipment() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delete_btn.click();

        wait.until(ExpectedConditions.elementToBeClickable(delete_btn_confirmation));
        delete_btn_confirmation.click();
    }
}
