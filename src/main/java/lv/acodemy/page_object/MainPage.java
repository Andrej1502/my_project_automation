package lv.acodemy.page_object;

import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    ChromeDriver driver;

    public MainPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, id = "addStudentButton")
    @Getter
    private WebElement addStudentButton;

}



