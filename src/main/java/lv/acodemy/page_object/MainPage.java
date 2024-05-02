package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class MainPage {

    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.ID, id = "addStudentButton")
    @Getter
    private WebElement addStudentButton;

    @FindBy(how = How.CLASS_NAME, className = "//tr[@data-row-key]//td[@class='ant-table-cell'][2]")
    @Getter
    List<WebElement> allNames;

    private final By editInformationButton = By.xpath("//tr[@data-row-key]//span[text()='Edit']");

    @FindBy(how = How.XPATH, xpath = "//li[@tabindex='0']")
    @Getter
    List<WebElement> pagination;

    public void findStudentByNameAndUpdate(String editName) {

        for (int i = 0; i < pagination.size(); i++) {
            for (int j = 0; j < allNames.size(); j++) {
                if (allNames.get(j).getText().contains(editName)) {
                    allNames.get(j).findElement(editInformationButton).click();
                    break;
                }
                }
            getPagination().get(i).click();
            }
        }
    }

