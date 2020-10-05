package com.wufan.task2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author HeHao
 * @Date 2020/9/8 9:44
 * @Version 1.0
 */
public class Cpu {
    public static boolean isRun;
    public static Queue<Program> taskQueue = new PriorityQueue<>();

    /**
     * CPU运行方法
     *
     * @param time CPU执行任务所需要的时间
     * @param name 占用CPU的程序名称
     */
    public static synchronized void run(String name, int time) throws InterruptedException {
        Thread.sleep(time * 100);
        System.out.println("CPU执行程序" + name + "耗时" + time + "秒");
        ComputerSystem.totalTime += time;
    }
}
