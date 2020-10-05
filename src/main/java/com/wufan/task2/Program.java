package com.wufan.task2;


import com.sun.istack.internal.NotNull;

/**
 * @Author HeHao
 * @Date 2020/9/8 9:45
 * @Version 1.0
 */
public class Program implements Comparable {
    //当前程序名称
    private String name;
    //当前程序开始执行所需要的cpu执行时间
    private int beginningCpuTime;
    //当前程序结束执行所需要的cpu执行时间
    private int endCpuTime;
    //当前程序所需要的io设备的执行时间
    private int ioTime;
    //优先级
    private int priority = 5;


    public Program(String name, int beginningCpuTime, int endCpuTime, int ioTime) {
        this.name = name;
        this.beginningCpuTime = beginningCpuTime;
        this.endCpuTime = endCpuTime;
        this.ioTime = ioTime;
    }

    public Program(String name, int beginningCpuTime, int endCpuTime, int ioTime, int priority) {
        this.name = name;
        this.beginningCpuTime = beginningCpuTime;
        this.endCpuTime = endCpuTime;
        this.ioTime = ioTime;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEndCpuTime() {
        return endCpuTime;
    }

    public void setEndCpuTime(int endCpuTime) {
        this.endCpuTime = endCpuTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeginningCpuTime() {
        return beginningCpuTime;
    }

    public void setBeginningCpuTime(int beginningCpuTime) {
        this.beginningCpuTime = beginningCpuTime;
    }

    public int getIoTime() {
        return ioTime;
    }

    public void setIoTime(int ioTime) {
        this.ioTime = ioTime;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        if (o == null)
            return 1;
        if (!(o instanceof Program))
            return 1;
        Program program = (Program) o;
        if (this.priority > program.priority)
            return 1;
        else if (this.priority < program.priority)
            return -1;
        else
            return 0;
    }
}
