import org.testng.annotations.Test;

    public class TestGrowLab23 extends TestBase {



        @Test
        public void negativTest1() throws InterruptedException {

            Thread.sleep(5000);

            email("billyeexample.com");
            Thread.sleep(2000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(2000);

           alertText();

        }

        @Test
        public void negativTest2() throws InterruptedException {

            Thread.sleep(5000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(2000);

            alertText();

        }
        @Test
        public void negativTest3() throws InterruptedException {

            Thread.sleep(5000);

            email("lucie@example.com");
            Thread.sleep(2000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(2000);

            alertText();


        }

        @Test
        public void positiveManagerTest() throws InterruptedException {

            Thread.sleep(5000);

            email("billye@example.com");
            Thread.sleep(2000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(7000);

            acceptText("Welcome to your Client Portal");

        }

        @Test
        public void positiveClientTest() throws InterruptedException {

            Thread.sleep(5000);

            email("lucie@example.com");
            Thread.sleep(2000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(7000);

            acceptText("Welcome to your Client Portal");

        }

        @Test
        public void positiveConsultantTest() throws InterruptedException {

            Thread.sleep(5000);

            email("lucie@example.com");
            Thread.sleep(2000);

            password();
            Thread.sleep(2000);

            signIn();
            Thread.sleep(7000);

            acceptText("Welcome to your Client Portal");

            logOut();
            //Boolean.FALSE

        }



}
