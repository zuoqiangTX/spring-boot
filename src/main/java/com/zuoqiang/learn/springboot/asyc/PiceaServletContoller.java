package com.zuoqiang.learn.springboot.asyc;

import com.zuoqiang.learn.springboot.asyc.service.PiceaService;
import com.zuoqiang.learn.springboot.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author zuoqiang
 * @version 1.0
 * @description todo
 * @date 2020/4/29 7:39 下午
 */

@RestController
@Slf4j
public class PiceaServletContoller {

    @Autowired
    private PiceaService piceaService;

    @RequestMapping("/deferredresult")
    public DeferredResult<R> deferredResult() throws Exception {
        System.out.println("控制层执行线程:" + Thread.currentThread().getName());
//        Long timeout = 10 * 1000L * 10;
        Long timeout = 10 * 1000L; //超时时间
        //超时 10*1000L
        DeferredResult<R> deferredResult = new DeferredResult<R>(timeout);
        deferredResult.onTimeout(new Runnable() {
            @Override
            public void run() {
                log.warn(">>>>>>异步线程执行超时");
                deferredResult.setResult(R.fail("线程执行超时"));
            }
        });
        deferredResult.onCompletion(new Runnable() {
            @Override
            public void run() {
                log.info(">>>>>>异步执行完毕");
            }
        });
        FIXED_THREAD_POOL.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(">>>>>>异步执行线程:" + Thread.currentThread().getName());
                try {
                    String str = piceaService.task2();
                    log.info(">>>>>>线程执行结果为:{}", str);
                    TimeUnit.SECONDS.sleep(1);
                    deferredResult.setResult(R.ok("这是【异步】的请求返回:+ str "));
                } catch (Exception e) {
                    log.error("执行错误", e);
                }
            }
        });
        return deferredResult;
    }

    /**
     * 线程池
     */
    public static ExecutorService FIXED_THREAD_POOL = Executors.newFixedThreadPool(10);
}
