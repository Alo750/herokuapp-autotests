package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckboxesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By checkboxes =
            By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxes)
        );
    }

    private List<WebElement> getCheckboxes() {
        return wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxes)
        );
    }

    public boolean isChecked(int index) {
        return getCheckboxes().get(index).isSelected();
    }

    public void clickCheckbox(int index) {
        getCheckboxes().get(index).click();
    }
}