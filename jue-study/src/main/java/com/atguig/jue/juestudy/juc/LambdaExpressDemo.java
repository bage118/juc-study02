package com.atguig.jue.juestudy.juc;

@FunctionalInterface
interface Foo
{
//    public void sayHello();
    public int add(int x,int y);

    public default int div(int x,int y)
    {
        return x/y;
    }
    public default int div2(int x,int y)
    {
        return x/y;
    }
    public default int div3(int x,int y)
    {
        return x/y;
    }

    public static int mul(int x,int y)
    {
        return x * y;
    }
}

/*
* 三板斧：理论+代码+总结
*  1 Lambda Express --->  函数式接口-->  类里面只有一个方法
*  1.1  拷贝小括号，写死右箭头，落地大括号,大括号里面写业务逻辑方法
*  函数式接口才能用Lambda Express
*  1.2  如何声明一个函数式接口?
*  1.3  default 支持接口内有方法实现
* */
public class LambdaExpressDemo {

    public static void main(String[] args)
    {
       /* Foo foo = new Foo() {
            @Override
            public void sayHello()
            {
                System.out.println("=========sayHello 0925");
            }

            @Override
            public int add(int x, int y) {
                return 11;
            }
        };
        foo.sayHello();*/


       Foo foo = (x,y) -> {
           System.out.println("=======come in");
           return x + y;
       };
        System.out.println(foo.add(3, 5));
        System.out.println(foo.div(8, 4));
        System.out.println(Foo.mul(8, 4));

    }
}
