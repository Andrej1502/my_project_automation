package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UpdateStudentForm {

    public UpdateStudentForm() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;

    @FindBy(how = How.ID, id = "email")
    @Getter
    private WebElement clickEmail;

    @FindBy(how = How.XPATH, xpath = "//button[@type='submit']")
    @Getter
    private WebElement submitUpdatingButton;

}
