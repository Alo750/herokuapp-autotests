package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.InputsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InputsTest extends TestBase {

    @Test
    public void shouldHandleNumericAndNonNumericInput() {

        InputsPage page = new InputsPage(driver, wait);

        page.open();

        page.enterText("10");

        assertEquals(
                "10",
                page.getValue(),
                "Числовое значение должно вводиться"
        );

        page.pressArrowUp();

        assertEquals(
                "11",
                page.getValue(),
                "Arrow Up должен увеличить значение"
        );

        page.pressArrowDown();

        assertEquals(
                "10",
                page.getValue(),
                "Arrow Down должен уменьшить значение"
        );

        page.enterText("abc");

        assertNotEquals(
                "abc",
                page.getValue(),
                "Нечисловое значение не должно восприниматься как число"
        );
    }
}