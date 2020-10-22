package com.wwy.test;


import com.wwy.mapper.BlogMapper;
import com.wwy.pojo.Blog;
import com.wwy.util.IDUtil;
import com.wwy.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.genId());
        blog.setTitle("Mybatis��˼�");
        blog.setAuthor("����˵");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Java��˼�");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("Spring��˼�");
        mapper.addBlog(blog);

        blog.setId(IDUtil.genId());
        blog.setTitle("΢������˼�");
        mapper.addBlog(blog);
        session.commit();
        session.close();
    }

    @Test
    public void testQueryBlogIf(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","Mybatis��˼�");
        map.put("author","����˵");
        List<Blog> blogs = mapper.queryBlogIf(map);

        System.out.println(blogs);

        session.close();
    }

    @Test
    public void testUpdateBlog(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title","��̬SQL1");
        map.put("author","�ؽ�");
        map.put("id","baccebe810344bd3884225adca0e833e");
        System.out.println(mapper.updateBlog(map));
        session.close();
    }
    @Test
    public void testQueryBlogChoose(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","Java��˼�");
        map.put("author","����˵");
        map.put("views",9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);

        System.out.println(blogs);
        session.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession session = MybatisUtils.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids",ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        System.out.println(blogs.toString());

    }
}
