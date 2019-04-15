import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

public class TestSteps {
    private static WebDriver driver;
    private static MainPage mainpage;
    private static ComputersPage computerspage;
    private static LaptopPage laptoppage;
    private static SingleLaptopPage singlelaptoppage;
    private static SpecPage specpage;

    @Before
    public void setup() {
        String browser = "chr";
        switch(browser) {
            case "chr":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
        }
        mainpage = new MainPage(driver);
        computerspage = new ComputersPage(driver);
        laptoppage = new LaptopPage(driver);
        singlelaptoppage = new SingleLaptopPage(driver);
        specpage = new SpecPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://market.yandex.ru/");
    }

    @Если("^открыта страница market yandex ru")
    public void checkMainPageStep() {
        mainpage.checkMainPage();
    }

    @То("^ввести в строку поиска \"Компьютеры\"")
    public void inputSearchFieldStep() {
        mainpage.inputSearchField("Компьютеры");
    }

    @Если("^кнопка \"Поиск\" активна")
    public void checkButtonStep(){
        mainpage.checkButton();
    }

    @То("^нажать кнопку \"Поиск\"")
    public void clickSearchButtonStep(){
        mainpage.clickSearchButton();
    }

    @Если("^открыт раздел с компьютерами")
    public void checkComputersPageStep(){
        computerspage.checkComputersPage();
    }

    @То("^выбрать категорию \"Ноутбуки\"")
    public void clickLaptopsStep(){
        computerspage.clickLaptops();
    }

    @Если("^открыт раздел с ноутбуками")
    public void checkLaptopPageStep(){
        laptoppage.checkLaptopPage();
    }

    @То("^задать параметр поиска до (\\d+) рублей$")
    public void inputMaxPriceStep(String mp) {
        laptoppage.inputMaxPrice(mp);
    }

    @То("^выбрать производителя HP")
    public void clickHPStep(){
        laptoppage.clickHP();
    }

    @То("^выбрать производителя Lenovo")
    public void clickLenovoStep(){
        laptoppage.clickLenovo();
    }

    @Если("^выбраны производители HP и Lenovo")
    public void checkCheckboxStep(){
        laptoppage.checkCheckbox();
    }

    @То("^выбрать цвет Чёрный")
    public void clickBlackStep(){
        laptoppage.clickBlack();
    }

    @То("^выбрать цвет Белый")
    public void clickWhiteStep(){
        laptoppage.clickWhite();
    }

    @То("^фильтровать по цене")
    public void clickSortStep(){
        laptoppage.clickSort();
    }

    @То("^вывести самый дешёвый ноутбук")
    public void calcCheapStep(){
        laptoppage.calcCheap();
    }

    @Если("^выведенные ноутбуки меньше (\\d+)$")
    public void checkSortStep(int mp){
        laptoppage.checkSort(mp);
    }

    @То("^вывести самый дорогой ноутбук и разницу в цене")
    public void calcExpensiveStep(){
        laptoppage.calcExpensive();
    }

    @То("^занести все выведенные ноутбуки в список, вывести список отсортированный по имени")
    public void getAllLaptopsStep(){
        laptoppage.getAllLaptops();
    }

    @То("^открыть страницу с ноутбуком")
    public void clickLaptopStep(){
        laptoppage.clickLaptop();
    }

    @Если("^открыта страница с ноутбуком")
    public void checkSingleLaptopPageStep(){
        singlelaptoppage.checkSingleLaptopPage();
    }

    @То("^выбрать раздел с характеристиками")
    public void clickSpecsStep(){
        singlelaptoppage.clickSpecs();
    }

    @Если("^открыт раздел с характеристиками ноутбука")
    public void checkSpecPageStep(){
        specpage.checkSpecPage();
    }

    @То("^создать класс \"Питание\", занести характеристики в отдельные поля, создать его конструктор")
    public void createLaptopPowerStep(){
        specpage.createLaptopPower();
    }

    @То("^нажать на поле с вопросом")
    public void clickTipStep(){
        specpage.clickTip();
    }

    @То("^вывести текст подсказки")
    public void readPopUpStep(){
        specpage.readPopUp();
    }

    @After
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
