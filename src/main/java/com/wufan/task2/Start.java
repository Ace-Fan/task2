package com.wufan.task2;

/**
 * @Author HeHao
 * @Date 2020/9/8 10:28
 * @Version 1.0
 */
public class Start {
    /**
     * 这是一个测试方法
     * SCNP:SingleChannelNonPreemptive(单道非抢占式)
     */
    public static void SCNP() {
        //设置运行模式
        ComputerSystem.pattern = Pattern.valueOf("SCNP");
        System.out.println(ComputerSystem.pattern + "模式");
        //创建程序对象
        Program p1 = new Program("A", 20, 10, 30);
        Program p2 = new Program("B", 30, 20, 50);
        Program p3 = new Program("C", 10, 10, 20);

        //添加到非抢占式队列中
        ComputerSystem.NonPreemptiveQueue.add(p1);
        ComputerSystem.NonPreemptiveQueue.add(p2);
        ComputerSystem.NonPreemptiveQueue.add(p3);

        //执行
        ComputerSystem.executiveProgram();

        //输出总耗时
        System.out.println("总耗时" + ComputerSystem.totalTime + "秒");
    }

    /**
     * 这是一个测试方法
     * SCP:SingleChannelPreemptive(单道抢占式)
     */
    public static void SCP() {
        //设置运行模式
        ComputerSystem.pattern = Pattern.valueOf("SCP");
        System.out.println(ComputerSystem.pattern + "模式");
        //创建程序对象
        Program p1 = new Program("A", 20, 10, 30, 5);
        Program p2 = new Program("B", 30, 20, 50, 10);
        Program p3 = new Program("C", 10, 10, 20, 1);

        //添加到抢占式队列中
        ComputerSystem.PreemptiveQueue.add(p1);
        ComputerSystem.PreemptiveQueue.add(p2);
        ComputerSystem.PreemptiveQueue.add(p3);

        //执行
        ComputerSystem.executiveProgram();

        //输出总耗时
        System.out.println("总耗时" + ComputerSystem.totalTime + "秒");
    }

    /**
     * 这是一个测试方法
     * MCNP:MultipleChannelNonPreemptive(多道非抢占式)
     */
    public static void MCNP() {
        //设置运行模式
        ComputerSystem.pattern = Pattern.valueOf("MCNP");
        System.out.println(ComputerSystem.pattern + "模式");
        //创建程序对象
        Program p1 = new Program("A", 20, 10, 30);
        Program p2 = new Program("B", 30, 20, 50);
        Program p3 = new Program("C", 10, 10, 20);

        //添加到非抢占式队列中
        ComputerSystem.NonPreemptiveQueue.add(p1);
        ComputerSystem.NonPreemptiveQueue.add(p2);
        ComputerSystem.NonPreemptiveQueue.add(p3);

        //执行
        ComputerSystem.executiveProgram();

        //输出总耗时
        System.out.println("总耗时" + ComputerSystem.totalTime + "秒");
    }

    public static void main(String[] args) {
        //单道非抢占式测试
//        SCNP();

        //单道抢占式测试
        MCNP();
    }
}
