package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HmcPage { // HER PAGE OLUŞTURDUĞUMUZDA YAPACAĞIMIZ İLK İŞ CONSTRUCTOR OLUŞTURMAK.!!!
    public HmcPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement login;
    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement login2;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagement;

    @FindBy(xpath = "(//*[@class='icon-calendar'])[4]")
    public WebElement roomReservation;

    @FindBy(xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addroomReservation;

    @FindBy(xpath = "//*[@id='IDUser']")
    public WebElement idUser;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement RoomReservationText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement OKButton;




    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[1]")
    public WebElement girisYapildi;

    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement girisYapilmadi;


}