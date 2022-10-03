package tests.day16;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DependsOnMethod extends TestBaseBeforeMethodAfterMethod{

    /*
      DependsOnMethods test method'larinin calisma siralamasina karismaz
      Sadece bagli olan test, baglandigi testin sonucuna bakar
      baglandigi test PASSED olmazsa, baglanan test hic calismaz(ignore)
     */
    @Test
    public void testJsExecuter() {
        //  2 hotelmycamp anasayfasinagidin
        driver.get("https://www.hotelmycamp.com/");

        //  3 2farklitestmethod’uolusturarak actionsclassi ve JsExecutor kullanarak asagidaki odaturlerinden
        //  ustsira ortadaki odayi tiklayin
        WebElement room= driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",room);
        jse.executeScript("arguments[0].click();",room);

        //  4istediginiz oda inceleme sayfasi acildigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//*[text()='Mrs. Fredericka Kling'])[1]")).isDisplayed());

    }
    @Test
    public void testActions()  {
        driver.get("https://www.hotelmycamp.com/");
        WebElement room= driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        room.click();
    }
}
