package A_Tekrar_TestNG;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q04_PageObjectModelClassWork {
    @Test
    public void testPOM() {
        // 1- https://www.facebook.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl"));

        // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin
        FacebookPage facebookPage=new FacebookPage();
        Faker faker=new Faker();

        // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();

        // 4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();
    }
}
