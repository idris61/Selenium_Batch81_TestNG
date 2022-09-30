package tests.day18;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C05_PageClassKullanimi {

    @Test
    public void test01(){

        //facebook anasayfaya gidin
        //kullanici mail kutusuna rast gele bir isim yazdirin
        //kullanici sifre kutusuna rast gele bir password yazdirin
        //login butonuna basin
        //giris yapilamadigini test edin

        FacebookPage facebookPage=new FacebookPage(); // PAGE SAYFASINA OBJE İLE ULAŞACAĞIZ.!!!

        // facebook anasayaya gidin
        Driver.getDriver().get("https://www.facebook.com");

        // cikarsa cookies kabul edin
        // facebookPage.cookieButonu.click();

        // kullanici mail kutusuna rastgele bir isim yazdirin
        Faker faker=new Faker();
        facebookPage.email.sendKeys(faker.internet().emailAddress());

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.sifre.sendKeys(faker.internet().password());

        // login butonuna basin
        facebookPage.login.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();

    }
}