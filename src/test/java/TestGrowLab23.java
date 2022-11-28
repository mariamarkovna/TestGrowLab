import org.testng.annotations.Test;

public class TestGrowLab23 extends TestBase {


    @Test
    public void negativTest1() throws InterruptedException {

        pause(5000);

        email("billyeexample.com");
        pause(2000);

        password();
        pause(2000);

        signIn();
        pause(2000);

        alertText("Invalid email or password");

    }

    @Test
    public void negativTest2() throws InterruptedException {

        pause(5000);

        password();
        pause(2000);

        signIn();
        pause(2000);

        alertText("Invalid email or password");

    }

    @Test
    public void negativTest3() throws InterruptedException {

        pause(5000);

        email("lucieexample.com");
        pause(5000);

        password();
        pause(5000);

        signIn();
        pause(5000);

        alertText("Invalid email or password");


    }


}
