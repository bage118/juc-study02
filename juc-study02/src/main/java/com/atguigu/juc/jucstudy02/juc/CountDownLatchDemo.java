package com.atguigu.juc.jucstudy02.juc;

import com.atguigu.juc.jucstudy02.enums.CountryEnum;
import com.atguigu.juc.jucstudy02.enums.WeekEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{
    public static void main(String[] args)throws Exception
    {
        CountDownLatch countDownLatch = new CountDownLatch(7);

         for (int i = 1; i <=7 ; i++)
                 {
                     new Thread(() ->{
                         System.out.println( Thread.currentThread().getName()+"\t 开始了");
                         countDownLatch.countDown();
                     },WeekEnum.forEach_WeekEnum(i).getRetMessage()).start();
                 }
                countDownLatch.await();
                System.out.println( Thread.currentThread().getName()+"\t 一周完了，又到周一，困成狗");

                 /*System.out.println(WeekEnum.SIX);
                 System.out.println(WeekEnum.SIX.getRetCode());
                 System.out.println(WeekEnum.SIX.getRetMessage());*/


    }

    private static void destoryCountry() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++)
        {
            new Thread(() ->{
                System.out.println( Thread.currentThread().getName()+"\t 国被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println( Thread.currentThread().getName()+"\t 一统华夏");

        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <=6 ; i++)
                {
                    new Thread(() ->{
                        System.out.println( Thread.currentThread().getName()+"\t 同学离开教室");
                        countDownLatch.countDown();
                    },String.valueOf(i)).start();
                }
        countDownLatch.await();
        System.out.println( Thread.currentThread().getName()+"\t 班长关门走人");


    }
}
