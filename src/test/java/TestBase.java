import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;


    @BeforeTest
    public void prepare() {
        wd = new FirefoxDriver();
        wd.get("https://derrick686.softr.app/");
        wd.manage().window().maximize();


    }

    @AfterTest
    public void afterTest() {
        wd.quit();
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


    public void email(String email) {
        click(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        clear(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        type(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"), email);
    }

    public void password() {
        click(By.id("sw-form-password-input"));
        clear(By.id("sw-form-password-input"));
        type(By.id("sw-form-password-input"), "123456");
    }

    public void signIn() {
        click(By.id("sw-sign-in-submit-btn"));

    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void logOut() {
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

//    public boolean isClientsComponentPresent(){
//        try{
//            wd.findElement(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[2]/a");
//        } catch (NoSuchElementExeptoin ex){
//        }
//        return false;
//    }


}