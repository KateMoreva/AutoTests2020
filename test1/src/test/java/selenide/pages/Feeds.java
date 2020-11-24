package selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class Feeds {
    private List<SelenideElement> feeds = new ArrayList<>();

    public Feeds(List<SelenideElement> feeds){
        this.feeds = feeds;
    }

    public boolean isContainsPostWithTest(final String text){
        return feeds.stream().anyMatch(feed -> isContainText(feed, text));
    }

    private boolean isContainText(SelenideElement post, String text){
        return post.getText().contains(text);
    }
}
