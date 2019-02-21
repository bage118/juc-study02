package com.atguigu.juc.jucstudy03.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CompletableFutureDemo
{
    public static void main(String[] args)throws Exception
    {

        //异步函数调用,没有返回值
        CompletableFuture<Void> completableFuture01 = CompletableFuture.runAsync(()->{
            System.out.println("============completableFuture01");
        });

        //异步函数调用,有返回值
        CompletableFuture<Integer> completableFuture02 = CompletableFuture.supplyAsync(()->{
            System.out.println("============completableFuture02");
             //暂停一会儿线程
            try{ TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            int age = 10/0;
            return 1024;
        });

        //System.out.println(completableFuture02.get());
        Integer retValue = completableFuture02.whenComplete((t,u) ->{
            System.out.println("=======result:" +t);
            System.out.println("=======Exception:" +u);
        }).exceptionally(e ->{
            System.out.println("=======Exception:" +e);
            return 250;
        }).get();

        System.out.println("======retValue: " + retValue );
       /* Supplier<String> supplier = "abc" ::toUpperCase;//推荐
        System.out.println(supplier.get());

        String str = "abc";
        System.out.println(str.toUpperCase());*/
    }

}
