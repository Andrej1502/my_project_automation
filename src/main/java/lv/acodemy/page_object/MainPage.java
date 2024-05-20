package lv.acodemy.page_object;

import lombok.Getter;
import lv.acodemy.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPage {

    public MainPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    @FindBy(how = How.ID, id = "addStudentButton")
    @Getter
    private WebElement addStudentButton;

    @FindBy(how = How.XPATH, xpath = "//tbody[@class='ant-table-tbody']//tr[@data-row-key]//td[@class='ant-table-cell']")
    @Getter
    List<WebElement> allNames;

    private final By editInformationButton = By.xpath(".//parent::tr//span[text()='Edit']//parent::label");

    @FindBy(how = How.XPATH, xpath = "//li[@title='Next Page']")
    @Getter
    private WebElement pagination;

    private void waitForPageLoad() {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(7)).until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody[@class='ant-table-tbody']//tr[@data-row-key]//td[@class='ant-table-cell']")));
    }

    public void findStudentByNameAndUpdate(String editName) {

        for (int i = 0; i <= 53; i++) {
            boolean found = false;

            for (WebElement allName : allNames) {
                if (allName.getText().contains(editName)) {
                    allName.findElement(editInformationButton).click();
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            } else {
                getPagination().click();
            }
        }
    }
}

