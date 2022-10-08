package A_Tekrar_TestNG;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Q10_E2ETesting_CreateRoomTest {
    @Test
    public void testE2E() throws InterruptedException {
        //1.Tests packagenin altına class olusturun: D18_HotelRoomCreation
        //2.Bir metod olusturun: RoomCreateTest()
        //3.https://www.hotelmycamp.com adresine gidin.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));

        //4.Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.
        //a.Username:managerb. Password :Manager1!
        //5.Login butonuna tıklayın.
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.login2.click();

        //6.Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hmcPage.hotelManagement.click();
        Thread.sleep(2000);
        hmcPage.roomReservation.click();
        Thread.sleep(2000);
        hmcPage.addroomReservation.click();

        //7.Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //8.Save butonuna basin.
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

        //9.“HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hmcPage.RoomReservationText.isDisplayed());

        //10.OK butonuna tıklayın.
        hmcPage.OKButton.click();

        //11.Hotel rooms linkine tıklayın.

        //12."LIST OF HOTELROOMS" textinin göründüğünüdoğrulayın..

    }
}
