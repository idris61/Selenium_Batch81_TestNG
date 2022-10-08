package A_Tekrar_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q05_POMClassWork_PozitiveTest {
    @Test
    public void testPozitive() {
        //1 ) Bir Class olustur :PositiveTest
        //2) Bir test method olustur positiveLoginTest() https://www.hotelmycamp.com/ adresine git login butonuna bas
        Driver.getDriver().get("https://www.hotelmycamp.com");
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();

        //test data username: manager , test data password :Manager1!
        hmcPage.userName.sendKeys("manager");
        hmcPage.password.sendKeys("Manager1!");
        hmcPage.login2.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());
        Driver.closeDriver();
    }
}
