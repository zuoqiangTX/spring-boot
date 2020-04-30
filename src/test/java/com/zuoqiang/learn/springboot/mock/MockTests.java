package com.zuoqiang.learn.springboot.mock;

import com.zuoqiang.learn.springboot.annotion.Bean3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.Mockito.verify;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/30 2:43 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    private Bean3 bean3;

    private MockMvc mockMvc;

    //在每个测试方法执行之前都初始化MockMvc对象
    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 测试一个不存在的请求/user/1
     *
     * @throws Exception
     */
    @DisplayName("测试根据ID获取user")
    @Test
    public void contextLoads() throws Exception {
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(MockMvcRequestBuilders
                //构造一个get请求
                .get("/user/1")
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期待返回的状态码是4XX，因为我们并没有写/user/{id}的get接口
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getUserById() throws Exception {
        bean3.print();
        //perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        mockMvc.perform(MockMvcRequestBuilders
                //构造一个get请求
                .get("/user/1")
                //请求类型 json
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk());
        //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void mock() {
        //你可以mock一个具体的类型，而不仅是接口
        List mockList = Mockito.mock(List.class);
        mockList.add("one");
        //验证
        verify(mockList).add("one");
    }

    @Test  //对get方法的测试
    public void testGetListTag() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/hello.json")
                        .contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                        .param("name", "shangcg")
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("hello :shangcg", content);
    }

    @Test //对post测试
    public void saveTag() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/save.json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", "shangcg")
                        .param("level", "1")
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals("recive your param name: shangcg level: 1", content);
    }
}
