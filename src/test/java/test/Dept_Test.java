package test;
// 用户测试类

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itsource.RunApp;
import cn.itsource.dao.DeptDao;
import cn.itsource.dao.UserDao;
import cn.itsource.model.Dept;
import cn.itsource.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RunApp.class)
public class Dept_Test {

	@Autowired
    DeptDao deptDao;

	@Test
	public void queryAll() throws Exception {
		// System.err.println(userdao.queryAll().size());
		for (Dept dept : deptDao.selectAll()) {
			System.err.println(dept.getName());
		}
	}
	 
	
}
