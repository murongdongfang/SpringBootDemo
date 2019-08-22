package cn.itsource.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.itsource.model.User;

// 用户数据访问层
public interface UserDao {
    // 查询所有  注解查询
	@Select("select * from t_user")
	List<User> queryAll();
	
	
    // 查询所有  xml查询
	//@Select("select * from t_user")
	List<User> queryAll2();
	
	@Select("select * from t_user where id=#{id}")
	User queryById(@Param("id")Integer id);
	
	@Insert("insert into t_user(name,pwd,headImg) values(#{name},#{pwd},#{headImg})")
	int save(User user);
	
	
	@Select("select * from t_user where name=#{name} and pwd=#{pwd} ")
	List<User> logincheck(@Param("name")String name,@Param("pwd")String pwd);
	
	
	// 删除
	@Delete("delete from t_user where id=#{id}")
	void  delete (@Param("id")Integer id);
	
	
	// 更新
	
	@Update("update t_user set name=#{name},pwd=#{pwd},headImg=#{headImg} where id=#{id}")
	int  update(User user);
	
	
}
