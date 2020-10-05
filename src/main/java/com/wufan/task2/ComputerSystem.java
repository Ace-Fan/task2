package com.wufan.task2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author HeHao
 * @Date 2020/9/8 9:44
 * @Version 1.0
 */
public class ComputerSystem {
    //模式
    public static Pattern pattern;
    //非抢占式队列
    public static Queue<Program> NonPreemptiveQueue = new LinkedList<>();
    //抢占式队列
    public static Queue<Program> PreemptiveQueue = new PriorityQueue<>();
    //总耗时
    public static int totalTime;

    /**
     * 执行程序
     */
    public static void executiveProgram() {
        try {
            switch (pattern) {
                case SCNP:
                    SCNPPattern();
                    break;
                case SCP:
                    SCPPattern();
                    break;
                case MCNP:
                    break;
                case MCP:
                    break;
                default:
                    System.out.println("请输入正确的模式!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * SCNP:SingleChannelNonPreemptive(单道非抢占式)
     */
    private static void SCNPPattern() throws InterruptedException {
        while (!NonPreemptiveQueue.isEmpty()) {
            Program program = NonPreemptiveQueue.poll();
            Cpu.run(program.getName(), program.getBeginningCpuTime());
            IOEquipment.run(program.getName(), program.getIoTime());
            Cpu.run(program.getName(), program.getEndCpuTime());
        }
    }

    /**
     * SCP:SingleChannelPreemptive(单道抢占式)
     */
    private static void SCPPattern() throws InterruptedException {
        while (!PreemptiveQueue.isEmpty()) {
            Program program = PreemptiveQueue.poll();
            Cpu.run(program.getName(), program.getBeginningCpuTime());
            IOEquipment.run(program.getName(), program.getIoTime());
            Cpu.run(program.getName(), program.getEndCpuTime());
        }
    }

    /**
     * MCNP:MultipleChannelNonPreemptive(多道非抢占式)
     */
    private static Program currentProgram;

    private static void MCNPPattern() throws InterruptedException {
        new Thread() {
            @Override
            public void run() {

            }
        }.start();

        new Thread() {
            @Override
            public void run() {

            }
        }.start();
    }

    //打印
    public static void print() {

    }
}
