package com.atguigu.juc.jucstudy03.juc;

import java.util.concurrent.*;


/**
* 阻塞队列
*
*   1、同步
*   2、异步
*   3、异步回调
*   4、分布式
*   5、集群
*   6、MQ（消息中间件）
*   7、轮询
*
* */
public class BolockingQueueDemo {
    public static void main(String[] args)throws ExecutionException,InterruptedException
    {
        // List list = new ArrayList();
        /*BlockingQueue blockingQueue1 = new LinkedBlockingQueue(5);
        BlockingQueue blockingQueue2 = new ArrayBlockingQueue(5);
        BlockingQueue blockingQueue3 = new SynchronousQueue();*/

        //第三组
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");


        /*//第二组
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));
        System.out.println("666666666666");
       // System.out.println(blockingQueue.offer("d"));

//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());*/

       /* //第一组
       // BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        blockingQueue.add("a");
        blockingQueue.add("b");
        blockingQueue.add("c");

       // System.out.println(blockingQueue.element());
        //blockingQueue.add("d");
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());*/
          System.out.println("=======come in ok");


    }
}
