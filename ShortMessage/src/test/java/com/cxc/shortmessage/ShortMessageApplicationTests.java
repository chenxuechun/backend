package com.cxc.shortmessage;

import com.cxc.controller.TencentSmsController;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShortMessageApplicationTests.class)
@WebAppConfiguration
public class ShortMessageApplicationTests {

    private MockMvc mvc;

    private MockHttpSession session;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void init(){
        System.err.println("before");
    }

    @Test
    public void testFun(){
        System.out.println("test");
    }

//    @Before
//    public void init() throws Exception{
//        System.out.println("Before");
//        mvc = MockMvcBuilders.standaloneSetup(new TencentSmsController()).build();
//        session = new MockHttpSession();
//        Random random = new Random(100);
//        System.out.println(random);
//        session.setAttribute("random",random);
//    }
//
//    @Test
//    public void testSay() throws Exception {
//        String json="{}";
//        mvc.perform(MockMvcRequestBuilders.get("/saytencent")
//            .accept(MediaType.APPLICATION_JSON)
//            .content(json.getBytes())
//            .session(session)
//        )
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andDo(MockMvcResultHandlers.print());
//    }

}
