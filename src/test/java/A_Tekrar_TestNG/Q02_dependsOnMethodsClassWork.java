package A_Tekrar_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Q02_dependsOnMethodsClassWork  {
    @Test
    public void test01() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        //https://www.amazon.com/ adresine gidin.
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));

        //Test : Amazon ana sayfaya gittiginizi test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl  =Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl,"Ana sayfaya ulasilamiyor");

        //Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
        //arama yapin ve aramanizin gerceklestigini Test edin
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
        //$16.83 oldugunu test edin

        amazonPage.nutellaIlkUrun.click();
        Driver.getDriver().findElement(By.xpath("//*[text()=' See All Buying Options ']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//input[@name='submit.addToCart']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//i[@class='a-icon a-icon-close a-icon-medium aod-close-button']")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//span[@id='nav-cart-count']")).click();

        String expectedFiyat  ="$16.83";
        String actualFiyat =Driver.getDriver().findElement(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")).getText();
        System.out.println("actualFiyat = " + actualFiyat);

        softAssert.assertNotEquals(actualFiyat, expectedFiyat,"Fiyat lar ayni degil");
        softAssert.assertAll();
        Driver.closeDriver();
    }
}