package selenide.layers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

public class GroupCategoryLayer extends BasePage {
    private static final By ALL_CATEGORIES = By.xpath(".//a[@class='create-group-dialog-v2_i']");
    private static final By PUBLIC_PAGE = By.xpath(".//*[@data-l='t,PAGE']");
    private static final By INTEREST_PAGE = By.xpath(".//*[@data-l='t,INTEREST']");
    private static final By EVENT = By.xpath(".//*[@data-l='t,HAPPENING']");

    private final SelenideElement publicPage = $(PUBLIC_PAGE);
    private final SelenideElement interestPage = $(INTEREST_PAGE);
    private final SelenideElement eventPage = $(EVENT);

    public CreateGroupLayer selectPublicPage() {
        click(publicPage);
        return new CreateGroupLayer();
    }

    public CreateGroupLayer selectInterestPage() {
        click(interestPage);
        return new CreateGroupLayer();
    }

    public CreateGroupLayer selectEvent() {
        click(eventPage);
        return new CreateGroupLayer();
    }

    @Override
    protected void check() {
//        $(ALL_CATEGORIES).shouldBe(Condition.visible);
        $(PUBLIC_PAGE).shouldBe(Condition.exist);
        $(INTEREST_PAGE).shouldBe(Condition.exist);
        $(EVENT).shouldBe(Condition.exist);
    }

}
