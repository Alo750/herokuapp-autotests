package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;
import pages.AddRemovePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddRemoveTest extends TestBase {

    @Test
    public void shouldAddTwoElements() {

        AddRemovePage page = new AddRemovePage(driver, wait);

        page.open();

        page.addElement();
        page.addElement();

        page.waitForDeleteButtonsCount(2);

        assertEquals(
                2,
                page.getDeleteButtonsCount(),
                "После добавления двух элементов должно быть две кнопки Delete"
        );
    }

    @Test
    public void shouldDeleteOneElement() {

        AddRemovePage page = new AddRemovePage(driver, wait);

        page.open();

        page.addElement();
        page.addElement();

        page.waitForDeleteButtonsCount(2);

        page.deleteFirstElement();

        page.waitForDeleteButtonsCount(1);

        assertEquals(
                1,
                page.getDeleteButtonsCount(),
                "После удаления одного элемента должна остаться одна кнопка Delete"
        );
    }
}