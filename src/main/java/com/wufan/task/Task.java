package com.wufan.task;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task implements Comparable{
    public String name;
    private float Entime;
    private float Retime;
    public Task(String name, float Entime, float Retime) {
        this.name = name;
        this.Entime = Entime;
        this.Retime = Retime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getEntime() {
        return Entime;
    }
    public void setEntime(float Entime) {
        this.Entime = Entime;
    }
    public float getRetime() {
        return Retime;
    }
    public void setRetime(float Retime) {
        this.Retime = Retime;
    }
    @Override
    public int compareTo(Object o){               //排队条件
        Task s = (Task)(o);
        if(this.Entime >= s.Entime) {
            return 1;
        }
        return -1;
    }
}

class Pframe{                  //简单界面，左侧为输入框，右侧为测试结果框
    JFrame frame;
    JButton start;
    JTextArea Prarea, Rearea;
    JLabel label1, label2;
    JButton work;
    JPanel panel;
    Pframe(String title){
        frame = new JFrame(title);
        frame.setSize(800,600);
        frame.setLayout(null);
        Prarea = new JTextArea(5,20);
        Rearea = new JTextArea(6,20);
        label1 = new JLabel("请输入测试数据：");
        label2 = new JLabel("测试结果：");
        work = new JButton("Examining");
        frame.add(Rearea);
        frame.add(Prarea);
        frame.add(label1);
        frame.add(label2);
        label1.setBounds(50, 50, 120, 30);
        label2.setBounds(300, 50, 120, 30);
        Prarea.setBounds(300, 80, 430, 250);
        Rearea.setBounds(50, 80, 220, 250);
        frame.add(work);
        work.setBounds(250, 400, 100, 40);
        frame.setVisible(true);
        work.addActionListener(new ButtonEvent());
    }
    class ButtonEvent implements ActionListener{           //按钮Examining的响应
        @Override
        public void actionPerformed(ActionEvent e){
            Prarea.setText("");
            Scanner In = new Scanner(Rearea.getText());
            int num = In.nextInt();
            int ordernum = 0;
            String Taskname;
            float Entime;float Retime;
            ArrayList<Task> arr = new ArrayList<>();

            for(int i = 0; i < num; i++) {           //读入数据
                Taskname = In.next();
                Entime=In.nextFloat();
                Entime= (int)(Entime/100)*60 + Entime%100;        //得到时间转化为10进制
                Retime=In.nextFloat();
                Task task = new Task(Taskname, Entime, Retime);
                arr.add(task);
            }
            In.close();

            Collections.sort(arr);                  //按照进入时刻排序
            Prarea.append("调度次序\t作业号\t调度时间\t周转时间\t带权周转时间");
            float CurrentTime = arr.get(0).getEntime();
            float sum1 = 0, sum2 = 0;
            float retime = 0;
            float entime = 0;

            for(int i = 0;i<num;i ++) {                 //选取能在时间进行调度的Task
                List<Task> newarr = new ArrayList<>();
                for(int j = 0;j < arr.size();j ++) {
                    if(arr.get(j).getEntime()<=CurrentTime) {
                        newarr.add(arr.get(j));
                    }
                }
                if(newarr.size() == 0 && arr.size() != 0) {   //空转，当没有任务的时候
                    i--;
                    CurrentTime++;
                    continue;
                }

                for(int j=1;j<newarr.size();j++) {              //确定作业号Task，最高响应比确定，并将其放在0号arr单元
                    if((CurrentTime-newarr.get(j).getEntime())/newarr.get(j).getRetime()>=(CurrentTime-newarr.get(0).getEntime())/newarr.get(0).getRetime()) {
                        if((CurrentTime-newarr.get(j).getEntime())/newarr.get(j).getRetime() == (CurrentTime-newarr.get(0).getEntime())/newarr.get(0).getRetime()) {
                            if(newarr.get(0).getRetime() > newarr.get(j).getRetime())     //相应比相同的比较需要执行的时间
                            {
                                newarr.set(0, newarr.get(j));
                            }
                        }
                        else {
                            newarr.set(0, newarr.get(j));
                        }
                    }
                }

                arr.remove((Task)newarr.get(0));                  //移除作业号进行此次调度的输出操作
                retime = newarr.get(0).getRetime();
                entime = newarr.get(0).getEntime();                //对于输出 调度时间的输出是60进制，周转时间和带权周转时间的输出为10进制

                //输出
                Prarea.append("\n"+(++ordernum)+"\t"+newarr.get(0).getName()+"\t");

                int a1 = (int)CurrentTime/60;       //对调度时间的输出才去时间的输出格式
                int a2 = (int)CurrentTime%60;
                if(a1>=10) {
                    Prarea.append(a1+":");
                    if(a2>=10) {
                        Prarea.append(a2+"");
                    }
                    else {
                        Prarea.append("0"+a2);
                    }
                }
                else {
                    Prarea.append("0"+a1+":");
                    if(a2>=10) {
                        Prarea.append(a2+"");
                    }
                    else {
                        Prarea.append("0"+a2);
                    }
                }

                Prarea.append("\t"+(int)(CurrentTime-entime+retime)+"min"+"\t"+((retime+CurrentTime-entime)/retime));
                sum2+=(CurrentTime-entime+retime)/retime;
                sum1 += CurrentTime-entime+retime;
                CurrentTime = CurrentTime+retime;
            }
            Prarea.append("\n"+"平均周转时间为"+String.format("%.2f", sum1/num)+"min"+"        "+"平均带权周转时间为"+String.format("%.2f", sum2/num)+"min");

        }
    }
}
class processing {
    public static void main(String arg[]){
        new Pframe("多道批处理作业");
    }
}
