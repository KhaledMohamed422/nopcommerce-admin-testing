package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomersPage extends PageBase {
    public CustomersPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        act = new Actions(driver);
    }

    @FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
    WebElement add_new_button;

    @FindBy(id = "SearchEmail")
    public WebElement search_email;

    @FindBy(id = "search-customers")
    public WebElement search_btn;


    public void Open_CreateCustomerPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(add_new_button));
        act.doubleClick(add_new_button).perform();
    }

    public void Search_email(String mail) {
        search_email.sendKeys(mail);
        search_btn.click();
    }
}
