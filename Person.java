package org.example;

// Person类
public abstract class Person {

    //姓名
    private String name;

    //性别
    private String gender;

    //年龄
    private int age;

    // 默认构造函数
    public Person() {

    }

    //初始化变量的构造函数
    public Person(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    // Getter、Setter 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
