package com.wwy.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //���ѧ��������ͬһ����ʦ�������һ
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}