package com.atguigu.juc.jucstudy02.juc;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


class MyThread implements Callable<Integer>
{

    @Override
    public Integer call() throws Exception {
        System.out.println("=========come in call()");
        return 666;
    }
}


//多线程中，第三种获得多线程的方式
/*
* 第一种：继承Thread类（一般工作中很少用）
* 第二种：实现Runnable接口
* 第三种：Runnable和Callable同时实现FutureTask
* */
public class CallableDemo
{
    public static void main(String[] args)throws InterruptedException,ExecutionException
    {
        //FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread());
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() ->{
            System.out.println("=========come in call() lambda express");
            return 888;
        });

        Thread t1 = new Thread(futureTask,"A");
        t1.start();

        System.out.println("========retValue: " +futureTask.get());
    }
}
