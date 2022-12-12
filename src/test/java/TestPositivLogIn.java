import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestPositivLogIn extends TestBase{


    @BeforeMethod
    public void startTest(Method m, Object[] p) {

        logger.info("Start test with method " + m.getName()+" with data: "+ Arrays.asList(p));
    }
    @Test(dataProvider ="excelCorrectDataRead", dataProviderClass=DataProviders.class)
    public void positiveAccountTest (String email, String password) {// проверка авторизации аккаунта менеджера через верный email
        // и верный пароль, проверка наличия элементов, характерных для верной авторизации
        //logger.info("Start test: check authorisation manager account");

        login();
        logger.info("click on login button is successfully");

        inputEmail(email);
        pause(5000);
        logger.info("input Email is successfully");

        inputPassword(password);
        pause(5000);
        logger.info("input password is successfully");

        clickOnSignInBtn();
        pause(5000);
        logger.info("click on SignIn button is successfully ");

        acceptText("Welcome to your Client Portal");
        logger.info("Account login confirmation");


        logOutFromAccount();
        pause(5000);
        logger.info("click on logOut button is successfully ");

        acceptText("GrowLab is a creative growth agency");
        logger.info("logOut is successfully ");

    }
    @AfterMethod
    public void StopTest (Method m, Object[]p){

        logger.info("Stop Test with method " + m.getName() + Arrays.asList(p));
    }
}
