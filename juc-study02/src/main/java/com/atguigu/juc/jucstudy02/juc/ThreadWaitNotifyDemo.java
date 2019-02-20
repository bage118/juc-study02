package com.atguigu.juc.jucstudy02.juc;

/*
排除故障：故障现象+导致原因+解决方案
* 题目：现在两个线程，可以现操作初始值为零的员工变量，实现一个线程对该变量加1，
* 一个线程对该变量减1，实现交替，来10轮，变量初始值为零。
*   1 高内聚低耦合前提下， 线程     操作      资源类
*   2
*       2.1     判断
*       2.2     干活
*       2.3     通知
*
*  3   避免虚假唤醒 ,线程判断用while
* */


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResouce
{
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment()throws Exception
    {
        lock.lock();
        try
        {
            //1 判断
            //wait()和notify是java,lang.Object包下的
            while(num != 0 ){
               condition.await(); //this.wait();

            }
            //2 干活
            num++;
            System.out.println( Thread.currentThread().getName() + "\t" + num);
            //3 通知
            condition.signalAll();//this.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
 public void decrement()throws Exception
    {
        lock.lock();
        try
        {
            //1 判断
            //wait()和notify是java,lang.Object包下的
            while(num == 0 ){
               condition.await(); //this.wait();

            }
            //2 干活
            num--;
            System.out.println( Thread.currentThread().getName() + "\t" + num);
            //3 通知
            condition.signalAll();//this.notifyAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    /*public synchronized void increment()throws Exception
    {
        //1 判断
        //wait()和notify是java,lang.Object包下的
        while(num != 0 ){
            this.wait();
        }
        //2 干活
        num++;
        System.out.println( Thread.currentThread().getName() + "\t" + num);
        //3 通知
        this.notifyAll();
    }

    public synchronized void decrement()throws Exception
    {
        //1 判断
        while(num == 0 ){
            this.wait();
        }
        //2 干活
        num--;
        System.out.println( Thread.currentThread().getName() + "\t" + num);
        //3 通知
        this.notifyAll();
    }*/
}

public class ThreadWaitNotifyDemo {

    public static void main(String[] args)
    {
        ShareResouce sr = new ShareResouce();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.increment();
                    //暂停一会儿线程
                    try{ Thread.sleep(200);}catch (InterruptedException e) {e.printStackTrace();}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                },"A").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.decrement();
                    try{ Thread.sleep(300);}catch (InterruptedException e) {e.printStackTrace();}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                },"B").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.increment();
                    try{ Thread.sleep(400);}catch (InterruptedException e) {e.printStackTrace();}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                },"C").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.decrement();
                    try{ Thread.sleep(500);}catch (InterruptedException e) {e.printStackTrace();}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                },"D").start();
    }

}
