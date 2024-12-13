package org.example;

//Employee类
public class Employee extends Person {

    //员工编号
    private String employeeId;

    //工作职务
    private String workPosition;

    // 默认构造函数
    public Employee() {

    }

    //初始化变量的构造函数
    public Employee(String name, String gender,int age, String employeeId, String workPosition) {
        super(name, gender, age);
        this.employeeId = employeeId;
        this.workPosition = workPosition;
    }

    // Getter、Setter 方法
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getWorkPosition() {
        return workPosition;
    }
    public void setWorkPosition(String position) {
        this.workPosition = position;
    }
}
