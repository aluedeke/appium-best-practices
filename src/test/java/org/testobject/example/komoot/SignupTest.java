package org.testobject.example.komoot;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testobject.example.komoot.data.User.userWithRandomMail;

public class SignupTest extends AbstractTest {

    @Test
    public void signupWithValidRandomDataSucceeds() {
        app.welcomeScreen().openEmailSignup();
        app.emailSignupScreen().signup(userWithRandomMail());

        assertThat(app.emailSignupScreen().isSignedUp(), is(true));
    }

}
