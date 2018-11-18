package com.mk.blog.shammy.framework.user.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultAuthorityTest {
    @Test
    public void testEquals() {
        DefaultAuthority authority1 = new DefaultAuthority();
        authority1.setId(1);
        authority1.setDescription("description");
        authority1.setAuthority("AUTH");

        DefaultAuthority authority2 = new DefaultAuthority();
        authority2.setId(1);
        authority2.setDescription("description");
        authority2.setAuthority("AUTH");

        assertEquals(authority1, authority2);
        assertEquals(authority1.hashCode(), authority2.hashCode());
    }

}