package com.zuoqiang.learn.springboot.easyexcel;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zuoqiang
 * @version 1.0
 * @description 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 * @date 2020/5/11 3:32 下午
 */

@Repository
public class UploadDAO {

    public void save(List<UploadData> list) {
        // 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
    }
}
