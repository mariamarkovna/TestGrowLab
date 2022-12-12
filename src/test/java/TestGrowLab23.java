import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestGrowLab23 extends TestBase {
    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Start test with method " + m.getName()+" with data: "+ Arrays.asList(p));
    }

    @DataProvider
    public Iterator<Object[]> getWrongLoginData(){
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"wrong email","password"});
        list.add(new Object[]{"biley@example.com","12345"});
        list.add(new Object[]{"biley_example.com","123456"});

        return list.iterator();
    }



   // @Test(dataProvider = "getWrongLoginData")
        @Test(dataProvider ="excelWrongDataRead", dataProviderClass=DataProviders.class)
    public void negativTest(String email, String password) throws InterruptedException {// проверка авторизации аккаунта менеджера через ошибочный email
        // и верный пароль

        login();
        logger.info("click on login button is successfully");

        inputEmail(email);
        pause(2000);
        logger.info("input Email is successfully");

        inputPassword(password);
        pause(2000);
        logger.info("input password is successfully");

        clickOnSignInBtn();
        pause(2000);
        logger.info("click on SignIn button is successfully ");

        alertText("Invalid email or password");
            logger.info("alert invalid email or password");



    }

    //@Test
//    @Test
//    public void negativTest2(String email, String password) throws InterruptedException {// проверка авторизации аккаунта  без данных email
//        // и верный пароль
//
//
//
//        inputEmail(email);
//
//        inputPassword(password);
//        pause(2000);
//
//        clickOnSignInBtn();
//        pause(2000);
//
//        alertText("Invalid email or password");
//
//    }
//
//    @Test
//    public void negativTest3(String email, String password) throws InterruptedException {// проверка авторизации аккаунта клиента через ошибочный email
//        // и верный пароль
//
//        pause(5000);
//
//        inputEmail(email);
//        pause(5000);
//
//        inputPassword(password);
//        pause(5000);
//
//        clickOnSignInBtn();
//        pause(5000);
//
//        alertText("Invalid email or password");
//
//
//    }


}
