package test;
// 用户测试类

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itsource.RunApp;
import cn.itsource.dao.UserDao;
import cn.itsource.model.User;
import cn.itsource.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RunApp.class)
public class User_Test {

	@Autowired
	UserDao userdao; // 引用了 userdao 数据访问层接口
	
	@Autowired
	UserService userService; // 引用了 userdao 数据访问层接口

	@Test
	public void queryAll() throws Exception {
		// System.err.println(userdao.queryAll().size());
		for (User user : userdao.queryAll()) {
			System.err.println(user.getName());
		}
	}

	

	@Test
	public void queryAll_page() throws Exception {
		// select * from t_user   limit 0,1
		PageHelper.startPage(1, 2);
		List<User>list=userdao.queryAll();
		List<User>list2=userdao.queryAll();
		System.out.println("=========="+list.size());
		System.out.println("=========="+list2.size());
	}
	
	@Test
	public void queryAll_Service() throws Exception {
		// System.err.println(userdao.queryAll().size());
		for (User user : userService.queryAll()) {
			System.err.println(user.getName());
		}
	}
	
	
	@Test
	public void PageList_Service() throws Exception {
		PageInfo<User> page=userService.pageList(1, 2);
		System.err.println("总页数"+page.getPages());
		System.err.println("总条数"+page.getTotal());
		for (User u : page.getList()) {
			System.err.println(u.getName());
		}
	}

	
	@Test
	public void queryById() throws Exception {
		User u = userdao.queryById(2);
		if (u != null) {
			System.err.println(u.getName());
		} else {
			System.err.println("id 不存在");
		}

	}

	@Test
	public void save() throws Exception {
		User user = new User();
		user.setName("kd添加");
		user.setPwd("111111");
		int result = userdao.save(user);
		if (result > 0) {
			System.err.println("添加成功");
		} else {
			System.err.println("添加失败");
		}

	}

	@Test
	public void queryALL2() throws Exception {
		// System.err.println(userdao.queryAll().size());
		for (User user : userdao.queryAll2()) {
			System.err.println(user.getName());
		}

	}
	
	
	@Test
	public void save_service() throws Exception {
		User user = new User();
		user.setName("dadasd添加");
		user.setPwd("111111");
		int result = userService.save(user);
		if (result > 0) {
			System.err.println("添加成功");
		} else {
			System.err.println("添加失败");
		}

	}
}
