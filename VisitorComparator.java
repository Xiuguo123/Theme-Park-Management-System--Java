package org.example;

import java.util.Comparator;

//自定义VisitorComparator实现Comparator接口
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 按年龄比较，如果年龄相同，则按名字字母比较
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());//（ageCompare<0，v1年龄小于v2。ageCompare=0，v1年龄等于v2。ageCompare>0，v1年龄大于v2）
        // 如果年龄不相等，则返回年龄的比较结果
        if (ageCompare != 0) {
            return ageCompare;
        } else {//年龄相等，则返回比较名字的结果
            return v1.getName().compareTo(v2.getName());
        }
    }
}
