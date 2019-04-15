package pages;

import actions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class ComputersPage {

    public ComputersPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private Checks checks = new Checks();

    @FindBy(xpath="//a[text()='Ноутбуки']")
    private WebElement laptops;

    @FindBy(xpath="//h1")
    private WebElement computers_text;

    public void checkComputersPage() {
        checks.checkComputersPage(computers_text, laptops);
    }

    public void clickLaptops(){
        laptops.click();
    }
}
