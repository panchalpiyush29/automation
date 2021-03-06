package nz.co.mobile.screen;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class LoginScreen {

    private static final String DISMISS_DIALOG = "button2";
    private static final String WELCOME_TO_SPARK_TOOLBAR = "toolbar";
    private static final String NAME_LOGIN_EMAIL = "auto_username";
    private static final String NAME_LOGIN_PASSWORD = "auto_password";
    private static final String NAME_SIGN_IN_BUTTON = "Login";
    private static final String TO_DO = "TO DO";
    private static final String SET_UP_ACCESS_CARD = "Set Up Access Card";
    private static final String NAME_WORKS = "Works";

    private final AppiumDriver appiumDriver;


    @Autowired
    public LoginScreen(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;

    }


    public void clickForgotPasswordLink() {
        appiumDriver.findElement(By.id("forgot_password_button")).click();
    }

    public void enterEmail(String email) {
        appiumDriver.findElement(By.name(NAME_LOGIN_EMAIL)).sendKeys(email);
    }

    public void enterPassword(String password) {
        appiumDriver.findElement(By.name(NAME_LOGIN_PASSWORD)).sendKeys(password);
    }

    public void clickSignIn() {
        appiumDriver.findElement(By.name(NAME_SIGN_IN_BUTTON)).click();
    }

    public void dismissNotification() throws InterruptedException {
        while (appiumDriver.findElements(By.xpath("//*[@class='android.widget.Button'][2]")).size() > 0) {
            appiumDriver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
        }
    }

    public boolean isDisplayingTheWelcomeToSparkMessage() {
        return appiumDriver.findElement(By.id(WELCOME_TO_SPARK_TOOLBAR)).isDisplayed();
    }


    private void selectCardTile(final String cardDescription) {
        WebElement cardTile = appiumDriver.findElement(By.id("root_card_container")).findElements(By.id("welcome_card")).
                stream().
                filter(card -> card.findElement(By.id("root_card_title")).getText().equalsIgnoreCase(cardDescription)).
                findFirst().
                get();
        cardTile.click();
    }

    public void navigateToTheSetUpCard() {
        selectPostCardTile(SET_UP_ACCESS_CARD);
    }

    private void selectPostCardTile(String cardDescription) {
        WebElement cardTile = appiumDriver.findElement(By.id("card_container")).findElements(By.id("post_card")).
                stream().
                filter(card -> card.findElement(By.id("card_title")).getText().equalsIgnoreCase(cardDescription)).
                findFirst().
                get();
        cardTile.click();
    }

    public boolean loginSuccessMsgIsDisplayed() {
        return appiumDriver.findElement(By.name(NAME_WORKS)).isDisplayed();
    }
}