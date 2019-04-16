package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.AuthorizationPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class LoginTestSteps {

    protected static WebDriver driver;

    protected AuthorizationPage authorizationPage;
    protected MainPage mainPage;

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

        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://frontend.beproducer.pro/main");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Пусть("^находимся на главной странице")
    public void checkMainPageStep() {
        mainPage.checkEnabledFields();
    }


    @After
    public static void tearDown() {
        driver.close();
        driver.quit();
    }


}
