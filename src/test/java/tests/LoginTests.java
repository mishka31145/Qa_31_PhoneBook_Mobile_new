package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfig {


    @Test
    public void loginSuccess(){
//     boolean result = new SplashScreen(driver)
//               .checkCurrentVersion("Version 1.0.0")
        boolean result = new AuthentificationScreen(driver)
                .fillEmail("mikh.panfilovv@gmail.com")
               .fillPassword("Mixan31145$")
               .submitLogin()
               .isActivityTitleDisplayed("Contact list");

        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel() {
//        boolean result = new SplashScreen(driver)
//                .checkCurrentVersion("Version 1.0.0")
            boolean result = new AuthentificationScreen(driver).
                    fillLoginRegistrationForm(Auth.builder()
                            .email("mikh.panfilovv@gmail.com").
                            password("Mixan31145$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list");

        Assert.assertTrue(result);
    }

    @Test
    public void loginSuccessModel2() {
        Assert.assertTrue(new AuthentificationScreen(driver).
                fillLoginRegistrationForm(Auth.builder()
                        .email("mikh.panfilovv@gmail.com").
                        password("Mixan31145$").build())
                .submitLogin()
                .isActivityTitleDisplayed("Contact list"));

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

    @Test
    public void loginWrongPassword() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mikh.panfilovv@gmail.com")
                        .password("Mixan31")
                        .build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }

    @Test
    public void loginUnregisteredUser() {
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder()
                        .email("mikh.panfilovv@gmail31145.com")
                        .password("Mixan31145$")
                        .build())
                .submitLoginNegative()
                .isErrorMessageHasText("Login or Password incorrect");
    }


    @AfterMethod
    public void postCondition() {
    new ContactListScreen(driver).logout();
    }

}
