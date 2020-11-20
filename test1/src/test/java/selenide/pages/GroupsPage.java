package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.layers.GroupCategoryLayer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GroupsPage extends BasePage {

    private static final By LOGO = By.xpath(".//*[@class='toolbar_logo_img']");
    private static final By BUTTON_CREATE_GROUP = By.xpath(".//*[@class='button-pro __wide __light __ic']");
    private static final By SEARCH_FIELD = By.xpath(".//input[@name='st.query']");
    private static final By OWN_GROUP_BUTTON = By.xpath(".//*[@class='ml']");
    private static final By ALL_OWN_GROUPS = By.xpath(".//*[@data-l='groupCard,null']");

    private final SelenideElement createGroupButton = $(BUTTON_CREATE_GROUP);
    private final SelenideElement searchField = $(SEARCH_FIELD);
    private final SelenideElement ownGroupButton = $(OWN_GROUP_BUTTON);
    private final ElementsCollection allGroups = $$(ALL_OWN_GROUPS);

    public GroupCategoryLayer clickToCreateButton() {
        click(createGroupButton);
        return new GroupCategoryLayer();
    }

    public void clickToOwnGroupButton() {
        click(ownGroupButton);
    }

    public void clickSearchGroup(String nameOfNecessaryGroup) {
        type(searchField, nameOfNecessaryGroup, "No search field");
    }

    public int countOwnGroups() {
//        allGroups.shouldHaveSize(1);
        return allGroups.size();
    }

    @Override
    protected void check() {
        $(LOGO).shouldBe(Condition.visible);
        $(BUTTON_CREATE_GROUP).shouldBe(Condition.visible);
        $(SEARCH_FIELD).shouldBe(Condition.exist);
    }
}
