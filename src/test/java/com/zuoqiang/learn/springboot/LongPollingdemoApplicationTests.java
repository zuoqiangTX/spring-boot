package com.zuoqiang.learn.springboot;

import com.zuoqiang.learn.springboot.asyc.AsyncFeginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 6:34 下午
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class LongPollingdemoApplicationTests {
    @Autowired
    AsyncFeginService asyncFeginService;

    /**
     * 模拟多个浏览器客户端发起长轮询请求，等待testLongPolling测试用例请求通知服务端返回各浏览器的请求结果
     *
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i <= 3; i++) {
            executorService.execute(() -> {
                String kl = asyncFeginService.longPolling();
                System.err.println("收到响应：" + kl);
            });
        }
        System.in.read();
    }

    /**
     * 通知服务端返回上个测试的长轮询结果
     */
    @Test
    public void testLongPolling() {
        asyncFeginService.returnLongPollingValue();
    }
}