package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthentificationScreen extends BaseScreen {
    public AuthentificationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(emailEditText));
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    AndroidElement emailEditText;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    AndroidElement passwordEditText;

    @FindBy(xpath = "//*[@text='LOGIN']")
    AndroidElement loginBtn;

    public AuthentificationScreen fillEmail(String email) {
        type(emailEditText, email);
        return this;
    }

    public AuthentificationScreen fillPassword(String password) {
        type(passwordEditText, password);
        return this;
    }

    public ContactListScreen submitLogin() {
        loginBtn.click();
        return new ContactListScreen(driver);
    }



}
