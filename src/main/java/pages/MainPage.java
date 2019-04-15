package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import actions.*;


public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private Checks checks = new Checks();

    @FindBy(id="header-search")
    private WebElement searchField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement searchButton;

    public void checkMainPage() {
        checks.checkMainPage(driver, searchField);
    }

    public void checkButton(){
        checks.checkButton(searchButton);
    }

    public void inputSearchField(String search){
        searchField.sendKeys(search);
    }

    public void clickSearchButton(){
        searchButton.click();
    }
}

