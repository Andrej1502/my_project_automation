package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessage {

    public NotificationMessage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.CLASS_NAME, className = "ant-notification-notice-message")
    @Getter
    private WebElement message;
}
