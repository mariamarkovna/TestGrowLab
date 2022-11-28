import org.testng.annotations.Test;

public class TestsAllUserAuthorization extends TestBase {


    @Test
    public void positiveManagerTest() {

        login();

        email("billye@example.com");
        pause(5000);

        password();
        pause(5000);

        signIn();
        pause(5000);

        acceptText("Welcome to your Client Portal");

        acceptText("CLIENTS");
        acceptText("TEAM");
        acceptText("INVOICES");
        acceptText("PROJECT OVERVIEW");



        logOut();
        pause(5000);

        acceptText("GrowLab is a creative growth agency");

    }

    @Test
    public void positiveClientTest() {

        login();

        pause(5000);

        email("lucie@example.com");
        pause(5000);

        password();
        pause(5000);

        signIn();
        pause(5000);

        acceptText("Welcome to your Client Portal");

        acceptNoText("CLIENTS");
        acceptNoText("TEAM");
        acceptText("INVOICES");
        acceptText("PROJECTS OVERVIEW");

        logOut();
    }

    @Test
    public void positiveConsultantTest() {

        login();

        email("edra@example.com");
        pause(5000);

        password();
        pause(5000);

        signIn();
        pause(5000);

        acceptText("Welcome to your Client Portal");

        acceptText("CLIENTS");
        acceptText("TEAM");
        acceptText("INVOICES");
        acceptText("PROJECT OVERVIEW");

        logOut();
    }
}
