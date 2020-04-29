package com.zuoqiang.learn.springboot.asyc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 5:34 下午
 */

@FeignClient(url = "127.0.0.1:8084", name = "async")
public interface AsyncFeginService {

    @GetMapping("/async/longPolling")
    String longPolling();

    @GetMapping("/async/returnLongPollingValue")
    void returnLongPollingValue();
}
