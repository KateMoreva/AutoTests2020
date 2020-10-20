package selenide.layers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.pages.BasePage;
import selenide.pages.GroupPage;

import static com.codeborne.selenide.Selenide.$;

public class CreateGroupLayer extends BasePage {

    private static final By NAME_FIELD = By.xpath(".//input[@name='st.layer.name']");
    private static final By CREATE_BUTTON = By.xpath(".//input[@name='button_create']");

    private final SelenideElement groupNameField = $(NAME_FIELD);
    private final SelenideElement createGroupButton = $(CREATE_BUTTON);

    public GroupPage crateGroup(String name) {
        click(groupNameField);
        groupNameField.sendKeys(name);
//        type(groupNameField, name, "No field");
        click(createGroupButton);
        return new GroupPage();
    }

    @Override
    protected void check() {

    }
}
