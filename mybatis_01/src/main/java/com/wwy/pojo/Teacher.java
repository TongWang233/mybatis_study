package com.wwy.pojo;
import lombok.Data;

import java.util.List;

@Data //GET,SET,ToString���вΣ��޲ι���
public class Teacher {
    private int id;
    private String name;

    private List<Student> students;
}