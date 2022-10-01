package tests.day19;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SingletonPattern {

    @Test
    public void test01() {
        //Driver obj = new Driver(); //==> constructor'ı private yaptığımız için kullanıma izin vermiyor.(private Driver())
        //obj.getDriver().get(ConfigReader.getProperty("amznUrl"));

        /*
        SingletonPattern : tekli kullanım demektir. Bir class'ın farklı class'lardan
        obje oluşturarak kullanımını engellemektir.

         POM'da Driver classindaki getDriver() ile obje olusturularak kullanilmasini
        engellemek icin Singleton pattern kullanimi benimsemistir.

        Singleton Pattern: tekli kullanim, bir class'in farkli classlardan
        obje olusturularak kullanimi engellemk icin kullanilir.
        bunu yapmamiz icin obje olusturmak icin kullanilan constructor'i private yaptigimiz zaman
        baska classlardan Driver classindan obje olusturulmasi mumkun olamaz.
            private Driver(){

            }
         */
        /*
        Driver constructor'ının başka classlardan obje oluşturularak kullanılmasını engellersek,
        kimse Driver class'ından obje oluşturamaz.
        Bir constructor'ı private yaptığımızda, başka class'larda Driver class'ından obje oluşturması mümkün olamaz

        Amaç, Driver class'ının sadece static yöntemle kullanılması istenmektedir. Başka bir yöntemle kullanılmasın.
         */



    }
}