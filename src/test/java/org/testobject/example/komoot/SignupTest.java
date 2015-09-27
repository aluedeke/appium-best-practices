package org.testobject.example.komoot;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SignupTest extends AbstractTest {

    @Test
    public void signupWithValidRandomDataSucceeds() throws InterruptedException {
        app.welcomeScreen().openEmailSignup();
        app.emailSignupScreen().signup("Test User", "andreas+" + ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE) + "@ludeke.net", "abcd1234");

        assertThat(app.emailSignupScreen().isSignedUp(), is(true));
    }
}
