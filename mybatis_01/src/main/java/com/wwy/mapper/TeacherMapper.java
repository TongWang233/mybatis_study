package com.wwy.mapper;

import com.wwy.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    public Teacher getTeacher(@Param("id") int id);

    public Teacher getTeacher2(@Param("id") int id);
}
