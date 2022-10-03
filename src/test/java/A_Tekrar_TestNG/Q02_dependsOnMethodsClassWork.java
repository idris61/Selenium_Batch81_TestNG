package A_Tekrar_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Q02_dependsOnMethodsClassWork  {
    @Test
    public void testDependsON() {

        SoftAssert softAssert = new SoftAssert();

        // Bir class oluşturun:DependsOnTest
        // https://www.amazon.com/ adresine gidin.
        AmazonPage amazon = new AmazonPage();
        Driver.getDriver().get("https://www.amazon.com");

        // 1.Test : Amazon ana sayfaya gittiginizi test edin
        String expecteUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expecteUrl, "Amazon ana sayfaya ulasilamiyor.");

        // 2.Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin arama yapin ve aramanizin gerceklestigini Test edin
        AmazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // 3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin vefiyatinin
        // $16.83 oldugunu test edin
        AmazonPage.nutellaIlkUrun.click();

    }
}
