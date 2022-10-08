package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class C03_1_SofrAssert extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void test01() {

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@name='user_login']"));
        loginKutusu.sendKeys("username");

        // 4. Password kutusuna “password” yazin
        WebElement passKutusu= driver.findElement(By.xpath("//input[@id='user_password']"));
        passKutusu.sendKeys("password");

        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement ddo=driver.findElement(By.xpath("//select[@name='currency']"));
        Select select=new Select(ddo); // DropDown olduğu için select objesini oluşturuyoruz.
        select.selectByVisibleText("Eurozone (euro)");

        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert=new SoftAssert(); // sof assert dediği için softAssert objesini oluşturuyoruz.
        String secilenOption= select.getFirstSelectedOption().getText(); // seçileni getir dedik
        String expectedOption="Eurozone (euro)";
        softAssert.assertEquals(secilenOption,expectedOption,"secilen option uygun degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One",
        // "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)",
        // "Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<String> ulkeler = new ArrayList<String>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)",
                "Switzerland (franc)", "China (yuan)", "Denmark (krone)",
                "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        List<WebElement> optionList = select.getOptions();
        List<String> optionListString = new ArrayList<>();
        for (WebElement each : optionList) {
            optionListString.add(each.getText());

        }

        Collections.sort(ulkeler);
        Collections.sort(optionListString);

        softAssert.assertEquals(optionListString, ulkeler, "eslesme dogru");

        softAssert.assertAll();
        System.out.println("Hata varsa burası çalışmaz");

        /*
        List<String> expectedList = new ArrayList<String>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        System.out.println(expectedList);
        List<WebElement> optionList = select.getOptions();
        for (int i = 0; i < optionList.size(); i++) {
            for (int j = 0; j < expectedList.size(); j++) {
                softAssert.assertTrue(expectedList.get(j).equals(optionList.get(i).getText()));
         */

    }
}