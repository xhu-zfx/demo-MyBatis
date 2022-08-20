package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageHelperTest {
/*    使用 mybatis分页插件实现分页功能
    PageHelper.startPage(2,4);
    源码
    public static <E> com.github.pagehelper.Page<E> startPage(     int pageNum,int pageSize )
    pageNum : 当前页码  , pageSize : 每页显示数据个数
    Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=0, pages=0, reasonable=null, pageSizeZero=null}[]
    PageInfo{
    pageNum=2, pageSize=4, size=4, startRow=5, endRow=8, total=9, pages=3, list=Page{count=true, pageNum=2, pageSize=4, startRow=4, endRow=8, total=9, pages=3, reasonable=false, pageSizeZero=false}[Emp{eid=5, empName='田七', age=56, sex='女', email='123@qq.com', did=3}, Emp{eid=9, empName='a', age=23, sex='男', email='123@qq.com', did=null}, Emp{eid=10, empName='a', age=23, sex='男', email='123@qq.com', did=null}, Emp{eid=11, empName='a', age=23, sex='男', email='123@qq.com', did=null}],
    prePage=1, nextPage=3,
    isFirstPage=false, isLastPage=false,
    hasPreviousPage=true, hasNextPage=true,
    navigatePages=5, navigateFirstPage=1, navigateLastPage=3, navigatepageNums=[1, 2, 3]}

*/
    @Test
    public void testPageHelper(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            EmpMapper mapper = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true).getMapper(EmpMapper.class);
//            Page<Object> page = PageHelper.startPage(2, 4);
            PageHelper.startPage(2, 4);
            List<Emp> list=mapper.selectByExample(null);
            PageInfo<Emp> page=new PageInfo<>(list,5);

//            list.forEach(emp -> System.out.println(emp));
            System.out.println(page);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
