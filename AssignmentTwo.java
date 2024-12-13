package org.example;

public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    public static void partThree() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //创建5个visitor对象
        Visitor v1 = new Visitor("赵先生", "男", 28, "M001", "2024-11-30");
        Visitor v2 = new Visitor("钱女士", "女", 30, "M002", "2023-12-02");
        Visitor v3 = new Visitor("孙女士", "女", 23, "M003", "2023-12-02");
        Visitor v4 = new Visitor("李先生", "男", 19, "M004", "2023-12-04");
        Visitor v5 = new Visitor("王先生", "男", 37, "M005", "2023-12-05");

        //调用ride的方法，将5个visitor加入到等待队列中
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        //从队列中移除一个visitor
        ride.removeVisitorFromQueue();

        //打印队列中visitor的信息
        ride.printQueue();
        System.out.println("------------------------------");
    }

    public static void partFourA() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //创建5个visitor对象
        Visitor v1 = new Visitor("赵先生", "男", 28, "M001", "2024-11-30");
        Visitor v2 = new Visitor("钱女士", "女", 30, "M002", "2023-12-02");
        Visitor v3 = new Visitor("孙女士", "女", 23, "M003", "2023-12-02");
        Visitor v4 = new Visitor("李先生", "男", 19, "M004", "2023-12-04");
        Visitor v5 = new Visitor("王先生", "男", 37, "M005", "2023-12-05");

        //调用ride的方法，将5个visitor加入到历史集合中
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        //调用ride的方法，检查一个v1是否在历史记录中
        ride.checkVisitorFromHistory(v1);

        //打印历史记录的数量
        ride.numberOfVisitors();

        //打印历史记录的visitor详细信息
        ride.printRideHistory();
        System.out.println("------------------------------");
    }

    public static void partFourB() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //创建5个visitor对象
        Visitor v1 = new Visitor("赵先生", "男", 28, "M001", "2024-11-30");
        Visitor v2 = new Visitor("钱女士", "女", 30, "M002", "2023-12-02");
        Visitor v3 = new Visitor("孙女士", "女", 23, "M003", "2023-12-02");
        Visitor v4 = new Visitor("李先生", "男", 19, "M004", "2023-12-04");
        Visitor v5 = new Visitor("王先生", "男", 37, "M005", "2023-12-05");

        //调用ride的方法，将5个visitor加入到历史集合中
        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        //打印历史记录
        ride.printRideHistory();

        //使用自定义的比较器排序
        ride.sortHistoryList(new VisitorComparator());

        //打印排序后的历史记录
        ride.printRideHistory();
        System.out.println("------------------------------");
    }

    public static void partFive() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //创建10个visitor对象
        Visitor v1 = new Visitor("赵先生", "男", 28, "M001", "2024-11-30");
        Visitor v2 = new Visitor("钱女士", "女", 30, "M002", "2023-12-02");
        Visitor v3 = new Visitor("孙女士", "女", 23, "M003", "2023-12-02");
        Visitor v4 = new Visitor("李先生", "男", 19, "M004", "2023-12-04");
        Visitor v5 = new Visitor("王先生", "男", 37, "M005", "2023-12-05");
        Visitor v6 = new Visitor("仇女士", "女", 28, "M006", "2024-11-30");
        Visitor v7 = new Visitor("张女士", "女", 30, "M007", "2023-12-02");
        Visitor v8 = new Visitor("宋女士", "女", 23, "M008", "2023-12-02");
        Visitor v9 = new Visitor("冯先生", "男", 19, "M009", "2023-12-04");
        Visitor v10 = new Visitor("山先生", "男", 37, "M010", "2023-12-05");

        //调用ride的方法，将10个visitor加入到等待队列中
        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);
        ride.addVisitorToQueue(v6);
        ride.addVisitorToQueue(v7);
        ride.addVisitorToQueue(v8);
        ride.addVisitorToQueue(v9);
        ride.addVisitorToQueue(v10);

        //打印队列中visitor的信息
        ride.printQueue();

        //运行一次
        ride.runOneCycle();

        //运行一次后再打印等待队列中的visitor信息
        ride.printQueue();

        //打印历史记录
        ride.printRideHistory();
        System.out.println("------------------------------");
    }

    public static void partSix() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //创建5个visitor对象
        Visitor v1 = new Visitor("赵先生", "男", 28, "M001", "2024-11-30");
        Visitor v2 = new Visitor("钱女士", "女", 30, "M002", "2023-12-02");
        Visitor v3 = new Visitor("孙女士", "女", 23, "M003", "2023-12-02");
        Visitor v4 = new Visitor("李先生", "男", 19, "M004", "2023-12-04");
        Visitor v5 = new Visitor("王先生", "男", 37, "M005", "2023-12-05");

        ride.addVisitorToHistory(v1);
        ride.addVisitorToHistory(v2);
        ride.addVisitorToHistory(v3);
        ride.addVisitorToHistory(v4);
        ride.addVisitorToHistory(v5);

        ride.exportRideHistory("rideHistory.csv");
        System.out.println("------------------------------");
    }

    public static void partSeven() {
        //创建一个ride对象
        Ride ride = new Ride("过山车", 8, new Employee("员工-李", "男", 24, "E001", "操作员"));

        //导入partSix中导出的文件
        ride.importRideHistory("rideHistory.csv");

        //打印历史记录的visitor数量
        ride.numberOfVisitors();

        //打印历史记录的visitor详细信息
        ride.printRideHistory();
        System.out.println("------------------------------");
    }
}