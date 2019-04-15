package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import actions.*;
import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private Checks checks = new Checks();
    private Operations operations = new Operations();

    @FindBy(id="glpriceto")
    private WebElement maxprice; //Проверка что в такой ценовой категории HP может и не быть

    @FindBy(xpath="//span[text()='HP']")
    private WebElement selectHP;

    @FindBy(xpath="//span[text()='Lenovo']")
    private WebElement selectLenovo;

    @FindBy(xpath="//input[@name='Производитель HP']")
    private WebElement checkboxHP;

    @FindBy(xpath="//input[@name='Производитель Lenovo']")
    private WebElement checkboxLenovo;

    @FindBy(xpath="//label[@for='13887626_13899071']")
    private WebElement selectBlack;

    @FindBy(xpath="//label[@for='13887626_13887686']") //Проверка что цвета такого может и не быть
    private WebElement selectWhite;

    @FindBy(xpath="//a[text()='по цене']")
    private WebElement priceSort;

    @FindBy(xpath="//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/child::div[1]/child::div[4]/child::div[1]/child::div[1]/a")
    private WebElement topLaptopName;

    @FindBy(xpath="//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init b-spy-events i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']/child::div[1]/child::div[5]/child::div[1]/child::div[1]")
    private WebElement topLaptopPrice;

    @FindBy(xpath="//div[@class='n-snippet-card2__title']")
    private List<WebElement> allLaptops;

    @FindBy(xpath="//li[@class='n-breadcrumbs__item'][3]")
    private WebElement laptop_title;

    public void inputMaxPrice(String mp){
        maxprice.sendKeys(mp);
    }

    public void clickHP(){
        selectHP.click();
    }

    public void clickLenovo(){
        selectLenovo.click();
    }

    public void clickBlack(){
        selectBlack.click();
    }

    public void clickWhite(){
        selectWhite.click();
    }

    public void clickSort(){
        priceSort.click();
        operations.waitUpdateSort();
    }

    public void checkLaptopPage() {
        checks.checkLaptopPage(laptop_title, maxprice, selectHP, checkboxHP, selectLenovo, checkboxLenovo, selectBlack, selectWhite, priceSort);
    }

    public void checkCheckbox(){
        checks.checkCheckbox(checkboxHP, checkboxLenovo);
    }

    public void checkSort(int b) {
        checks.checkSort(Integer.parseInt(getTopLaptopPrice().replaceAll("[^0-9]", "")), b);
    }

    private String getTopLaptopName() {
        return topLaptopName.getText();
    }

    private String getTopLaptopPrice(){
        return topLaptopPrice.getText();
    }

    public void clickLaptop(){
        topLaptopName.click();
    }

    public void calcCheap(){
        operations.calcCheap(getTopLaptopPrice(),getTopLaptopName());
    }

    public void calcExpensive() {
        operations.calcExpensive(getTopLaptopPrice(),getTopLaptopName());
    }

    public void getAllLaptops(){
        operations.getAllLaptops(allLaptops);
    }
}
