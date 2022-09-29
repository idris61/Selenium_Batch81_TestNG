package tests.day17;


import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBaseBeforeClassAfterClass;

public class C04_DriverIlkTest {

    @Test
    public void test01() {
    /*
    TestBase class'ına extend ederek kullandığımız driver yerine artık Driver class'ından kullanacağımız
    getDriver() static method'unu kullanırız
     */
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://hepsiburada.com");
        Driver.closeDriver();
    }
}