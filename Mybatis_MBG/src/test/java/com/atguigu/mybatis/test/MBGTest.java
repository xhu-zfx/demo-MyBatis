package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {
    @Test
    public void testMBG(){
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            EmpMapper mapper = new SqlSessionFactoryBuilder().build(resourceAsStream).openSession(true).getMapper(EmpMapper.class);
//            查询所有数据
//            List<Emp> list=mapper.selectByExample(null);
//            list.forEach(emp -> System.out.println(emp));
//            条件查询
//            EmpExample empExample=new EmpExample();
//            empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
//            empExample.or().andDidIsNotNull();
//            List<Emp> list=mapper.selectByExample(empExample);
//            list.forEach(emp -> System.out.println(emp));

//            测试 updateByPrimaryKey 与 updateByPrimaryKeySelective 区别 : 是否修改 null字段值
//            mapper.updateByPrimaryKey(new Emp(1,"admin",22,null,"456@qq.com",3));

            mapper.updateByPrimaryKeySelective(new Emp(1,"admin",22,null,"456@qq.com",3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
