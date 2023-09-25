package cn.yiplatform;

import cn.yiplatform.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderApplicationTests {

    @Test
    void contextLoads() {
        String test = MD5Util.md5("test");
    }

}
