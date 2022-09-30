package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {

    protected WebDriver driver;

    // @BeforeClass ve @AfterClass notasyonlarını TestNG de kullanırken JUnit'deki gibi static yapmaya gerek yoktur.
      /*
     TestNg bize daha fazla before ve after notasyonlari sunar
     diger before/after notasyonlari tanimlayacagimiz
     grup, test veya sut'den once ve sonra calisirlar
     ileride xml dosyalari ile birlikte bunu gorecegiz
     */

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public void tearDown(){
        // driver.close();
    }
}