package selenide;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;

import selenide.layers.CreateGroupLayer;
import selenide.layers.GroupCategoryLayer;
import selenide.pages.*;

import java.util.List;
import java.util.regex.Matcher;

import static com.codeborne.selenide.Selenide.open;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GroupsTests {
    private static final String URL = "https://ok.ru";
    private static MainPage mainPage;
    private GroupsPage groupsPage;
    private GroupCategoryLayer groupCategoryLayer;
    private CreateGroupLayer createGroupLayer;


    @BeforeAll
    public static void setUp() {
        open(URL);
        LoginPage loginPage = new LoginPage();
        mainPage = loginPage.login();
    }

    @Test
    @Order(1)
    public void openGroups() {
        mainPage.clickToGroups();
        groupsPage = new GroupsPage();
    }

//    @Test
//    @Order(2)
//    public void countGroups() {
//        groupsPage = new GroupsPage();
//        groupsPage.clickToOwnGroupButton();
//        Assertions.assertAll(() -> Assertions.assertNotEquals(0, groupsPage.countOwnGroups()),
//                () -> Assertions.assertEquals(1, groupsPage.countOwnGroups()));
//    }

//    @Test
//    @Order(3)
//    public void createInterestsPage() {
//        groupsPage = new GroupsPage();
//        groupCategoryLayer = groupsPage.clickToCreateButton();
//        createGroupLayer = groupCategoryLayer.selectInterestPage();
//        createGroupLayer.crateGroup("lala");
//    }

    @Test
    @Order(4)
    public void groupPostInGroupsFeeds() {
        groupsPage = new GroupsPage();
        groupCategoryLayer = groupsPage.clickToCreateButton();
        createGroupLayer = groupCategoryLayer.selectInterestPage();
        String postText = "Oh, no...";
        createGroupLayer.crateGroup("lala").clickToWritePost(postText);
        open(URL+"/feed");

        Feeds groupPosts = new FeedBuilder()
                .setType(FeedBuilder.FeedType.GROUPS)
                .setPostsCount(2)
                .buid();
        Assertions.assertTrue(groupPosts.isContainsPostWithTest(postText));
    }
    @Test
    @Order(5)
    public void groupPostInFriendFeeds() {
        String postText = "Oh, no...";

        Feeds groupPosts = new FeedBuilder()
                .setType(FeedBuilder.FeedType.FRIENDS)
                .setPostsCount(1)
                .buid();
        Assertions.assertFalse(groupPosts.isContainsPostWithTest(postText));
    }

    @AfterAll
    public static void shutdown() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
