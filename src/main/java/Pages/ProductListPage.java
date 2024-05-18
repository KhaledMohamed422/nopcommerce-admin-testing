package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class ProductListPage extends PageBase {
    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locate elements
    @FindBy(id = "SearchProductName")
    WebElement searchProductName;

    @FindBy(id = "search-products")
    WebElement searchButton;

    @FindBy(how= How.XPATH, using="//button[@id='delete-selected-action-confirmation-submit-button']")
    WebElement btnConfirm;


    @FindBy(xpath="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[3]/div[1]/div/div[3]/span")
    WebElement btnok;


    @FindBy(how= How.XPATH, using="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/table/thead/tr/th[1]/input")
    WebElement selectCheckBoxAll;


    @FindBy(xpath = "//a[contains(text(), 'Add new')]")
    WebElement addNewProductButton;

    @FindBy(how=How.XPATH, using="//button[@id='delete-selected']")
    WebElement btnDelete;

    // Actions
    public void enterProductName(String productName) {
        searchProductName.clear();
        searchProductName.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickAddNewProductButton() {
        addNewProductButton.click();
    }

    public int getRowsNumber() {
        return driver.findElements(By.xpath("//table[@id='products-grid']/tbody/tr")).size();
    }

    @FindBy(how= How.XPATH, using="//select[@name='products-grid_length']")
    WebElement productLength;

    public void selectProductLength()
    {
        Select sel = new Select(this.productLength);
        sel.selectByVisibleText("100");
    }

    public boolean searchProductByName(String name) {
        boolean flag = false;

        for (int r = 1; r <= getRowsNumber(); r++) {
            try {
                String nameId = driver.findElement(By.xpath("//table[@id='products-grid']/tbody/tr[" + r + "]/td[3]")).getText();

                if (name.equals(nameId)) {
                    flag = true;
                    break; // No need to continue the loop once the product is found
                }
            } catch (Exception e) {
                flag = false;
            }
        }

        return flag;
    }

    public void selectTableItems()
    {
        List<WebElement> elements = driver.findElements(By.xpath("//input[@class='checkboxGroups']"));

        for(WebElement el : elements)
        {
            if(!el.isSelected()) {
                el.click();
            }

        }

//        WebElement selectCheckBoxAll1 = selectCheckBoxAll;
//        selectCheckBoxAll1.click();

    }

    public void clickDeleteBtn()
    {
        this.btnDelete.click();

    }

    public void clickConfirmBtn()
    {
        btnConfirm.click();
    }


    public void clickOk()
    {
        btnok.click();
    }

}
