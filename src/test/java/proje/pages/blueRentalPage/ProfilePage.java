package proje.pages.blueRentalPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;


public class ProfilePage {
    public ProfilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//*[text()='Your profile updated successfully']")
    public WebElement profilGuncellendiYazisi;


}
