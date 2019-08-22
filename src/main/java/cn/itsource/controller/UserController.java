package cn.itsource.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itsource.model.User;
import cn.itsource.service.UserService;
// 用户管理控制类
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 列表页
	@RequestMapping("/list")
	public String list() {
		return "user/list"; 
	}
	
	// 保存页
	@RequestMapping("/save")
	public String save() {
		return "user/save";
	}
	
	// 修改页
	@RequestMapping("/update")
	public String update(Integer id,HttpServletRequest request) {
		User user=userService.queryById(id);
		request.setAttribute("user", user);
		return "user/update";
	}
	
	
	// 保存和修改页共页面
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Integer id,HttpServletRequest request) {
		if(id!=null){
			User user=userService.queryById(id);
			request.setAttribute("user", user);
		}
		
		return "user/saveOrUpdate";
	}
	
	// 共操作
	@RequestMapping("/saveUpdateOpt")
	public String saveUpdateOpt(User user) {
		if(user.getId()!=null){
			userService.update(user);
			}else{
				userService.save(user);
			}
		
		return "redirect:/user/list";
	}
	
	
	
	// 保存操作
	@RequestMapping("/saveOpt")
	public String saveOpt(User user) {
		userService.save(user);
		// redirect 重定向到列表页
		return "redirect:/user/list";
	}
	
	// 修改更新操作
	@RequestMapping("/updateOpt")
	public String updateOpt(User user) {
		
		userService.update(user);
		return "redirect:/user/list";
	}
	
	
	// 使用分页ajax获取列表数据
	@ResponseBody
	@RequestMapping("/ajaxPageList")
	public Map<String, Object> ajaxPageList(Integer pageNum,Integer pageSize) {
		if(pageNum==null){
			pageNum=1;
		}
		if(pageSize==null){
			pageSize=10;
		}
		// json -> map
		Map<String, Object>map=new HashMap<>();
		map.put("data", userService.pageList(pageNum, pageSize));// json={"msg":"ok"}
		return map;
	}
	
	
	
	// 使用ajax获取列表数据
	@ResponseBody
	@RequestMapping("/ajaxList")
	public Map<String, Object> ajaxList() {
		// json -> map
		Map<String, Object>map=new HashMap<>();
		map.put("data", userService.queryAll());// json={"msg":"ok"}
		return map;
	}
	

	// 使用ajax获取列表数据
	@ResponseBody
	@RequestMapping("/delete")
	public Map<String, Object> delete(Integer id) {
		System.out.println(id);
		userService.delete(id);
		Map<String, Object>map=new HashMap<>();
		map.put("msg", "删除成功");// json={"msg":"ok"}
		map.put("code", 200);
		return map;
	}
	
}
