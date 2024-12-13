package org.example;

import java.io.*;
import java.util.*;

//Ride类
public class Ride implements RideInterface {//实现RideInterface接口

    //名称
    private String title;

    //一次可接待人数
    private int maxRider;

    //工作人员（Employee类型）
    private Employee operator;

    //运行次数，默认为0
    private Integer numOfCycles = 0;

    //等待队列
    private Queue<Visitor> waitingQueue = new LinkedList<>();

    //历史记录集合
    private List<Visitor> historyList =  new LinkedList<>();

    //默认构造函数
    public Ride() {

    }

    //初始化变量的构造函数
    public Ride(String title, int maxRider, Employee operator) {
        this.title = title;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    //Getter、Setter方法
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getMaxRider() {
        return maxRider;
    }
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public Employee getOperator() {
        return operator;
    }
    public void setOperator(Employee operator) {
        this.operator = operator;
    }


    // 实现RideInterface接口的方法
    //添加visitor到队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        //如果visitor不是空，加入队列
        if (null != visitor){
            waitingQueue.add(visitor);
            System.out.println("游客" + visitor.getName() + "已加入等待队列。");
        }else {
            System.out.println("游客信息异常，加入队列失败！");
        }
    }

    //从队列中移除访问者
    @Override
    public void removeVisitorFromQueue() {
        //等待队列是否为空
        if (!waitingQueue.isEmpty()) {
            //移除队列第一个visitor
            Visitor visitor = waitingQueue.remove();
            System.out.println("游客" + visitor.getName() + "已从等待队列中移除。");
        } else {
            System.out.println("等待队列是空的，移除失败！");
        }
    }

    //打印队列中等待访问者的列表
    @Override
    public void printQueue() {
        if (!waitingQueue.isEmpty()){
            System.out.println("等待游客列表：");
            for (Visitor visitor : waitingQueue) {
                System.out.println("姓名：" + visitor.getName() + "\t" + "性别：" + visitor.getGender()+ "\t" + "年龄：" + visitor.getAge() + "\t"
                        + "编号：" + visitor.getMemberId() + "\t" + "入园时间：" + visitor.getEntryDate());
            }
        }else {
            System.out.println("没有等待的游客！");
        }
    }

    @Override
    public void runOneCycle() {
        //没有操作员
        if (null == operator) {
            System.out.println("没有操作员，无法运行。");
            return;
        }
        //没有等待游客
        if (waitingQueue.isEmpty()) {
            System.out.println("没有等待的游客，无法运行。");
            return;
        }
        int num = 0;//取得的游客数量
        if (waitingQueue.size() > maxRider){//队列中的游客数量大于maxRider，取前maxRider个游客
            num = maxRider;
        }else {//否则，取队列中的所有游客
            num = waitingQueue.size();
        }
        //循环将游客从等待队列中移除，并添加到历史记录中
        for (int i = 0; i < num; i++) {
            //移除队列中第一个visitor
            Visitor visitor = waitingQueue.poll();
            //添加到历史集合中
            historyList.add(visitor);
            System.out.println("游客" + visitor.getName() + "已从等待队列中移除，并已添加到历史记录中。");
        }
        //一次循环结束，运行次数加1
        numOfCycles++;
    }

    //添加visitor到ride的历史记录中
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (null != visitor){
            // 不为空，添加到历史集合中
            historyList.add(visitor);
            System.out.println("游客 " + visitor.getName() + "已添加到历史记录中。");
        }else {
            System.out.println("游客信息异常，添加历史记录失败！");
        }
    }

    //检查visitor是否在ride历史记录中
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        //若visitor为空，直接返回false
        if (null == visitor){
            System.out.println("游客信息异常，不在历史记录中。");
            return false;
        }
        if (historyList.isEmpty()){
            System.out.println("历史记录是空的，不包含该游客！");
            return false;
        }
        //此时集合、visitor都不是空，判断集合中是否包含visitor
        if (historyList.contains(visitor)) {
            //包含，返回true
            System.out.println("游客 " + visitor.getName() + "在历史记录中。");
            return true;
        }
        System.out.println("游客 " + visitor.getName() + "不在历史记录中。");
        return false;
    }

    //返回ride的历史记录中visitor的数量
    @Override
    public int numberOfVisitors() {
        //判断集合是空，直接返回0
        if (historyList.isEmpty()){
            System.out.println("历史记录数量为0");
            return 0;
        }
        System.out.println("历史记录数量为: " + historyList.size());
        return historyList.size();
    }

    //打印乘坐ride的游客列表
    @Override
    public void printRideHistory() {
        System.out.println("历史记录信息如下：");
        //使用迭代器
        Iterator<Visitor> iterator = historyList.iterator();
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println("姓名：" + visitor.getName() + "\t" + "性别：" + visitor.getGender()+ "\t" + "年龄：" + visitor.getAge() + "\t"
            + "编号：" + visitor.getMemberId() + "\t" + "入园时间：" + visitor.getEntryDate());
        }
    }

    //排序历史记录
    public void sortHistoryList(VisitorComparator comparator) {
        if (historyList.isEmpty()){
            System.out.println("历史记录是空的，无法排序！");
        }else {
            Collections.sort(historyList, comparator);
            System.out.println("历史记录排序完成。");
        }
    }


    //导出
    public void exportRideHistory(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            //遍历历史记录集合
            for (int i = 0;i < historyList.size(); i++){
                //将集合中的元素写入到文件中
                writer.println(historyList.get(i).getName() + "," + historyList.get(i).getGender() + "," + historyList.get(i).getAge()
                        + "," + historyList.get(i).getMemberId() + "," + historyList.get(i).getEntryDate());
            }
            System.out.println("历史记录导出到" + filename + "文件");
        } catch (IOException e) {
            System.err.println("历史记录导出失败。错误信息：" + e.getMessage());
        }
    }

    //导入
    public void importRideHistory(String filename) {
        //使用BufferedReader打开指定文件
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            //逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                //将每行内容按逗号分隔成数组
                String[] parts = line.split(",");
                //判断数组长度是否为5，否则数据有误
                if (parts.length == 5) {
                    //将数组元素转换为Visitor对象，并添加到历史记录集合中
                    Visitor visitor = new Visitor(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4]);
                    //解析出来加入到历史集合中
                    historyList.add(visitor);
                    System.out.println("游客" + visitor.getName() + "信息已导入。");
                } else {
                    System.err.println("数据解析有误，导入失败！");
                }
            }
        } catch (IOException e) {
            System.err.println("Error importing ride history: " + e.getMessage());
        }
    }
}
