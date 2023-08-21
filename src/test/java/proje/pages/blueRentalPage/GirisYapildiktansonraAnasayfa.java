package proje.pages.blueRentalPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import proje.utilities.Driver;

public class GirisYapildiktansonraAnasayfa {
    public GirisYapildiktansonraAnasayfa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement girisYapildiVerify;

    @FindBy(xpath = "//*[@href='/profile']")
    public WebElement profileButton;

    @FindBy(xpath = "(//*[text()='Logout'])[1]")
    public WebElement logOut;
}
