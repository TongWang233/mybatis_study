package test;


import com.wwy.mapper.StudentMapper;
import com.wwy.mapper.TeacherMapper;
import com.wwy.mapper.UserMapper;
import com.wwy.pojo.Student;
import com.wwy.pojo.Teacher;
import com.wwy.pojo.User;
import com.wwy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    @Test
    public void testFindAllUser() throws Exception {
        try {
            SqlSession session = MybatisUtils.getSession();
            UserMapper userMapper = session.getMapper( UserMapper.class);
            List<User> list  = userMapper.findAllUser();
            for(User user:list) {
                System.out.println(user);
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectUserById() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectUserById(1);
        System.out.println("通过id查找的用户"+user);
        session.close();
    }

    @Test
    public void testAddUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(null, "秦疆", "男","广西");
       int result =  mapper.addUser(user);
        session.commit();
        System.out.println(result);

    }

    @Test
    public void testGetStudents(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }

    @Test
    public void testGetStudents2(){
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> students = mapper.getStudents2();

        for (Student student : students){
            System.out.println(
                    "学生名:"+ student.getName()
                            +"\t老师:"+student.getTeacher().getName());
        }
    }
    @Test
    public void testGetTeacher(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher.getName());
        for(Student student:teacher.getStudents()){
            System.out.println(student.toString());
        }
    }
    @Test
    public void testGetTeacher2(){
        SqlSession session = MybatisUtils.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher.getName());
        System.out.println(teacher.getStudents());
    }



}
