import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;

public class TestBase extends DataProviders{

    final static Logger logger = LoggerFactory.getLogger(TestBase.class);
    WebDriver wd;
    String browser;




    @BeforeTest(alwaysRun=true)

    public void prepare() {
        logger.info("Running a test: prepare in BeforeTest");
        String path;

        browser = System.getProperty("browser"); //-Dbrowser=chrome
        logger.info("Running test system property browser set to " + browser);

        if (browser.equals(Browser.CHROME.browserName())) {
            path = System.getenv("chromeDriver"); // chromeDriver=/Users/ilya/telran/Tools/chromedriver
            System.setProperty("webdriver.chrome.driver", path);
            wd = new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX.browserName())) {
            path = System.getenv("firefoxDriver"); // firefoxDriver=/Users/ilya/telran/Tools/geckodriver
            System.setProperty("webdriver.gecko.driver", path);
            wd = new FirefoxDriver();
        } else if (browser.equals(Browser.EDGE.browserName())) {
            path = System.getenv("edgeDriver"); // firefoxDriver=/Users/ilya/telran/Tools/geckodriver
            System.setProperty("webdriver.msedge.driver", path);
            wd = new EdgeDriver();
        } else if (browser.equals(Browser.OPERA.browserName())){
            path=System.getenv("operaDriver");
            System.setProperty("webdriver.opera.driver",path);
            wd = new OperaDriver();
        }  else {
            logger.error("No supported browser specified. Supported browsers: chrome, firefox, edge, opera");
        }

        //wd = new FirefoxDriver();
        wd.get("https://derrick686.softr.app/");
        wd.manage().window().maximize();



    }

    @AfterTest
    public void afterTest() {
        wd.quit();
        logger.info("Test is finnish");
    }


    public void click(By locator) {
        wd.findElement(locator).click();

    }


    public void clear(By locator) {
        wd.findElement(locator).clear();
    }


    public void type(By locator, String text) {
        wd.findElement(locator).sendKeys(text);
    }

    public void login() {
        click(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a"));
    }


    public void inputEmail(String email) {
        click(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        clear(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        type(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"), email);
    }

    public void password() {
        click(By.id("sw-form-password-input"));
        clear(By.id("sw-form-password-input"));
        type(By.id("sw-form-password-input"), "123456");
    }

    public void inputPassword(String password) {
        click(By.id("sw-form-password-input"));
        clear(By.id("sw-form-password-input"));
        type(By.id("sw-form-password-input"), password);
    }

    public void clickOnSignInBtn() {
        click(By.id("sw-sign-in-submit-btn"));

    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void logOutFromAccount() {
        click(By.id("navbarDropdown"));
        acceptText("Sign Out");
        click(By.cssSelector("div.show > a:nth-child(1)"));

    }

    public void acceptText(String acceptText) {
        String source = wd.getPageSource();
        Assert.assertTrue(source.contains(acceptText));
    }
    public void acceptNoText(String acceptNoText) {
        String source = wd.getPageSource();
        Assert.assertFalse(source.contains(acceptNoText));
    }

    public void alertText(String alertText) {
        String source = wd.getPageSource();
        Assert.assertTrue(source.contains(alertText));
    }
    public boolean acceptTextLog(String acceptText) {
        String source = wd.getPageSource();
        return source.contains(acceptText);
        }

//    public boolean isClientsComponentPresent(){
//        try{
//            wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a");
//        } catch (NoSuchElementExeptoin ex){
//        }
//        return false;
//    }


}