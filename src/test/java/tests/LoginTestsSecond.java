package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;

public class LoginTestsSecond extends AppiumConfig {

    @Test
    public void loginSuccess() {
        new AuthentificationScreen(driver)
                .fillEmail("mikh.panfilovv@gmail.com")
                .fillPassword("Mixan31145$")
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginSuccessModel() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mikh.panfilovv@gmail.com")
                        .password("Mixan31145$").build())
                .submitLogin()
                .isAccountOpened()
                .logout();
    }

    @Test
    public void loginWrongEmail() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mikh.panfilovvgmail.com")
                        .password("Mixan31145$")
                        .build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }
}
