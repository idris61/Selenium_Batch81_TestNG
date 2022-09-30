package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage {
    public HmcPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userName;
    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement girisYapildi;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilmadi;


}