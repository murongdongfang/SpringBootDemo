package cn.itsource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itsource.dao.UserDao;
import cn.itsource.model.User;
import cn.itsource.service.UserService;
@Service  // 代表注入到spring容器里面  到时候  controller 引用这个类的
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public PageInfo<User> pageList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<User> list=userDao.queryAll();
		return new PageInfo<>(list);
	}

	@Override
	@Transactional
	public int save(User user) {
		int result=userDao.save(user);
		//int i=1/0;
		return result;
	}

	@Override
	public List<User> logincheck(String name, String pwd) {
		return userDao.logincheck(name, pwd);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

	@Override
	public User queryById(Integer id) {
		return userDao.queryById(id);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

}
