package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderDetailPage extends PageBase{
    public OrderDetailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @FindBy(xpath = "/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card[1]/div/div[2]/div[1]/div/div[4]/div[2]/div/div[1]/div")
    public WebElement status;

    @FindBy(id="cancelorder")
    WebElement cancel_btn;

    @FindBy(id="cancelorder-action-confirmation-submit-button")
    WebElement cancel_confirmation_btn;

    @FindBy(xpath = "//a[@href='/Admin/Order/ShipmentList']")
    WebElement Shipments;

    public void Cancel() {
        cancel_btn.click();

        wait.until(ExpectedConditions.elementToBeClickable(cancel_confirmation_btn));
        cancel_confirmation_btn.click();
    }

    public void Open_shipmentsPage() {
        Shipments.click();
    }
}
