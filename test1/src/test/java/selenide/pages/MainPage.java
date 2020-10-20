package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private static final By LOGO = By.xpath(".//*[@class='toolbar_logo_img']");
    private static final By BUTTON_GROUPS = By.xpath(".//*[@id='hook_Block_SideNavigation']" +
            "//*/a[@data-l='t,userAltGroup']");
    private static final By TOOLBAR = By.xpath(".//*[@data-l='t,navigationToolbar']");

    private final SelenideElement logo = $(LOGO);
    private final SelenideElement groupsButton = $(BUTTON_GROUPS);
    private final SelenideElement toolbar = $(TOOLBAR);

    public void clickToGroups() {
        click(groupsButton);
    }

    @Override
    protected void check() {
        $(LOGO).shouldBe(Condition.visible);
        $(BUTTON_GROUPS).shouldBe(Condition.visible);
        $(TOOLBAR).shouldBe(Condition.visible);
    }
}
