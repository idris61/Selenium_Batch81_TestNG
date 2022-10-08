package A_Tekrar_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q08_SmokeTest_NegatifTest {
    /*
        //1)smokeTestpaketi altinda yeni bir Classolustur:NegativeTest 3 Farkli test Methodunda 3 senaryoyu testet
        //-yanlisSifre
        //-yanlisKulllanici
        //-yanlisSifreKullanici
        //test data yanlis username: manager1 , yanlis password :manager1
        //2)https://www.hotelmycamp.com adresinegit
        //3)Login butonunabas
        //4)Verilen senaryolar ile giris yapilamadigini testet

     */
    @Test
    public void testYanlisSifre() { // YANLIŞ ŞİFRE - DOĞRU KULLANICI
        Driver.getDriver().get((ConfigReader.getProperty("hmcUrl")));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.login2.click();
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void testYanlisKullanici() { // DOĞRU ŞİFRE - YANLIŞ KULLANICI ADI
        Driver.getDriver().get((ConfigReader.getProperty("hmcUrl")));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));
        hmcPage.login2.click();
        Assert.assertTrue(hmcPage.girisYapildi.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void testYanlisSifreKullanici() { // YANLIŞ ŞİFRE - YANLIŞ KULLANICI
        Driver.getDriver().get((ConfigReader.getProperty("hmcUrl")));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));
        hmcPage.login2.click();
        Assert.assertTrue(hmcPage.girisYapilmadi.isDisplayed());
        Driver.closeDriver();
    }
}
