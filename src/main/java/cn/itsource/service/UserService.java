package cn.itsource.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.pagehelper.PageInfo;

import cn.itsource.model.User;

public interface UserService {
    // 查询所有  注解查询
	List<User> queryAll();
	
	
    // 分页查询所有  注解查询
	PageInfo<User> pageList(Integer pageNum,Integer pageSize);
	
	
	// 保存
	int save(User user);
	
    // 查询登陆	
	List<User> logincheck(String name,String pwd);

	// 删除
	void  delete (Integer id);
	
	// 根据id查询
	User queryById(Integer id);
	
	
	//更新
	int  update(User user);
}
