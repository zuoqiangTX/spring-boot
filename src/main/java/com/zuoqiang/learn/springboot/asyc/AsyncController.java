package com.zuoqiang.learn.springboot.asyc;

import com.zuoqiang.learn.springboot.model.R;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 异步controller
 * @date 2020/4/29 5:31 下午
 */

@RestController
@RequestMapping("/async")
public class AsyncController {
    final Map<Integer, DeferredResult> deferredResultMap = new ConcurrentReferenceHashMap<Integer, DeferredResult>();

    @GetMapping("/longPolling")
    public DeferredResult longPolling() {
        DeferredResult deferredResult = new DeferredResult(0L);
        deferredResultMap.put(deferredResult.hashCode(), deferredResult);
        deferredResult.onCompletion(() -> {
            deferredResultMap.remove(deferredResult.hashCode());
            System.err.println("还剩" + deferredResultMap.size() + "个deferredResult未响应");
        });
        return deferredResult;
    }

    @GetMapping("/returnLongPollingValue")
    public void returnLongPollingValue() {
        for (Map.Entry<Integer, DeferredResult> entry : deferredResultMap.entrySet()) {
            entry.getValue().setResult("kl");
        }
    }


    @GetMapping("/test")
    public DeferredResult<R> test() {
        //设置10秒超时
        DeferredResult deferredResult = new DeferredResult(1000L, R.fail());
        //模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        deferredResult.setResult(R.ok());
        return deferredResult;
    }
}
