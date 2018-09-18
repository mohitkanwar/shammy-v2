package com.mk.blog.shammy.framework.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StatusResponseTest {


    @Test
    public void toStringTest() {
        StatusResponse statusResponse = StatusResponse.SUCCESS;
        Assert.assertEquals("{status='success'}",statusResponse.toString());
    }
}