package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddRemovePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By addElementButton =
            By.xpath("//button[text()='Add Element']");

    private final By deleteButton =
            By.xpath("//button[text()='Delete']");

    public AddRemovePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.elementToBeClickable(addElementButton));
    }

    public void addElement() {
        wait.until(ExpectedConditions.elementToBeClickable(addElementButton))
                .click();
    }

    public int getDeleteButtonsCount() {
        return driver.findElements(deleteButton).size();
    }

    public void waitForDeleteButtonsCount(int expectedCount) {
        wait.until(driver ->
                driver.findElements(deleteButton).size() == expectedCount
        );
    }

    public void deleteFirstElement() {
        WebElement firstDeleteButton = wait.until(driver -> {
            List<WebElement> elements = driver.findElements(deleteButton);

            if (elements.isEmpty()) {
                return null;
            }

            return elements.get(0);
        });

        firstDeleteButton.click();
    }
}