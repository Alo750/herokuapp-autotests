package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.TyposPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TyposTest extends TestBase {

    @Test
    public void shouldCheckTyposPage() {

        TyposPage page = new TyposPage(driver, wait);

        page.open();

        String expectedText =
                "Sometimes you'll see a typo, other times you won't.";

        String actualText = page.getParagraphText();

        int attempts = 1;

        while (!actualText.equals(expectedText) && attempts < 10) {

            page.refresh();

            actualText = page.getParagraphText();

            attempts++;
        }

        assertEquals(
                expectedText,
                actualText,
                "Текст должен соответствовать правильному написанию"
        );
    }
}