package selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class FeedBuilder {
    private static final By FEED_TYPES_BAR = By.xpath(".//*[@class='filter filter__nowrap h-mod']");
    private static final By TYPE_ALL = By.xpath(".//*[@class='filter_i' and contains(text(),'Всё')]");
    private static final By TYPE_GROUPS = By.xpath(".//*[@class='filter_i' and contains(text(),'Группы')]");
    private static final By TYPE_FRIENDS = By.xpath(".//*[@class='filter_i' and contains(text(),'Друзья')]");
    private static final By FEEDS = By.xpath(".//*[@class='feed-w']");

    private final SelenideElement feedTypesBar = $(FEED_TYPES_BAR);
    private final SelenideElement feedTypeAll = $(TYPE_ALL);
    private final SelenideElement feedTypeFriends = $(TYPE_FRIENDS);
    private final SelenideElement feedTypeGroups = $(TYPE_GROUPS);

    public enum FeedType{
        ALL,
        RECOMMENDATIONS,
        TRENDING,
        FRIENDS,
        GAMES,
        GROUPS
    }

    private FeedType type = FeedType.ALL;
    private int postsCount = 1;


    public FeedBuilder(){
        feedTypesBar.should();
    }

    public FeedBuilder setPostsCount(int postsCount) {
        this.postsCount = postsCount;
        return this;
    }

    public FeedBuilder setType(FeedType type) {
        this.type = type;
        return this;
    }

    public Feeds buid(){
        switch (type){
            case ALL:
                feedTypeAll.click();
                break;
            case GROUPS:
                feedTypeGroups.click();
                break;
            case FRIENDS:
                feedTypeFriends.click();
                break;
        }
        return new Feeds($$(FEEDS).subList(0, postsCount));
    }
}
