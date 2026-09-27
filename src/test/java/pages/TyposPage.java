package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TyposPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By paragraphs = By.tagName("p");

    public TyposPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/typos");

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(paragraphs, 1)
        );
    }

    public String getParagraphText() {
        List<WebElement> elements = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(paragraphs, 1)
        );

        return elements.get(1).getText();
    }

    public void refresh() {
        driver.navigate().refresh();

        wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(paragraphs, 1)
        );
    }
}