package tests.day20_SmokeTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegetifTest {

    @Test
    public void yanlisKullanici() { // 1. SENARYO : YANLIŞ KULLANICI - DOĞRU ŞİFRE

        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data uhmcWrongUser = manager1 ,  test data password = Manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());

        //Sayfayı kapatalım
        Driver.closeDriver();
    }

    @Test
    public void yanlisSifre() {  // 2. SENARYO : DOĞRU KULLANICI - YANLIŞ ŞİFRE

        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data userName = manager ,  test data hmcWrongPassword = manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword"))
                .sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());

        //Sayfayı kapatalım
        Driver.closeDriver();
    }

    @Test
    public void yanlisKullaniciSifre() { // 3. SENARYO : YANLIŞ KULLANICI - YANLIŞ ŞİFRE

        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //login butonuna bas
        hmcPage.login.click();

        //test data hmcWrongUser = manager1r ,  test data hmcWrongPassword = manager1!
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hmcWrongPassword"))
                .sendKeys(Keys.ENTER).perform();

        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());

        //Sayfayı kapatalım
        Driver.closeDriver();
    }
}
