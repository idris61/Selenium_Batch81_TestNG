package tests.day18;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C00_Not extends TestBaseBeforeMethodAfterMethod {

    /*    TestNG Framework'ün JUnıt'ten Farkları
    1- Before ve After methodları daha fazla
        - JUnit'teki Before-After ın yerine ==> TestNG de Before Method-After Method geldi ( daha spesifik, daha maksadını anlatıcı)
        - JUnit'teki Before Class-After Class 'ın Static olma mecburiyeti varken ==> TestNG de bu mecburiyet yoktur.

    2- Priority
        - JUnit'te testlerin sıralamasını biz belirleyemiyorduk. Kafasına göre takılıyor.
        - TestNG de test methodlarının ismine göre sıralama belirliyor. Test ismine göre değilde, kendi belirlediğimiz
          sıraya göre yapsın istersek Priority yazmamız gerekiyordu.
            - Priority de nekadar küçük o kadar önce demekti
            - Priority yazmazsak sıfır kabul eder,
            - Priority si aynı olanlarda da harf sırasına göre bakar.

    3- DependsOnMethods ==> ... şu methoda bağlı olarak çalış demek
        - DependsOnMethods, methodların çalışma sırasına karışmaz. Sıralama nasıl çalışacaksa dependsOnMethods
          müdahil olmadan sıralamaya uyar.
        - test-2 nin çalışma sırası geldiğinde (Priority ye karışmıyor) dependsOnMethods devreye giriyor,
            Eğer test-1 başarılı ise test-2 çalışıyor,
            test-1 failed olduysa, test-2 ignore oluyor hiç çalışmıyor.
        - aynı şekilde, test-3'e sıra geldiğinde, test-2 başarılı ise test-3 çalışıyor.

        - tek başına test-2 methodunu çalıştırırsak, test-1'e bağlı olduğu için amazona gider ve test çalışır.
          test-2 dependsOnMethods ile test-1'e bağlı olmasa idi, test-2 yi tek başına çalıştırdığımızda amazon'a
          gidemeyeceği için çalışmazdı.
        - tek başına test-3 methodunu çalıştırırsak, test-2 yi çalıştırmayı deneyecek, test-2 de amazona gidemediği
          için failed olur. üçlü şekilde çalışmaz.

    4- SoftAssert
        - JUnit de assertion, çok katı (hardAssert). ilk hatayı bulduğunda exeqution'ı durdurup hemen raporlamaya geçiyordu.
        - TestNG de SoftAssert, önce tüm testleri çalıştırıyor, sonra toptan nerede hata varsa raporluyor.
            - Assert ==> methodlar static, clasismi.method
            - SoftAssert ==> methodlar static değil, önce obje oluşturmamız gerekiyor, bitiş noktasını da belirtmemiz gerekiyor.
              Softassert'un hata bulsa bile calismaya devam etme ozelligi assertAll()'a kadardir.
              Eger assertAll()'da failed rapor edilirse calisma durur ve class'in kalan kismi calistirilmaz
              (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)

              SoftAssert başlangıcı obje oluşturmaktır. ==> SoftAssert softAssert = new SoftAssert();
              SoftAssert'e bitiş satırını söylemek için ==> softAssert.assertAll();
     */
    public void test1() {
      // amazon ana sayfasına gidelim
      driver.get("https://www.Wamazon1.com");
    }

    @Test (dependsOnMethods = "test1")
    public void test2() {
      //Nutella aratalım
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test2")
    public void test3() {
      //Sonuc yazısının amazon içerdiğini test edelim
      WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
      Assert.assertFalse(sonuc.getText().contains("amazon"));
    }
    @Test
    public void test4() {
      System.out.println("bak bu da calisti");
    }
}
    /*                          ÖNCEKİ DERSTEN AKLIMIZDA KALANLAR

    1- POM : Page Object Model java OOP konsept ile selenium'u birleştren, testlerimizi daha hızlı, daha anlaşılır,
             reausable ve easy maintable özelliklerine sahip popüler bir framework dizayn modelidir.

    2- Temel hedef test method'larında elle girilen hiçbir değer olmamasıdır (url, locate veya test data)

    3- Temelde projemizde 3 package bulunur

        - Pages : locate işlemlerini ve reusable login method'u gibi sıradan methodları koyarız.
        - Utilities : projemiz için gerekli extra kaynaklar (alet-edavat)
        - Tests : bütün testlerimiz

    4- Pages paketinde kullandığımız her bir page için ayrı bir page classi olur. Eğer test ettiğimiz page'de çok fazla
       özellik varsa her bir epic için ayrı page class'i oluşturabiliriz.
       Her page sayfası oluşturduğumuzda ilk yapmamız gereken parametresiz constuctor oluşturup, constuctor içinde
       pageFactory class'ından initElement() kullanıp, Driver class'ındaki getDriver()'in getireceği driver'ı
       bu class (this)'da geçerli olacağını tanımlamadır.
       Page sayfalarında bugüne kadar locate için kullandığımız findElement veya findElements() yerine @FindBy notasyonu
       kullanılır. Değişen ikinci satır olur. Public WebElement aElementi olurken diğerinde
       public List<WebElement> aElementleriListesi

    5- Driver class'ı oluşturup bize driver döndürecek getDriver() ve driver'i kapatacak Driverclose() methodlarınıda
       oluşturduk.
       Bu iki methoda heryerden kolayca erişebilmek için method'ları static olarak tanımladık.


     */