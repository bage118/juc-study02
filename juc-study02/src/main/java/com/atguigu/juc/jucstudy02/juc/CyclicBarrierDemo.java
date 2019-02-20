package com.atguigu.juc.jucstudy02.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo
{
    public static void main(String[] args)
    {
        //如果按照规范来，常量应该用private static finally 常量（大写）= XXX
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{System.out.println("=======一条龙服务"); });

        for (int i = 1; i <=7 ; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    System.out.println( Thread.currentThread().getName()+"\t 办了第"+tempInt+"张会员卡");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }

    }
}
