package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {

        // Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://hepsiburada.com");

        // Ve sayfanın resmini alınız
        ReusableMethods.getScreenshot("hepsiburada");

        // Sayfayı kapatınız
        Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException, IOException {

        // Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        AmazonPage AmazonPage = new AmazonPage();

        // Nutella aratınız
        AmazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucWE",AmazonPage.aramaSonucWE);

    }
}