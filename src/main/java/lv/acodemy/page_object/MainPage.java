package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class MainPage {

    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.ID, id = "addStudentButton")
    @Getter
    private WebElement addStudentButton;
}
