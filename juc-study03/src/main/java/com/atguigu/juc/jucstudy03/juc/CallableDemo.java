package com.atguigu.juc.jucstudy03.juc;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

    public static void main(String[] args)throws Exception
    {
        //FutureTask有线程返回值的
        FutureTask<Integer> ft = new FutureTask<Integer>(()->{
             //暂停一会儿线程
            try{TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            return 1024;
        });
        new Thread(ft,"A").start();


        //System.out.println(ft.get());//产生阻塞，不出结果不往下走

        //异步(阻塞/轮询)

        //阻塞

        //轮询
        while (!ft.isDone())
        {
            System.out.println("wait.........");
        }
        System.out.println( Thread.currentThread().getName()+"\t task main");

    }
}
