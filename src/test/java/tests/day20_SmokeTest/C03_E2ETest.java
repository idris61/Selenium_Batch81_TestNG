package tests.day20_SmokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HmcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() throws InterruptedException {

        //https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();

        //Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        //Username : manager
        //Password  : Manager1!
        //Login butonuna tıklayın.
        hmcPage.login.click();
        hmcPage.userName.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.password.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.login2.click();

        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hmcPage.hotelManagement.click();
        Thread.sleep(2000);
        hmcPage.roomReservation.click();
        Thread.sleep(2000);
        hmcPage.addroomReservation.click();

        //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //Save butonuna tıklayın.
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

        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hmcPage.RoomReservationText.isDisplayed());

        //OK butonuna tıklayın.
        hmcPage.OKButton.click();

        Driver.closeDriver();
    }
}
