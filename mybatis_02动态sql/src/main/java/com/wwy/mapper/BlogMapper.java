package com.wwy.mapper;

import com.wwy.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map map);

    int updateBlog(Map map);
//��ʱ�����ǲ����õ����еĲ�ѯ������ֻ��ѡ�����е�һ������ѯ������һ�����㼴�ɣ�ʹ�� choose ��ǩ���Խ���������⣬������ Java �� switch ���
    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
