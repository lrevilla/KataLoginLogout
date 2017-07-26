package karumi.test.com.kataloginlogout;

import java.util.Date;

/**
 * Created by LRevilla on 26/07/17.
 */

public class MockClock extends Clock {

    private long time;

    public MockClock(long time) {
        this.time = time;
    }

    @Override
    public long getCurrentTime() {
        return time;
    }
}
