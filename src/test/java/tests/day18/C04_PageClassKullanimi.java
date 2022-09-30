package tests.day18;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C04_PageClassKullanimi {

    @Test
    public void test01(){

        AmazonPage amazonPage=new AmazonPage();// AmazonPage classindan obje ureterek buradan methodlarini cagiriyoruz
        //*** Amazon Page de obje oluşturuken, parametresiz AmazonPage() constuctor'ını kullandık.
        //*** AmazonPage() constuctor'ı da,
        //    AmazonPage class'ında page fabrikasına gidip, initElements diyip, Driver class'ındaki driver'ı getirip çalıştırdı.

        //amazona gidelim
        Driver.getDriver().get("http://www.amazon.com");

        //nutellayi aratalim
        amazonPage.aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        //sonuc yazisinin nutella icerdigini test edelim
        String actualSonucu=amazonPage.aramaSonucWE.getText();
        String arananKelime="nutella";

        Assert.assertTrue(actualSonucu.contains(arananKelime));
    }
}