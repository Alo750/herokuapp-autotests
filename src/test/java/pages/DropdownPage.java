package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropdownPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dropdown =
            By.id("dropdown");

    public DropdownPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(dropdown)
        );
    }

    private Select getDropdown() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(dropdown)
        );

        return new Select(element);
    }

    public List<WebElement> getOptions() {
        return getDropdown().getOptions();
    }

    public void selectByIndex(int index) {
        getDropdown().selectByIndex(index);
    }

    public boolean isOptionSelected(int index) {
        return getDropdown()
                .getOptions()
                .get(index)
                .isSelected();
    }
}