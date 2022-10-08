package A_Tekrar_TestNG;

import com.github.javafaker.Faker;
import com.sun.source.tree.AssertTree;
import com.sun.source.tree.Tree;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q09_E2ETesting_CreateHotelTest {
    @Test
    public void testE2E() throws InterruptedException {
        //1.Tests packagenin altına class olusturun: CreateHotel
        //2.Bir metod olusturun:createHotel
        //3.https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //4.Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        //a.Username : manager
        //b.Password :Manager1!
        //5.Login butonuna tıklayın.
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.login2.click();

        //6.Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hmcPage.hotelManagement.click();
        Thread.sleep(2000);
        hmcPage.roomReservation.click();
        Thread.sleep(2000);
        hmcPage.addroomReservation.click();

        //7.Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8.Save butonuna tıklayın.
        hmcPage.idUser.sendKeys("manager");
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel")
                .sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/02/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys((faker.phoneNumber()).cellPhone()).sendKeys(Keys.TAB)
                .sendKeys((faker.internet().emailAddress())).sendKeys(Keys.TAB).sendKeys("asdfg")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        //9.“Hotel was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hmcPage.RoomReservationText.isDisplayed());

        //10.OK butonuna tıklayın.
        hmcPage.OKButton.click();
        Driver.closeDriver();
    }
}
