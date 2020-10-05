package com.wufan.task2;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author HeHao
 * @Date 2020/9/8 9:45
 * @Version 1.0
 */
public class IOEquipment {
    public static boolean isRun;
    public static Queue<Program> taskQueue = new PriorityQueue<>();

    /**
     * IO设备的运行方法
     *
     * @param time IO设备运行所消耗的时间
     * @param name 占用IO设备的程序名称
     */
    public static synchronized void run(String name, int time) throws InterruptedException {
        Thread.sleep(time * 100);
        System.out.println("程序" + name + "占用IO设备耗时" + time + "秒");
        ComputerSystem.totalTime += time;
    }
}
