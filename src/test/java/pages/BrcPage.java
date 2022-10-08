package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BrcPage {
    public BrcPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public static WebElement brclogin;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public static WebElement userEmail;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public static WebElement basariliGiris;

    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement ikinciLogin;
}
