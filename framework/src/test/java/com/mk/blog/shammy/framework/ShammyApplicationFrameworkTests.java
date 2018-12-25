package com.mk.blog.shammy.framework;

import com.mk.blog.shammy.framework.ShammyApplicationFramework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShammyApplicationFrameworkTests {

    @Test
    public void contextLoads() {
        String[] a = {};
        ShammyApplicationFramework.main(a);
    }

}
