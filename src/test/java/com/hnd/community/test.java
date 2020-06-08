package com.hnd.community;

import com.hnd.community.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class test {
    @Autowired
    UserService service;

    @Test
    void contextLoads() throws Exception {


    }
}
