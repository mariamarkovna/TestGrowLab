import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestsAllUserAuthorization extends TestBase {
    @BeforeMethod
    public void startTest(Method m,Object[] p) {
        logger.info("Start test with method " + m.getName()+" with data: "+ Arrays.asList(p));
    }
        @Test
        public void positiveManagerTest () {// проверка авторизации аккаунта менеджера через верный email
            // и верный пароль, проверка наличия элементов, характерных для верной авторизации

            login();
            logger.info("click on login button is successfully");

            inputEmail("billye@example.com");
            pause(5000);
            logger.info("input Email is successfully");

            password();
            pause(5000);
            logger.info("input password is successfully");

            clickOnSignInBtn();
            pause(5000);
            logger.info("click on SignIn button is successfully ");

            acceptText("Welcome to your Client Portal");
            logger.info("Manager account login confirmation");

            acceptText("CLIENTS");
            logger.info("CLIENTS is exist ");
            acceptText("TEAM");
            logger.info("TEAM is exist ");
            acceptText("INVOICES");
            logger.info("INVOICES is exist ");
            acceptText("PROJECT OVERVIEW");
            logger.info("PROJECT OVERVIEW ");


            logOutFromAccount();
            pause(5000);
            logger.info("click on logOut button is successfully ");

            acceptText("GrowLab is a creative growth agency");
            logger.info("accept text GrowLab is a creative growth agency");

        }

        @Test
        public void positiveClientTest () {// проверка авторизации аккаунта клиента через верный email
            // и верный пароль, проверка наличия элементов или их отсутствия характерных для верной авторизации

            login();
            logger.info("click on login button is successfully");

            inputEmail("lucie@example.com");
            pause(5000);
            logger.info("input Email is successfully");

            password();
            pause(5000);
            logger.info("input password is successfully");

            clickOnSignInBtn();
            pause(5000);
            logger.info("click on SignIn button is successfully ");

            acceptText("Welcome to your Client Portal");
            logger.info("Client account login confirmation");
            acceptNoText("CLIENTS");
            logger.info("CLIENTS is not exist ");
            acceptNoText("TEAM");
            logger.info("TEAM is not exist ");
            acceptText("INVOICES");
            logger.info("INVOICES is exist ");
            acceptText("PROJECTS OVERVIEW");
            logger.info("PROJECTS is exist ");

           logOutFromAccount();
            logger.info("click on logOut button is successfully ");

           acceptText("GrowLab is a creative growth agency");
            logger.info("accept text GrowLab is a creative growth agency");
        }

        @Test
        public void positiveConsultantTest () {// проверка авторизации аккаунта консультанта через верный email
            // и верный пароль,проверка наличия элементов характерных для верной авторизации

            login();
            logger.info("click on login button is successfully");

            inputEmail("edra@example.com");
            pause(5000);
            logger.info("input Email is successfully");

            password();
            pause(5000);
            logger.info("input password is successfully");

            clickOnSignInBtn();
            pause(5000);
            logger.info("click on SignIn button is successfully ");

            acceptText("Welcome to your Client Portal");
            logger.info("Consultant account login confirmation");

            acceptText("CLIENTS");
            logger.info("CLIENTS is exist ");
            acceptText("TEAM");
            logger.info("TEAM is exist ");
            acceptText("INVOICES");
            logger.info("INVOICES is exist ");
            acceptText("PROJECT OVERVIEW");
            logger.info("PROJECT is exist ");

            logOutFromAccount();
            logger.info("click on logOut button is successfully ");

            acceptText("GrowLab is a creative growth agency");
            logger.info("accept text GrowLab is a creative growth agency");
        }

        @AfterMethod
        public void StopTest (Method m, Object[]p){
            logger.info("Stop Test with method " + m.getName() + Arrays.asList(p));
        }

    }
