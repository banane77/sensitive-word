package com.github.houbb.sensitive.word.benchmark;

import com.github.houbb.heaven.util.util.RandomUtil;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.core.SensitiveWordHelper;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class BasicTest {

    /**
     *
     *
     * 100*100 耗时：926ms，性能較差。
     *
     * 100*100000 的字符：12942ms 第一次优化。
     */
    @Test
    public void costTimeTest() {
        String randomText = "你他妈的不要说脏话"+ RandomUtil.randomString("1234567890bcdefghiJKLMNOPQRSTUVWXYZ", 100)
                + "我们他妈的从来不说脏说";


        // 1W 次
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            SensitiveWordHelper.findAll(randomText);
        }
        long end = System.currentTimeMillis();
        System.out.println("------------------ COST: " + (end-start));
    }

    /**
     *
     * 100*100000 的字符：12440ms
     */
    @Test
    public void costTimeOnlyWordTest() {
        String randomText = "你他妈的不要说脏话"+ RandomUtil.randomString("1234567890bcdefghiJKLMNOPQRSTUVWXYZ", 100)
                + "我们他妈的从来不说脏说";

        // 1W 次
        long start = System.currentTimeMillis();
        SensitiveWordBs sensitiveWordBs = SensitiveWordBs.newInstance()
                .enableWordCheck(false)
                .init();

        for(int i = 0; i < 10000; i++) {
            sensitiveWordBs.findAll(randomText);
        }
        long end = System.currentTimeMillis();
        System.out.println("------------------ COST: " + (end-start));
    }

}
