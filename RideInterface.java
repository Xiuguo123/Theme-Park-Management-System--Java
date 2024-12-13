package org.example;

//RideInterface接口
public interface RideInterface {

    //添加visitor到队列
    void addVisitorToQueue(Visitor visitor);

    //从队列中移除访问者
    void removeVisitorFromQueue();

    //打印队列中等待访问者的列表
    void printQueue();

    //运行一次ride
    void runOneCycle();

    //添加visitor到ride的历史记录中
    void addVisitorToHistory(Visitor visitor);

    //检查visitor是否在ride历史记录中
    boolean checkVisitorFromHistory(Visitor visitor);

    //返回ride的历史记录中visitor的数量
    int numberOfVisitors();

    //打印乘坐ride的游客列表
    void printRideHistory();
}
