package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShipmentsPage extends PageBase {
    public ShipmentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div[2]/table/tbody/tr[1]")
    WebElement firstRow;
    public List<WebElement> cells=firstRow.findElements(By.tagName("td"));

    public void OpenShipmentDetail() {
        WebElement lastCell = cells.get(cells.size() - 1);
        WebElement view_btn = lastCell.findElement(By.tagName("a"));
        view_btn.click();
    }

    public String GetShipmentId() {
        String id = cells.get(2).getText();
        return id;
    }
}
