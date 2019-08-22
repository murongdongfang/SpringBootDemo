package cn.itsource.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qq.connect.QQConnectException;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.PageFans;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.PageFansBean;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.javabeans.weibo.Company;
import com.qq.connect.oauth.Oauth;

import cn.itsource.model.User;
import cn.itsource.service.UserService;

@Controller
public class LoginController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping("/json")
	@ResponseBody
	// 没加返回数据格式是页面
	// json ={} => java 的map
	public Map<String, Object> json() {
		Map<String, Object>map=new HashMap<>();
		map.put("msg", "ok");// json={"msg":"ok"}
		return map;
	}

	
	
	
	

	@RequestMapping("/")
	public String index(String name, String pwd,HttpServletRequest request) {
		System.out.println(userService.queryAll().size());
		request.setAttribute("count", userService.queryAll().size()+1000);
		//  /WEB-INF/view/index.jsp     index
	//  /WEB-INF/view/user/index.jsp  user/index
		return "login";
	}

	// json
	@RequestMapping("/loginCheckAjax")
	@ResponseBody
	public Map<String, Object> loginCheckAjax(String name, String pwd) {
		Map<String, Object>map=new HashMap<>();
		
		System.out.println(name);
		System.out.println(pwd);
		List<User> list=userService.logincheck(name, pwd);
		if (list!=null && list.size()>0) {
			map.put("msg", "yes");// json={"msg":"ok"}
		} else {
			map.put("msg", "no");// json={"msg":"ok"}
		}
		return map;
	}
	
	
	@RequestMapping("/loginCheck")
	public String loginCheck(String name, String pwd,HttpServletRequest request) {

		System.out.println(name);
		System.out.println(pwd);

		if ("admin".equals(name) && "123456".equals(pwd)) {
			return "ok";
		} else {
			request.setAttribute("msg", "登录失败");
			return "login";
		}
	}

	// qq登录
	@RequestMapping("/qq")
	protected void qq(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			response.sendRedirect(new Oauth().getAuthorizeURL(request));
		} catch (QQConnectException e) {
			e.printStackTrace();
		}
	}

	// qq登录之后
	@RequestMapping("/loginAfter")
	protected String loginAfter(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		try {
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);

			String accessToken = null, openID = null;
			long tokenExpireIn = 0L;

			if (accessTokenObj.getAccessToken().equals("")) {
				// 我们的网站被CSRF攻击了或者用户取消了授权
				// 做一些数据统计工作
				System.out.print("没有获取到响应参数");
			} else {
				out.print(
						"<!DOCTYPE html><html><head><meta charset='UTF-8'><link href='css/bootstrap.min.css' rel='stylesheet'><link href='css/custom.css' rel='stylesheet'><title>QQ登录</title></head><body><div style='margin:auto' class='col-md-8'><div class='panel panel-success'><div class='panel-heading'><h3>提示</h3></div><pre class='panel-body'>");

				accessToken = accessTokenObj.getAccessToken();
				tokenExpireIn = accessTokenObj.getExpireIn();

				request.getSession().setAttribute("demo_access_token", accessToken);
				request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));

				// 利用获取到的accessToken 去获取当前用的openid -------- start
				OpenID openIDObj = new OpenID(accessToken);
				openID = openIDObj.getUserOpenID();

				out.println("欢迎你，代号为 " + openID + " 的用户!");
				request.getSession().setAttribute("demo_openid", openID);
				out.println("<a href=" + "/shuoshuoDemo.html" + " target=\"_blank\">去看看发表说说的demo吧</a>");
				// 利用获取到的accessToken 去获取当前用户的openid --------- end

				out.println(
						"<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- start </p>");
				UserInfo qzoneUserInfo = new UserInfo(accessToken, openID);
				UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();
				out.println("<br/>");
				if (userInfoBean.getRet() == 0) {
					out.println(userInfoBean.getNickname() + "<br/>");
					out.println(userInfoBean.getGender() + "<br/>");
					out.println("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
					out.println("会员 : " + userInfoBean.isVip() + "<br/>");
					out.println("黄钻会员： " + userInfoBean.isYellowYearVip() + "<br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL30() + " /><br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL50() + " /><br/>");
					out.println("<image src=" + userInfoBean.getAvatar().getAvatarURL100() + " /><br/>");
				
					// 获取用户的公司信息---------------------------end
                    System.out.println("==============1===================");
					out.print("</pre></div></div></body></html>");
					
					request.setAttribute("name", userInfoBean.getNickname());
					return "ok";
				
				} else {
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
				}
				out.println(
						"<p> end -----------------------------------利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 ---------------------------- end </p>");

				out.println(
						"<p> start ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ start <p>");
				PageFans pageFansObj = new PageFans(accessToken, openID);
				PageFansBean pageFansBean = pageFansObj.checkPageFans("97700000");
				if (pageFansBean.getRet() == 0) {
					out.println("<p>验证您" + (pageFansBean.isFans() ? "是" : "不是") + "QQ空间97700000官方认证空间的粉丝</p>");
				} else {
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + pageFansBean.getMsg());
				}
				out.println(
						"<p> end ----------------------------------- 验证当前用户是否为认证空间的粉丝------------------------------------------------ end <p>");

				out.println(
						"<p> start -----------------------------------利用获取到的accessToken,openid 去获取用户在微博的昵称等信息 ---------------------------- start </p>");
				com.qq.connect.api.weibo.UserInfo weiboUserInfo = new com.qq.connect.api.weibo.UserInfo(accessToken,
						openID);
				com.qq.connect.javabeans.weibo.UserInfoBean weiboUserInfoBean = weiboUserInfo.getUserInfo();
				if (weiboUserInfoBean.getRet() == 0) {
					// 获取用户的微博头像----------------------start
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL30() + " /><br/>");
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL50() + " /><br/>");
					out.println("<image src=" + weiboUserInfoBean.getAvatar().getAvatarURL100() + " /><br/>");
					// 获取用户的微博头像 ---------------------end

					// 获取用户的生日信息 --------------------start
					out.println("<p>尊敬的用户，你的生日是： " + weiboUserInfoBean.getBirthday().getYear() + "年"
							+ weiboUserInfoBean.getBirthday().getMonth() + "月"
							+ weiboUserInfoBean.getBirthday().getDay() + "日");
					// 获取用户的生日信息 --------------------end

					StringBuffer sb = new StringBuffer();
					sb.append("<p>所在地:" + weiboUserInfoBean.getCountryCode() + "-" + weiboUserInfoBean.getProvinceCode()
							+ "-" + weiboUserInfoBean.getCityCode() + weiboUserInfoBean.getLocation());

					// 获取用户的公司信息---------------------------start
					ArrayList<Company> companies = weiboUserInfoBean.getCompanies();
					if (companies.size() > 0) {
						// 有公司信息
						for (int i = 0, j = companies.size(); i < j; i++) {
							sb.append("<p>曾服役过的公司：公司ID-" + companies.get(i).getID() + " 名称-"
									+ companies.get(i).getCompanyName() + " 部门名称-"
									+ companies.get(i).getDepartmentName() + " 开始工作年-" + companies.get(i).getBeginYear()
									+ " 结束工作年-" + companies.get(i).getEndYear());
						}
					} else {
						// 没有公司信息
					}
				

				} else {
					System.out.println("==============2===================");
					out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + weiboUserInfoBean.getMsg());
					request.setAttribute("msg", weiboUserInfoBean.getMsg());
					return "index";
				}

			}
		} catch (QQConnectException e) {
			request.setAttribute("msg", "很抱歉，我们没能正确获取到您的信息");
			return "index";
		}
		return null;
	}
}