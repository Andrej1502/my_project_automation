import lombok.extern.java.Log;
import lv.acodemy.page_object.AddStudentForm;
import lv.acodemy.page_object.MainPage;
import lv.acodemy.page_object.NotificationMessage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import static lv.acodemy.utils.DriverManager.getDriver;

@Log
public class MyTest {

    MainPage mainPage;
    AddStudentForm addStudentForm;
    NotificationMessage notificationMessage;

    @BeforeMethod
    public void beforeTest() {
        getDriver().get(" http://acodemy-app-springboot-env.eba-pagku2yg.eu-north-1.elasticbeanstalk.com/");
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage();
        addStudentForm = new AddStudentForm();
        notificationMessage = new NotificationMessage();
    }
    @Test
    public void addStudentTest() {
        mainPage.getAddStudentButton().click();
        log.info("New student registration");
        addStudentForm.registration("Kano", "Kano@inbox.lv", "OTHER");
        Assertions.assertThat(notificationMessage.getMessage().isEnabled()).isTrue();
    }
}

