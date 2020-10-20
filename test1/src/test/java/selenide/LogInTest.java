package selenide;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import selenide.pages.LoginPage;
import selenide.pages.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LogInTest {

    private static final String URL = "https://ok.ru";
    private static final String SIGN_IN_XPATH = ".//input[@data-l='t,sign_in']";
    private static final String EMAIL_XPATH = ".//input[@name='st.email']";
    private static final String PASSWORD_FIELD_XPATH = ".//input[@name='st.password']";

    private LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        open(URL);
    }

    @Test
    @Order(1)
    @Disabled
    public void openMainPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue($(By.xpath(SIGN_IN_XPATH)).exists()),
                () -> Assertions.assertTrue($(By.xpath(EMAIL_XPATH)).exists()),
                () -> Assertions.assertTrue($(By.xpath(PASSWORD_FIELD_XPATH)).exists())
        );
    }

    @Test
    public void login() {
        loginPage = new LoginPage();
        MainPage mainPage = loginPage.login();
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
