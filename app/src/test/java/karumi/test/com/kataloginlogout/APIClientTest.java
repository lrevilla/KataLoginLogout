package karumi.test.com.kataloginlogout;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class APIClientTest {

    private MockClock mockClock = new MockClock(2000);

    @Test
    public void shouldLoginWhenCredentialsAreValid() {
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.login("pedro@karumi.com", "aaaaa");

        assertTrue(loginResponse);
    }

    @Test
    public void shouldNotLoginWhenEmailIsNotValid() {
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.login("lrevilla@solidgear.es", "aaaaa");

        assertFalse(loginResponse);
    }

    @Test
    public void shouldNotLoginWhenPasswordIsNotValid() {
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.login("pedro@karumi.com", "asdjassd");

        assertFalse(loginResponse);
    }

    @Test
    public void shouldNotLoginWhenBothCredentialsAreNotValid() {
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.login("lrevilla@solidgear.es", "asdjassd");

        assertFalse(loginResponse);
    }

    @Test
    public void shouldLogOutOnPairSeconds() {
        MockClock mockClock = new MockClock(2000);
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.logout();

        assertTrue(loginResponse);
    }

    @Test
    public void shouldLoginOnEvenSeconds() {
        MockClock mockClock = new MockClock(3001);
        APIClient apiClient = new APIClient(mockClock);

        boolean loginResponse = apiClient.logout();

        assertFalse(loginResponse);
    }
}