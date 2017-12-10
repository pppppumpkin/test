import com.sun.deploy.util.StringUtils;
import util.StrUtil;

/**
 * Created by lynn on 2017/12/10.
 */
public class Main {
    public static void main(String[] args) {
        String s1 = "doggggg doggggg";
        long start = System.currentTimeMillis();
        String snew = StrUtil.compress(s1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(snew + ", cost " + time);
    }
}
