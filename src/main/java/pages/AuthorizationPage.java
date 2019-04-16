package pages;

import actions.Operations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends Operations {
    public AuthorizationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;


    @FindBy(xpath = "//div[@class='form-authorize__title']")
    private WebElement titleAuthorize;

    @FindBy(xpath = "//input[@id='form-authorize-email']")
    private WebElement authorizeEmail;

    @FindBy(xpath = "//input[@id='form-authorize-password']")
    private WebElement authorizePassword;

    @FindBy(xpath = "//a[@class='form-authorize__forget-link']")
    private WebElement forgetLink;

    @FindBy(xpath = "//a[.='Зарегистрироваться']")
    private WebElement registration;

    @FindBy(xpath = "//div[@class='modal__close']")
    private WebElement close;

    @FindBy(xpath = "//div[@class='form-authorize__fail ng-star-inserted']")
    private WebElement authorizeFail;
}
