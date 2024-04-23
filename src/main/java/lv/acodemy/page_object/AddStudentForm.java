package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddStudentForm {

    public AddStudentForm() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.ID, id = "name")
    @Getter
    private WebElement nameField;

    @FindBy(how = How.ID, id = "email")
    @Getter
    private WebElement emailField;

    @FindBy(how = How.ID, id = "gender")
    @Getter
    private WebElement genderField;

    @FindBy(how = How.XPATH, xpath = "//div[@title='MALE']")
    @Getter
    private WebElement male;

    @FindBy(how = How.XPATH, xpath = "//div[@title='FEMALE']")
    @Getter
    private WebElement female;

    @FindBy(how = How.XPATH, xpath = "//div[@title='OTHER']")
    @Getter
    private WebElement other;

    @FindBy(how = How.XPATH, xpath = "//button[@type='submit']")
    @Getter
    private WebElement addStudentSubmitButton;

    public void selectGender (String userGender) {
        if (userGender.equals("MALE")) {
            getMale().click();
        } else if (userGender.equals("FEMALE")) {
            getFemale().click();
        } else if (userGender.equals("OTHER")) {
            getOther().click();
        }
    }

    public void registration (String username, String userEmail, String userGender) {
        getNameField().sendKeys(username);
        getEmailField().sendKeys(userEmail);
        getGenderField().click();
        selectGender(userGender);
        getAddStudentSubmitButton().click();
    }
}
