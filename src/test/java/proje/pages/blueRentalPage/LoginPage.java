package proje.pages.blueRentalPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[@role='button'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id='formBasicEmail']")
    public WebElement email;
}
