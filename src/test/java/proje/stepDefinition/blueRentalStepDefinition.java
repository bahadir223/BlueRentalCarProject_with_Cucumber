package proje.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import proje.pages.blueRentalPage.GirisYapildiktansonraAnasayfa;
import proje.pages.blueRentalPage.LoginPage;
import proje.pages.blueRentalPage.ProfilePage;
import proje.utilities.ConfigReader;
import proje.utilities.Driver;
import proje.utilities.ExcelReader;
import proje.utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class blueRentalStepDefinition {
    LoginPage login = new LoginPage();
    GirisYapildiktansonraAnasayfa sonrakiAnasayfa = new GirisYapildiktansonraAnasayfa();
    ProfilePage profilePage = new ProfilePage();

    @Then("kullanici login butonuna tiklar")
    public void kullaniciLoginButonunaTiklar() {
        login.loginButton.click();
    }

    @Then("kullanici bilgilerini girer {string},{string}")
    public void kullaniciBilgileriniGirer(String email, String password) {
        login.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
    }

    @Then("kullanici giris yapildigini dogrular")
    public void kullaniciGirisYapildiginiDogrular() {
        assertTrue(sonrakiAnasayfa.girisYapildiVerify.isDisplayed());
    }


    @Then("kullanici sag yukaridaki ismin altindaki profil butonuna basar")
    public void kullaniciSagYukaridakiIsminAltindakiProfilButonunaBasar() {
        ReusableMethods.click(sonrakiAnasayfa.girisYapildiVerify);
        ReusableMethods.bekle(2);
        ReusableMethods.click(sonrakiAnasayfa.profileButton);
    }

    @Then("exceldeki {string} sayfasindaki bilgileri kullanarak profilini gunceller")
    public void exceldekiSayfasindakiBilgileriKullanarakProfiliniGunceller(String sayfaIsmi) {
        String dosyaYolu = "src/test/resources/bluerentalCar.xlsx";
        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);
        for (int i = 1; i < excelReader.rowCount(); i++) {
            String firstName = excelReader.getCellData(i, 0);
            String lastName = excelReader.getCellData(i, 1);
            String phoneNumber = excelReader.getCellData(i, 2);
            String adress = excelReader.getCellData(i, 3);
            String zipCode = excelReader.getCellData(i, 4);
            profilePage.firstName.sendKeys(Keys.CONTROL + "a" + Keys.DELETE,
                    Keys.CONTROL + "a" + Keys.DELETE,
                    Keys.CONTROL + "a" + Keys.DELETE,
                    Keys.CONTROL + "a" + Keys.DELETE,
                    Keys.CONTROL + "a" + Keys.DELETE);
            ReusableMethods.bekle(3);
            profilePage.firstName.sendKeys(firstName, Keys.TAB,
                    lastName, Keys.TAB, phoneNumber, Keys.TAB, adress, Keys.TAB, zipCode, Keys.ENTER);
            ReusableMethods.bekle(3);
        }
    }

    @Then("kullanici bilgilerinin guncellendigini dogrular")
    public void kullaniciBilgilerininGuncellendiginiDogrular() {
        assertTrue(profilePage.profilGuncellendiYazisi.isDisplayed());
    }

    @Given("kullanici {string} sayfasina properties ile gider")
    public void kullaniciSayfasinaPropertiesIleGider(String str) {
        Driver.getDriver().get(ConfigReader.getProperty(str));
        ReusableMethods.bekle(2);
    }

    @Then("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int saniye) {
        ReusableMethods.bekle(saniye);
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
