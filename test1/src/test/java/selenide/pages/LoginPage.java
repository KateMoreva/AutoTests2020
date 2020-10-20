package selenide.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private static final String BUTTON = ".//input[@data-l='t,sign_in']";
    private static final String EMAIL_XPATH = ".//input[@name='st.email']";
    private static final String PASSWORD_FIELD_XPATH = ".//input[@name='st.password']";

    public static String loginOfSecondBot = "technopolisBot232";
    public static String passwordOfSecondBot = "technopolis21";

    private final SelenideElement login = $(By.xpath(EMAIL_XPATH));
    private final SelenideElement pass = $(By.xpath(PASSWORD_FIELD_XPATH));
    private final SelenideElement loginButton = $(By.xpath(BUTTON));

    public MainPage login() {
        enterEmailAndPassword();
        click(loginButton);
        return new MainPage();
    }

    public void enterEmailAndPassword() {
        type(login, loginOfSecondBot, "No email field");
        type(pass, passwordOfSecondBot, "No password field");
    }

    @Override
    protected void check() {
        $(By.xpath(BUTTON)).shouldBe(Condition.visible);
    }
}
