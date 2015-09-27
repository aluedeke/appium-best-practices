package org.testobject.example.komoot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends AbstractTest{

    @Test
    public void loginWithValidCredentialsSucceeds() throws InterruptedException {
        app.welcomeScreen().openEmailLogin();
        app.emailLoginScreen().login("andreas@ludeke.ne", "abcd1234");

        assertThat(app.emailLoginScreen().isLoggedIn(), is(true));
    }
}
