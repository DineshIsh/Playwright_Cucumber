package HelperFunctions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

import static Utility.BrowserService.page;

public class Helpers {


    // ✅ Click on a locator after waiting for it to be visible
    public void click(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.click();
    }

    // ✅ Fill a text field
    public void fill(Locator locator, String value) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.fill(value);
    }

    // ✅ Clear and fill
    public void clearAndFill(Locator locator, String value) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.fill(""); // clear
        locator.fill(value); // fill new value
    }

    // ✅ Check if an element is visible
    public boolean isVisible(Locator locator) {
        try {
            return locator.isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    // ✅ Get text content from element
    public String getText(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return locator.textContent().trim();
    }

    // ✅ Assert text content
    public void assertText(Locator locator, String expected) {
        String actual = getText(locator);
        if (!actual.equals(expected)) {
            throw new AssertionError("Expected: " + expected + ", but found: " + actual);
        }
    }

    // ✅ Select from dropdown by value
    public void selectByValue(Locator locator, String value) {
        locator.selectOption(value);
    }


    // ✅ Wait for locator to be enabled
    public void waitForEnabled(Locator locator) {
        while (!locator.isEnabled()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

    // ✅ Hover over an element
    public void hover(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.hover();
    }

    // ✅ Check checkbox if not checked
    public void check(Locator locator) {
        if (!locator.isChecked()) {
            locator.check();
        }
    }

    // ✅ Uncheck checkbox if checked
    public void uncheck(Locator locator) {
        if (locator.isChecked()) {
            locator.uncheck();
        }
    }

    public void enter(Locator locator) {
        locator.press("Enter"); // more reliable
    }
}