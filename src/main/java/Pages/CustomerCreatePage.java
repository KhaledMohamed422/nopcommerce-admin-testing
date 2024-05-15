package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerCreatePage extends PageBase {
    public CustomerCreatePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement password;
    @FindBy(id="FirstName")
    WebElement fName;
    @FindBy(id="LastName")
    WebElement lName;
    @FindBy(id="Gender_Male")
    WebElement genderMale;
    @FindBy(id="Gender_Female")
    WebElement genderFemale;
    @FindBy(id="AdminComment")
    WebElement adminComment;
    @FindBy(css = "button.btn-primary:nth-child(1)")
    WebElement save_btn;

    public void CreateCustomer(String fname, String lname, boolean ismale, String mail, String pass, String admincomment) {
        fName.sendKeys(fname);
        lName.sendKeys(lname);
        email.sendKeys(mail);
        password.sendKeys(pass);
        if (ismale)
            genderMale.click();
        else
            genderFemale.click();
        adminComment.sendKeys(admincomment);
        save_btn.click();
    }
}