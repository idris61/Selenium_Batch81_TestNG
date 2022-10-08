package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage { // page sayfası oluşturduğumuzda yapacağımız ilk iş, Constructor oluşturup public yapmamız gerekir
    public AmazonPage(){ // *** CONSTRUCTOR ***

        PageFactory.initElements(Driver.getDriver(),this);// page fabrikasına gidip, initElements diyip
                                                               // Driver class'ındaki driver'ı bu class'a tanıtmalıyız.
                                                               // locate yaparken driver'a ihtiyacımız var.
    // *** Driver'i constuctor içinde çağırdık
    // *** Aslinda PageFactory class’ina, elementlere ilk degeri atayan initElements( ) metodunu kullanmak
        // icin ihtiyacimiz var
    }

    @FindBy (id="twotabsearchtextbox")
    public static WebElement aramaKutusu;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement aramaSonucWE;

    @FindBy(xpath = "//*[text()='Nutella Chocolate Hazelnut Spread, Perfect Topping for Pancakes, 35.2 oz Jar']")
    public static WebElement nutellaIlkUrun;



}