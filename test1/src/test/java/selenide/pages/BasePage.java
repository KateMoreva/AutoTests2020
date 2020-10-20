package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assumptions.assumingThat;

public abstract class BasePage {

    public BasePage() {
        check();
    }

    protected abstract void check();

    // May throw TestAbortedException
    protected void click(SelenideElement locator) {
        assumingThat(locator.exists(), locator::click);
    }

    protected void type(SelenideElement locator, String text, String errorMessage) {
        Assertions.assertTrue(locator.exists(), errorMessage);
        locator.clear();
        locator.sendKeys(text);
    }

}
