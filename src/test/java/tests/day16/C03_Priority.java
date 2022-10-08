package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod{
       /*
       TestNG test method'larini isim sirasina gore calistirir
       eger isim siralamasinin disinda bir siralama ile calismasini isterseniz
       o zaman test method'larina oncelik (priority) tanimlayabiliriz

       priority kucukten buyuge gore calisir
       eger bir test method'una priority degeri atanmamissa
       default olarak priority=0 kabul edilir.
     */

    @Test (priority = 1)
    public void youtubeTest() {
        driver.get("https://www.youtube.com");
    }

    @Test (priority = 3)
    public void BestBuyTest() {
        driver.get("https://www.bestbuy.com");
    }

    @Test (priority = 2, groups = "grup1")
    public void amazonTest() {
        driver.get("https://www.amazon.com");
    }

}
