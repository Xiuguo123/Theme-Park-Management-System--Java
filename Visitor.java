package org.example;

//Visitor类
public class Visitor extends Person {
    //游客编号
    private String memberId;

    //进入的时间
    private String entryDate;

    //默认构造函数
    public Visitor() {

    }

    //初始化变量的构造函数
    public Visitor(String name,  String gender, int age, String memberId, String entryDate) {
        super(name, gender, age);
        this.memberId = memberId;
        this.entryDate = entryDate;
    }

    // Getter、Setter 方法
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
}