package com.atguigu.juc.jucstudy03.juc;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class MyCache
{
    //volatile保证可见性,只要有人动过这个缓存，所有线程都会收到所有通知
    private  volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();


    public void put(String key,Object value)
    {
        rwlock.writeLock().lock();
        try
        {
        System.out.println( Thread.currentThread().getName()+"\t 正在写："+key+"===begin");
         //暂停一会儿线程
        try{TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
        map.put(key,value);
        System.out.println( Thread.currentThread().getName()+"\t 写完成："+key+"===end");
            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwlock.writeLock().unlock();
        }

    }


    public Object get(String key)
    {
        rwlock.readLock().lock();
        Object result = null;
        try
        {
        System.out.println( Thread.currentThread().getName()+"\t 正在读："+"===begin");
        try{TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
        result = map.get(key);
        System.out.println( Thread.currentThread().getName()+"\t 完成读："+result+"===end");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            rwlock.readLock().unlock();
        }
        return result;
    }

    //应该会有清空缓存的方法，这边就不体现了

}


/**
* 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其它线程可以对该资源进行读或写
 * 小总结：
 *          读-读能共存
 *          读-写不能共存
 *          写-写不能共存
*
*/



public class ReadWriteLockDemo {

    public static void main(String[] args)
    {
        MyCache myCache =new MyCache();

        for (int i = 1; i <=5 ; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                        myCache.put(tempInt+"",tempInt+"");
                    },String.valueOf(i)).start();
        }

        for (int i = 1; i <=5 ; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                        myCache.get(tempInt+"");
                    },String.valueOf(i)).start();
        }

    }
}
