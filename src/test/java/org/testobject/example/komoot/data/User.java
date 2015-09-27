package org.testobject.example.komoot.data;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by aluedeke on 27.09.15.
 */
public class User {

    public static final User VALID_CREDENTIALS = new User("super hero", "andreas@ludeke.net", "abcd1234");

    public final String displayName;
    public final String email;
    public final String password;

    private User(String displayName, String email, String password){
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }

    public static User userWithRandomMail(){
        return new User("Test User", "andreas+" + ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE) + "@ludeke.net", "abcd1234");
    }
}
