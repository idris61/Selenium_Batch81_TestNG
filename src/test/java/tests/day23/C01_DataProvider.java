package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();

        //Amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //Nutella için arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualKelime = amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test (dataProvider = "aranacakKelimeler")
    public void test02(String kelimeler) {

        AmazonPage amazonPage = new AmazonPage();

        //amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.aramaSonucWE.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));

        //sayfayi kapatalim
        Driver.closeDriver();

    }
}