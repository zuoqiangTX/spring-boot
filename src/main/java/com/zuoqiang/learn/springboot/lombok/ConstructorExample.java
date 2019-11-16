package com.zuoqiang.learn.springboot.lombok;

import lombok.*;

@RequiredArgsConstructor(staticName = "of")  // 会生成一个包含常量，和标识了NotNull的变量 的构造方法
@AllArgsConstructor(access = AccessLevel.PROTECTED)  //生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验
public class ConstructorExample<T> {
    private int x, y;
    @NonNull
    private T description;

    @NoArgsConstructor   // 生成一个无参数的构造方法，
    public static class NoArgsExample {
        @NonNull
        private String field;
    }


}
