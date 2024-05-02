import lombok.extern.java.Log;
import lv.acodemy.page_object.*;
import lv.acodemy.utils.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static lv.acodemy.utils.ConfigurationProperties.getConfiguration;
import static lv.acodemy.utils.DriverManager.getDriver;

@Log
public class MyTest {

    MainPage mainPage;
    AddStudentForm addStudentForm;
    NotificationMessage notificationMessage;
    UpdateStudentForm updateStudentForm;

    @BeforeMethod
    public void beforeTest() {
        getDriver().get(getConfiguration().getString(Constants.TEST_PAGE));
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage();
        addStudentForm = new AddStudentForm();
        notificationMessage = new NotificationMessage();
        updateStudentForm = new UpdateStudentForm();
    }
    @Test
    public void addStudentTest() {
        mainPage.getAddStudentButton().click();
        log.info("New student registration");
        addStudentForm.registration(
                getConfiguration().getString("testPage.userName"),
                getConfiguration().getString("testPage.userEmail"),
                getConfiguration().getString("testPage.userGender"));
        Assertions.assertThat(notificationMessage.getMessage().isEnabled()).isTrue();
    }
    @Test
    public void updateInformation() {
        mainPage.findStudentByNameAndUpdate("Rostik");
    }
}

