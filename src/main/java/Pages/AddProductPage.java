package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddProductPage extends PageBase{
    public AddProductPage(WebDriver driver) {
        super(driver);
    }

    WebElement listItem;
    WebElement element;

    @FindBy(xpath="/html/body/div[3]/div[1]/form/div[1]/div/button[1]")
    WebElement btnSave;

    @FindBy(how=How.XPATH, using="//input[@id='Name']")
    WebElement productName;

    @FindBy(xpath = "/html/body/div[3]/div[1]/form[1]/div/div/a")
    WebElement btnAddNew;


    public void clickAddNewProduct()
    {
        btnAddNew.click();
    }

    public void clickAddSaveProduct()
    {
        btnSave.click();
    }

    public void addProductName(String name)
    {
        this.productName.clear();
        this.productName.sendKeys(name);
    }
}
