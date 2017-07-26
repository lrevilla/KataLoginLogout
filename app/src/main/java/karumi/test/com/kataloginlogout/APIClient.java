package karumi.test.com.kataloginlogout;

/**
 * Created by LRevilla on 26/07/17.
 */

public class APIClient {


    private static final String VALID_EMAIL_STRING = "pedro@karumi.com";
    private static final String VALID_PASSWORD_STRING = "aaaaa";

    private static Clock clock;

    public APIClient(Clock clock) {
        this.clock = clock;
    }

    public boolean login(String email, String password) {
        return email.trim().equals(VALID_EMAIL_STRING) &&
               password.trim().equals(VALID_PASSWORD_STRING);
    }

    public boolean logout() {
        return this.clock.getCurrentTime() % 2 == 0;
    }
}
