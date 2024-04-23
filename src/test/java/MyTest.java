import lv.acodemy.page_object.AddStudentForm;
import lv.acodemy.page_object.MainPage;
import lv.acodemy.page_object.NotificationMessage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;



public class MyTest {

    ChromeDriver driver;
    MainPage mainPage;
    AddStudentForm addStudentForm;
    NotificationMessage notificationMessage;


    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.get(" http://acodemy-app-springboot-env.eba-pagku2yg.eu-north-1.elasticbeanstalk.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        mainPage = new MainPage(driver);
        addStudentForm = new AddStudentForm(driver);
        notificationMessage = new NotificationMessage(driver);
    }
    @Test
    public void addStudentTest() {

        mainPage.getAddStudentButton().click();

        addStudentForm.registration("Kano", "Kano@inbox.lv", "OTHER");
        Assertions.assertThat(notificationMessage.getMessage().isEnabled()).isTrue();
    }
}

