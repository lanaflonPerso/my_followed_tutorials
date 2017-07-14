package com.wefine.distributed.arith;


import org.junit.Test;

public class SnowFlakeTest {

    @Test
    public void test(){
        SnowFlake snowFlake = new SnowFlake(1, 3);

        for (int i = 0; i < (1 << 4); i++) {
            System.out.println(snowFlake.nextId());
        }
    }
}
