package org.testobject.example.komoot;

import org.junit.Test;
import org.testobject.example.komoot.data.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends AbstractTest{

    @Test
    public void loginWithValidCredentialsSucceeds() {
        app.welcomeScreen().openEmailLogin();
        app.emailLoginScreen().login(User.VALID_CREDENTIALS);

        assertThat(app.emailLoginScreen().isLoggedIn(), is(true));
    }

}
