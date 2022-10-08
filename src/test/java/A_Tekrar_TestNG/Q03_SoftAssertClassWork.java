package A_Tekrar_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q03_SoftAssertClassWork {
    @Test
    public void testSoftAssert() {
        // 1.“http://zero.webappsecurity.com/”Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        ZeroPage zeroPage = new ZeroPage();

        // 2.Sign in butonuna basin
        ZeroPage.zeroSignIn.click();

        // 3.Login kutusuna “username” yazin
        ZeroPage.zeroLogin.sendKeys("username");

        // 4.Password kutusuna “password” yazin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("password").perform();

        // 5.Sign in tusuna basin
        ZeroPage.zeroSignIn2.click();
        Driver.getDriver().navigate().back();

        // 6.Online banking menusu icinde Pay Bills sayfasina gidin
        Driver.getDriver().findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        // 7.“Purchase Foreign Currency” tusuna basin
        Driver.getDriver().findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8.“Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = Driver.getDriver().findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDown);
        select.selectByIndex(6);

        // 9.soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        WebElement ddmEurozone = Driver.getDriver().findElement(By.xpath("//*[text()='Eurozone (euro)']"));
        softAssert.assertTrue(ddmEurozone.isSelected());

        // 10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)",
        // "Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand(baht)"

        List<WebElement> ddmList = select.getOptions();

        List<String> verilenListe =  new ArrayList<>(Arrays.asList("Select One",
                "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)",
                "China (yuan)", "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)",
                "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        for (int i = 0; i <ddmList.size() ; i++) {
            softAssert.assertEquals(ddmList.get(i).getText(),verilenListe.get(i) ,i+ ".elementler esit degil");

        }
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
