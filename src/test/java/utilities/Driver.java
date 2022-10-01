package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver { // İSTEDİĞİMİZ ZAMAN DRIVER'I GETİRECEK, İSTEDİĞİMİZ ZAMAN DRIVER'I KAPATACAK.
        /*
        POM'de Driver için TestBase class'ina extends etmek yerine
        Driver class'indan static method'lar kullanarak driver oluşturup,
        ilgili ayarların yapılması ve en sonda driver'in kapatılması tercih edilmiştir.
         */

        /*
        Testlerimizi çalıştırdığımızda her seferinde yeni driver oluşturduğu için her test methodu
        için yeni bir pencere(driver) açıyor. Eğer driver'a bir değer atanmamışsa yani driver==null ise
        bir kere driver'i çalıştır diyerek bir kere if içini çalıştıracak. Ve driver artık bir kere
        çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer
        teslerimiz aynı pencere(driver) üzerinde çalışacak
        */
        /*
         POM'da Driver classindaki getDriver() ile obje olusturularak kullanilmasini
        engellemek icin Singleton pattern kullanimi benimsemistir.
        Singleton Pattern: tekli kullanim, bir class'in farkli classlardan
        obje olusturularak kullanimi engellemk icin kullanilir.
        bunu yapmamiz icin obje olusturmak icin kullanilan constructor'i private yaptigimiz zaman
        baska classlardan Driver classindan obje olusturulmasi mumkun olamaz.
         */
    private Driver(){

    }
    static WebDriver driver;            // static olmalı cunku getDriver() ve closeDriver() methodu static

    public static WebDriver getDriver(){// Bu method bize; driver class'ından getDriver'i çağırdığımızda bize driver'ı getirecek.
                                            // void yapmıyoruz cunku biz driver ile methodlari çalıştıracağız. Bize driver
                                            // dondurmesi lazim ki, getDriver() methodundan sonra driver methodlarina ulasabilelim
        if (driver==null) {          // burda driverin değeri null ise yani driver açık değilse bize driveri açsın,çalıştırsın

            switch (ConfigReader.getProperty("browser")){ // configuration.properties deki "browser"'ın karşılığındaki değer
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "headless-chrome" :  // arka planda çalışıp, sonucu döndürüyor.
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }
    /*
    Temel mantığımız şu; artık extends ile değil,
    Driver class'ındaki static methodlarla driver'ı kullanmak açmak/kapatmak istiyoruz.
    Açmak için daha önce TestBase de yaptığımız setup methodunu, kapatmak için de daha önce TestBase de yaptığımız
    tearDown ı koyduk.
    Burada şöyle bir problem var; biz her driver kullanmak istediğimizde getDriver() methodunu çağırıyoruz, dolayısıyla
    driver = new ChromeDriver(); dediği için her seferinde yeni bir pencere açılıyor.
    Bunun önüne geçebilmek için; if ile, daha önceden driver'a new ChromeDriver atanmışsa bir daha atamasın,
    atanmamışsa o zaman var olan driver'ı döndür dedik.
     */

    public static void closeDriver() { // Bu method'Un tek vazifesi driver'i kapatmak olacak.
        if (driver != null) { //burasi getDriver() ile driver calistiginda driverin değeri null değildir. Yani driver açıktır.
            // o halde test sonunda closeDriver() methodunu kullandığımızd çalışsn
            driver.close();
            driver = null; // değer olarak null atiyoruz cunku getDriver() methodunun if bodysi devreye girsin ve driver çalışsın
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
