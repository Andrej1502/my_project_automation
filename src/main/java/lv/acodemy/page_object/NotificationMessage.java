package lv.acodemy.page_object;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessage {

    ChromeDriver driver;

    public NotificationMessage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, className = "ant-notification-notice-message")
    @Getter
    private WebElement message;
}
