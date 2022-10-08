package A_Tekrar_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q07_SmokeTest_PozitifTest {
    @Test
    public void testSmoke() {
        //1)com.techproed altinda bir package olustur :smoketest
        //2)Bir Class olustur :PositiveTest
        //3)Bir test method olustur positiveLoginTest() https://www.hotelmycamp.com adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();

        //test data username: manager , test data password :Manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.login2.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini testet
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());
        Driver.closeDriver();

    }
}
