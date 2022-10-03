package A_Tekrar_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Q01_Priority extends TestBaseBeforeClassAfterClass {

    @Test (priority = 1)
    public void testPriority() {
        //1) Bir class oluşturun:YoutubeAssertions
        //2) https://www.youtube.com adresinegidin
        driver.get("https://www.youtube.com");

        //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    }

    @Test (priority = 2)
    public void testTitle() {
        //  titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test (priority = 3)
    public void testImage() {
        //  imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='logo-icon'])[1]")).isDisplayed());
    }

    @Test (priority = 4)
    public void testSearchBox() {
        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@id='search'])[2]")).isEnabled());
    }

    @Test (priority = 5)
    public void testWrongTitle() {
        // wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle ="youtube";
        String actualTitle =driver.getTitle();
        Assert.assertFalse(actualTitle.equals(expectedTitle));
    }
}
