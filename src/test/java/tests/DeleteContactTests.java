package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthentificationScreen;
import screens.ContactListScreen;

public class DeleteContactTests extends AppiumConfig {

    @BeforeClass
    public void preCondition(){
        new AuthentificationScreen(driver)
                .fillLoginRegistrationForm(Auth.builder().email("mikh.panfilovv@gmail.com")
                        .password("Mixan31145$").build())
                .submitLogin();
    }


    @Test
    public void deleteFirstContact(){
        new ContactListScreen(driver)
                .deleteFirstContact()
                .isListSizeLessOnOne();
    }

    @Test
    public void removeAllContactsSuccess() {
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContactsHere();
    }

}
