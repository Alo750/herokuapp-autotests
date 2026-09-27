package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.CheckboxesPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxesTest extends TestBase {

    @Test
    public void shouldCheckFirstCheckbox() {

        CheckboxesPage page = new CheckboxesPage(driver, wait);

        page.open();

        assertFalse(
                page.isChecked(0),
                "Первый чекбокс изначально должен быть unchecked"
        );

        page.clickCheckbox(0);

        assertTrue(
                page.isChecked(0),
                "После нажатия первый чекбокс должен быть checked"
        );
    }

    @Test
    public void shouldUncheckSecondCheckbox() {

        CheckboxesPage page = new CheckboxesPage(driver, wait);

        page.open();

        assertTrue(
                page.isChecked(1),
                "Второй чекбокс изначально должен быть checked"
        );

        page.clickCheckbox(1);

        assertFalse(
                page.isChecked(1),
                "После нажатия второй чекбокс должен быть unchecked"
        );
    }
}