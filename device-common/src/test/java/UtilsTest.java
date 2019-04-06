import com.lhf.deviceMS.common.utils.LocalInfoUtils;
import org.junit.Test;

import java.net.UnknownHostException;

public class UtilsTest {

    @Test
    public void test1() throws UnknownHostException {
        String ip = LocalInfoUtils.ipv4();
        String hostName = LocalInfoUtils.hostName();
        System.out.println(ip);
        System.out.println(hostName);
    }
}
