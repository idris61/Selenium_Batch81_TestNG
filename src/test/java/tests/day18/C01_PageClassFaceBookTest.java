package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassFaceBookTest {
    @Test
    public void test01() {
       /*
       Bugune kadar TestBase classina extends ederek kullandigimiz
       driver yerine bundan sonra Driver class'indan kullanacagimiz getDriver static method'unu kullanacagiz

       Driver.getDriver() ---->IN
       driver----------->OUT
        */

        //https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();

        //Faker class’ini kullanarak email ve sifre degerlerini
        //yazdirip, giris butonuna basin
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.sifre.sendKeys(faker.internet().password());
        facebookPage.login.click();

        //Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilmadi.isDisplayed());
    }
}