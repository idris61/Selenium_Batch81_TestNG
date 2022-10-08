package A_Tekrar_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q06_POMClassWork_NegativeTest {
    @Test
    public void testNegative() {
        //1 ) Bir Class olustur :NegativeTest
        //2) Bir test method olusturNegativeLoginTest() https://www.hotelmycamp.com/ adresine git login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();

        //test data username: manager1 , test data password :manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("manager1"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("manager1!"));
        hmcPage.login2.click();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());

        Driver.closeDriver();

    }
}
