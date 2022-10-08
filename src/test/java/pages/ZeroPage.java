package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroPage {

    public ZeroPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public static WebElement zeroSignIn;

    @FindBy(xpath = "//input[@id='user_login']")
    public static WebElement zeroLogin;

    @FindBy(xpath = "//input[@type='submit']")
    public static WebElement zeroSignIn2;

}
