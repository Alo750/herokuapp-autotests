package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownTest extends TestBase {

    @Test
    public void shouldSelectFirstOption() {

        DropdownPage page = new DropdownPage(driver, wait);

        page.open();

        assertTrue(
                page.getOptions().size() >= 3,
                "В выпадающем списке должно быть минимум три пункта"
        );

        page.selectByIndex(1);

        assertTrue(
                page.isOptionSelected(1),
                "Первый доступный вариант должен быть выбран"
        );
    }

    @Test
    public void shouldSelectSecondOption() {

        DropdownPage page = new DropdownPage(driver, wait);

        page.open();

        page.selectByIndex(2);

        assertTrue(
                page.isOptionSelected(2),
                "Второй доступный вариант должен быть выбран"
        );
    }
}