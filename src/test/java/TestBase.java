import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver wd;


    @BeforeTest
    public void prepare(){
        wd = new FirefoxDriver();
        wd.get("https://derrick686.softr.app/");
        wd.manage().window().maximize();
        click(By.xpath("//*[@id=\"home-header2\"]/div/div[1]/ul/li[2]/a"));


    }
    @AfterTest
    public void afterTest(){
        wd.quit();
    }



    public void click(By locator){
        wd.findElement(locator).click();

    }


    public void clear(By locator){
        wd.findElement(locator).clear();
    }


    public void type(By locator, String text){
        wd.findElement(locator).sendKeys(text);
    }


    public void email(String email){
        click(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        clear(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"));
        type(By.xpath("//*[@id=\"sw-form-capture-email-input\"]"), email);
    }

    public void password(){
        click(By.id("sw-form-password-input"));
        clear(By.id("sw-form-password-input"));
        type(By.id("sw-form-password-input"), "123456");
    }

    public void signIn(){
        click(By.id("sw-sign-in-submit-btn"));

    }

    public void logOut(){
        click(By.id("navbarDropdown"));
        acceptText("           Sign Out          ");
        click(By.xpath("/html/body/div[1]/nav/div/div[1]/ul/li[5]/div/a/span/span"));



    }




    public void acceptText(String acceptText){
        String source = wd.getPageSource();
        //String acceptText="Welcome to your Client Portal";
        Assert.assertTrue(source.contains(acceptText));
    }

    public void alertText(){
        String source = wd.getPageSource();
        String alertText="Invalid email or password";
        Assert.assertTrue(source.contains(alertText));
    }


}