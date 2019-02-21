package com.atguigu.juc.jucstudy03.juc;

import java.util.concurrent.*;

//第四种获得多线程的方法：线程池
public class MyThreadPoolDemo
{
    public static void main(String[] args) {
       //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool = Executors.newCachedThreadPool();


        /* public ThreadPoolExecutor(int corePoolSize,
        int maximumPoolSize,
        long keepAliveTime,
        TimeUnit unit,
        BlockingQueue<Runnable> workQueue,
        ThreadFactory threadFactory,
        RejectedExecutionHandler handler)*/

        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try
        {
             for (int i = 1; i <=10 ; i++)
                     {
                         final int tempInt = i;
                        threadPool.execute(()->{
                            System.out.println( Thread.currentThread().getName()+"\t 办理业务"+tempInt);
                        });
                     }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            threadPool.shutdown();
        }
    }

}
