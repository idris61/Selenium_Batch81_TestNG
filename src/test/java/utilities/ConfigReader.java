package utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
    /*
    ***  ConfigReader class test method’larimiz ile Configuration.properties arasinda iletisimis saglar.
    ***  Bu class’da test class’larindan kolayca ulasmak icin static method bulunur.
    ***  Method static oldugundan method icerisinden cagiracagimiz variable da static olmalidir.
    ***  Kullanacagimiz static variable’a ilk degeri atamak icin(instantiate) de static block kullaniriz.
     */
public class ConfigReader {

    public static Properties properties;
    static { // Her method'dan önce çalışır
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            // fis dosyayolunu tanımladığımız configuration.properties dosyasını okudu
            properties = new Properties();
            properties.load(fis); // fis'in okuduğu bilgileri properties'e yükledi
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        /*
        test metodundan yolladığımız string key değerini alıp
        Properties class'ından getProperty() methodunu kullanarak
        bu key'e ait value'yu bize getirir
         */
        return properties.getProperty(key);
    }
}
