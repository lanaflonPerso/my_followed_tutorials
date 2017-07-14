package com.wefine.distributed.arith;

/**
 * Twitter的snowflake算法
 */
public class SnowFlake {

    /**
     * 起始的时间戳
     */
    private final static long START_STAMP = 1487260800L;

    /**
     * 每一部分占用的位数
     */
    private final static long SEQUENCE_BIT = 12; //序列号占用的位数
    private final static long MACHINE_BIT = 5;   //机器标识占用的位数
    private final static long DATA_CENTER_BIT = 5;//数据中心占用的位数

    /**
     * 每一部分的最大值
     */
    private final static long MAX_DATA_CENTER_NUM = ~(-1L << DATA_CENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);


    // 机器ID偏左移12位
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    // 数据中心ID左移17位
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    // 时间毫秒左移22位
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    private long datacenterId;      //数据中心
    private long machineId;         //机器标识
    private long sequence = 0L;     //序列号
    private long lastStamp = -1L;   //上一次时间戳

    public SnowFlake(long dcId, long mId) {
        if (dcId > MAX_DATA_CENTER_NUM || dcId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0");
        }
        if (mId > MAX_MACHINE_NUM || mId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = dcId;
        this.machineId = mId;
    }

    /**
     * 产生下一个ID
     *
     * @return long
     */
    public synchronized long nextId() {
        long currStamp = currentMillis();
        if (currStamp < lastStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStamp == lastStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currStamp = nextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }

        lastStamp = currStamp;

        return (currStamp - START_STAMP) << TIMESTAMP_LEFT //时间戳部分
            | datacenterId << DATA_CENTER_LEFT       //数据中心部分
            | machineId << MACHINE_LEFT             //机器标识部分
            | sequence;                             //序列号部分
    }

    private long nextMill() {
        long mill = currentMillis();
        while (mill <= lastStamp) {
            mill = currentMillis();
        }
        return mill;
    }

    private long currentMillis() {
        return System.currentTimeMillis();
    }

}
