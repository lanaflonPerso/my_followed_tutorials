package org.xman.mybatis;

import com.wefine.mybatis.entity.Dept;
import com.wefine.mybatis.entity.Employee;
import com.wefine.mybatis.mapper.DeptMapper;
import com.wefine.mybatis.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration(
        locations = {"classpath*:applicationContext.xml"}
)})
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper mapper;

    @Test
    public void test01FindAll() throws Exception {
        List<Employee> list = mapper.findAll();

        System.out.println(list);
    }

}
