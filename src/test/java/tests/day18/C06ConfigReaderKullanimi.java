package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06ConfigReaderKullanimi {

    @Test
    public void test01(){

        //facebook anasayfaya gidin
        //kullanici mail kutusuna rast gele bir isim yazdirin
        //kullanici sifre kutusuna rast gele bir password yazdirin
        //login butonuna basin
        //giris yapilamadigini test edin

        FacebookPage facebookPage=new FacebookPage(); // PAGE SAYFASINA OBJE İLE ULAŞACAĞIZ.!!!

        // facebook anasayaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("faceUrl")); // configuration.properties dosyasından Url'yi getirdi

        // cikarsa cookies kabul edin
        // facebookPage.cookieButonu.click();

        // kullanici mail kutusuna yanlış kullanıcı adı yazdirin
        facebookPage.email.sendKeys(ConfigReader.getProperty("fbWrongEmail"));// configuration.properties dosyasından fbWrongEmail'i getirdi

        // kullanici sifre kutusuna yanlış bir password yazdirin
        facebookPage.sifre.sendKeys(ConfigReader.getProperty("fbWrongPassword"));// configuration.properties dosyasından fbWrongPassword'u getirdi

        // login butonuna basin
        facebookPage.login.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();

    }
}