package Pages;

import org.openqa.selenium.WebDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddManufacturer extends  PageBase{

    public AddManufacturer(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using="//a[@href='#']//span[contains(text(), 'Catalog')]")
    @CacheLookup
    WebElement lnkCatalog;

    @FindBy(how=How.XPATH, using="//a[@href='/Admin/Manufacturer/List']")
    @CacheLookup
    WebElement manufacturers;

    @FindBy(xpath="/html/body/div[3]/div[1]/div[1]/div/a")
    @CacheLookup
    WebElement addNew;

    @FindBy(how=How.XPATH, using="//div[@class='input-group input-group-required']//input[@class='form-control text-box single-line']")
    @CacheLookup
    WebElement name;

    @FindBy(how=How.XPATH, using="//div[@class='qq-upload-button-selector qq-upload-button']//input[@type='file']")
    @CacheLookup
    WebElement uploadImage;

    @FindBy(how=How.XPATH, using="//input[@id='PageSize']")
    @CacheLookup
    WebElement pageSize;

    @FindBy(how=How.XPATH, using="//span[@class='k-select']//span[@class='k-link k-link-increase']//span[@class='k-icon k-i-arrow-60-up']")
    @CacheLookup
    WebElement pagesizeArrowUp;

    @FindBy(how=How.XPATH, using="//span[@class='k-select']//span[@class='k-link k-link-decrease']//span[@class='k-icon k-i-arrow-60-down']")
    @CacheLookup
    WebElement pagesizeArrowdown;

    @FindBy(how=How.XPATH, using="//input[@id='PageSizeOptions']")
    @CacheLookup
    WebElement pageSizeOptions;

    @FindBy(how=How.XPATH, using="//input[@id='PriceRanges']")
    @CacheLookup
    WebElement priceRanges;

    @FindBy(how=How.XPATH, using="//input[@id='DisplayOrder']")
    @CacheLookup
    WebElement displayOrder;

    @FindBy(how=How.CSS, using="body.skin-blue.sidebar-mini.advanced-settings-mode:nth-child(2) div.wrapper:nth-child(5) div.content-wrapper div.content:nth-child(4) div.form-horizontal div.panel.panel-default.collapsible-panel div.panel-container div.panel-body div.form-group:nth-child(5) div.col-md-9 span.k-widget.k-numerictextbox:nth-child(1) span.k-numeric-wrap.k-state-default span.k-select span.k-link.k-link-increase:nth-child(1) > span.k-icon.k-i-arrow-60-up")
    WebElement orderArrowUp;

    @FindBy(how=How.XPATH, using="//button[@name='save']")
    @CacheLookup
    WebElement btnSave;

    public void clickLnkCatalog()
    {
        this.lnkCatalog.click();
    }

    public void clickLnkManufacturers()
    {
        manufacturers.click();
    }

    public void clickAddNew()
    {
        addNew.click();
    }


    public void addManufacturerName(String mName)
    {

        this.name.sendKeys(mName);
    }

    public void pageSizeOptions(String opt)
    {
        this.pageSizeOptions.clear();
        this.pageSizeOptions.sendKeys(opt);
    }

    public void priceRanges(String range)
    {
        this.priceRanges.clear();
        this.priceRanges.sendKeys(range);
    }

    public void displayOrder()
    {

        for(int i=0; i < 10; i++) {

            Actions action = new Actions(driver);
            action.moveToElement(this.orderArrowUp).click().perform();

        }
    }

    public void pageSize()
    {


        for(int i=0; i< 20; i++)
        {
            Actions action = new Actions(driver);
            action.moveToElement(this.pagesizeArrowUp).click().perform();
        }
    }

    public void clickSaveButton()
    {
        this.btnSave.click();
    }

    public void loadImage(String imagePath) throws AWTException, InterruptedException
    {
        StringSelection select = new StringSelection(imagePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

        Actions action = new Actions(driver);

        action.moveToElement(this.uploadImage).click().perform();

        //create object of robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

        //Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //Wait
        Thread.sleep(1000);

        //Realease CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        Thread.sleep(1000);

        //Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


}
