package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By input =
            By.tagName("input");

    public InputsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(input)
        );
    }

    public WebElement getInput() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(input)
        );
    }

    public void enterText(String text) {
        WebElement element = getInput();
        element.clear();
        element.sendKeys(text);
    }

    public void pressArrowUp() {
        getInput().sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        getInput().sendKeys(Keys.ARROW_DOWN);
    }

    public String getValue() {
        return getInput().getAttribute("value");
    }
}