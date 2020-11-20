package selenide.pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class GroupPage extends BasePage {
    private static final By LOGO = By.className("toolbar_logo_img");
    private static final By NAME_OF_GROUP = By.xpath(".//h1[@class='mctc_name_tx']");
    private static final By INFORM_CARD = By.xpath(".//*[@id='hook_Block_LeftColumnTopCard']");
    private static final By BUTTON_OF_DROPDOWN_MENU = By.xpath(".//span[@class='u-menu_a toggle-dropdown']");
    private static final By BUTTON_DELETE_GROUP = By.xpath(".//a[contains(@hrefattrs,'CardButtonsRemoveAltGroup')]");
    private static final By BUTTON_INVITE = By.xpath(".//a[contains(@hrefattrs,'AltGroupTopCardButtonsInviteFriends')]");
    private static final By WRITE_POST =By.xpath(".//*[@class='pf-head_itx_a']");
    private static final By POST = By.xpath(".//*[@class='group-feed']");
    private static final By POST_BUTTON = By.xpath(".//*[@class='posting_submit button-pro']");

    private static final By POST_AREA = By.xpath(".//*[@class='posting-form_itx_w js-color-picker-block-w __empty emoji-m __size-1']");

    private final SelenideElement logo = $(LOGO);
    private final SelenideElement name = $(NAME_OF_GROUP);
    private final SelenideElement inform_card = $(INFORM_CARD);
    private final SelenideElement button_drop_down_menu = $(BUTTON_OF_DROPDOWN_MENU);
    private final SelenideElement button_delete_group = $(BUTTON_DELETE_GROUP);
    private final SelenideElement button_invite = $(BUTTON_INVITE);
    private final SelenideElement write_post = $(WRITE_POST);
    private final SelenideElement post = $(POST);
    private final SelenideElement post_button = $(POST_BUTTON);
    private final SelenideElement post_area = $(POST_AREA);


    public boolean checkGroupName(String expectedName){
        return expectedName.equals(name.getText());
    }


//    public void deleteGroup(){
//        click(BUTTON_OF_DROPDOWN_MENU, "Пропала кнопка выпадающего меню");
//        Assert.assertTrue("Не прогрузилась кнопка Удалить",
//                explicitWait(ExpectedConditions.visibilityOfElementLocated(BUTTON_DELETE_GROUP),
//                        5,500));
//        click(BUTTON_DELETE_GROUP, "Пропала кнопка Удалить");
//        new ConfirmDeletingGroupLayer(driver);
//    }
//
    public void clickToWritePost() {
        sleep(2000);
        click(write_post);
        sleep(2000);
        click(post_area);
        type(post_area, "AAAAA", "No field");
        click(post_button);
    }

//
//    private List<PostWrapper> findAllPosts(){
//        if (isElementPresent(POST)){
//            return PostTransformer.wrap(driver.findElements(POST));
//        }
//        return Collections.emptyList();
//    }
//
//    public selenium.core.pages.GroupPage chooseNeededPost(String expectedName){
//        List<PostWrapper> posts = findAllPosts();
//        for (PostWrapper post: posts){
//            if (post.equals(expectedName)){
//                post.likePost();
//                return new selenium.core.pages.GroupPage(driver);
//            }
//        }
//        return  null;
//    }

    @Override
    protected void check() {
        $(LOGO).shouldBe(Condition.visible);
    }
}
