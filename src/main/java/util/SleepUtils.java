package util;

import java.util.concurrent.TimeUnit;

/**
 * Created by liying.song on 2017/3/21.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
