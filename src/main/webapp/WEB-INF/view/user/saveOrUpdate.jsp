<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="/assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="/assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="/assets/js/echarts.min.js"></script>
<link rel="stylesheet" href="/assets/css/amazeui.min.css" />
<link rel="stylesheet" href="/assets/css/amazeui.datatables.min.css" />
<link rel="stylesheet" href="/assets/css/app.css">
<script src="/assets/js/jquery.min.js"></script>
<script src="/pack/layer/layer.js"></script>
<script src="/pack/hpUpload/hpUpload.js"></script>

</head>

<body data-type="widgets">
	<script src="/assets/js/theme.js"></script>
	<div class="am-g tpl-g">
		<!-- 头部 -->
		<header>
			<!-- logo -->
			<div class="am-fl tpl-header-logo">
				<a href="javascript:;"><img src="/assets/img/logo.png" alt=""></a>
			</div>
			<!-- 右侧内容 -->
			<div class="tpl-header-fluid">
				<!-- 侧边切换 -->
				<div class="am-fl tpl-header-switch-button am-icon-list">
					<span> </span>
				</div>
				<!-- 搜索 -->
				<div class="am-fl tpl-header-search">
					<form class="tpl-header-search-form" action="javascript:;">
						<button class="tpl-header-search-btn am-icon-search"></button>
						<input class="tpl-header-search-box" type="text"
							placeholder="搜索内容...">
					</form>
				</div>
				<!-- 其它功能-->
				<div class="am-fr tpl-header-navbar">
					<ul>
						<!-- 欢迎语 -->
						<li class="am-text-sm tpl-header-navbar-welcome"><a
							href="javascript:;">欢迎你, <span>Amaze UI</span>
						</a></li>

						<!-- 新邮件 -->
						<li class="am-dropdown tpl-dropdown" data-am-dropdown><a
							href="javascript:;"
							class="am-dropdown-toggle tpl-dropdown-toggle"
							data-am-dropdown-toggle> <i class="am-icon-envelope"></i> <span
								class="am-badge am-badge-success am-round item-feed-badge">4</span>
						</a> <!-- 弹出列表 -->
							<ul class="am-dropdown-content tpl-dropdown-content">
								<li class="tpl-dropdown-menu-messages"><a
									href="javascript:;"
									class="tpl-dropdown-menu-messages-item am-cf">
										<div class="menu-messages-ico">
											<img src="/assets/img/user04.png" alt="">
										</div>
										<div class="menu-messages-time">3小时前</div>
										<div class="menu-messages-content">
											<div class="menu-messages-content-title">
												<i class="am-icon-circle-o am-text-success"></i> <span>夕风色</span>
											</div>
											<div class="am-text-truncate">Amaze UI 的诞生，依托于 GitHub
												及其他技术社区上一些优秀的资源；Amaze UI 的成长，则离不开用户的支持。</div>
											<div class="menu-messages-content-time">2016-09-21 下午
												16:40</div>
										</div>
								</a></li>

								<li class="tpl-dropdown-menu-messages"><a
									href="javascript:;"
									class="tpl-dropdown-menu-messages-item am-cf">
										<div class="menu-messages-ico">
											<img src="/assets/img/user02.png" alt="">
										</div>
										<div class="menu-messages-time">5天前</div>
										<div class="menu-messages-content">
											<div class="menu-messages-content-title">
												<i class="am-icon-circle-o am-text-warning"></i> <span>禁言小张</span>
											</div>
											<div class="am-text-truncate">为了能最准确的传达所描述的问题，
												建议你在反馈时附上演示，方便我们理解。</div>
											<div class="menu-messages-content-time">2016-09-16 上午
												09:23</div>
										</div>
								</a></li>
								<li class="tpl-dropdown-menu-messages"><a
									href="javascript:;"
									class="tpl-dropdown-menu-messages-item am-cf"> <i
										class="am-icon-circle-o"></i> 进入列表…
								</a></li>
							</ul></li>

						<!-- 新提示 -->
						<li class="am-dropdown" data-am-dropdown><a
							href="javascript:;" class="am-dropdown-toggle"
							data-am-dropdown-toggle> <i class="am-icon-bell"></i> <span
								class="am-badge am-badge-warning am-round item-feed-badge">5</span>
						</a> <!-- 弹出列表 -->
							<ul class="am-dropdown-content tpl-dropdown-content">
								<li class="tpl-dropdown-menu-notifications"><a
									href="javascript:;"
									class="tpl-dropdown-menu-notifications-item am-cf">
										<div class="tpl-dropdown-menu-notifications-title">
											<i class="am-icon-line-chart"></i> <span> 有6笔新的销售订单</span>
										</div>
										<div class="tpl-dropdown-menu-notifications-time">12分钟前
										</div>
								</a></li>
								<li class="tpl-dropdown-menu-notifications"><a
									href="javascript:;"
									class="tpl-dropdown-menu-notifications-item am-cf">
										<div class="tpl-dropdown-menu-notifications-title">
											<i class="am-icon-star"></i> <span> 有3个来自人事部的消息</span>
										</div>
										<div class="tpl-dropdown-menu-notifications-time">30分钟前
										</div>
								</a></li>
								<li class="tpl-dropdown-menu-notifications"><a
									href="javascript:;"
									class="tpl-dropdown-menu-notifications-item am-cf">
										<div class="tpl-dropdown-menu-notifications-title">
											<i class="am-icon-folder-o"></i> <span> 上午开会记录存档</span>
										</div>
										<div class="tpl-dropdown-menu-notifications-time">1天前</div>
								</a></li>


								<li class="tpl-dropdown-menu-notifications"><a
									href="javascript:;"
									class="tpl-dropdown-menu-notifications-item am-cf"> <i
										class="am-icon-bell"></i> 进入列表…
								</a></li>
							</ul></li>

						<!-- 退出 -->
						<li class="am-text-sm"><a href="javascript:;"> <span
								class="am-icon-sign-out"></span> 退出
						</a></li>
					</ul>
				</div>
			</div>

		</header>
		<!-- 风格切换 -->
		<div class="tpl-skiner">
			<div class="tpl-skiner-toggle am-icon-cog"></div>
			<div class="tpl-skiner-content">
				<div class="tpl-skiner-content-title">选择主题</div>
				<div class="tpl-skiner-content-bar">
					<span class="skiner-color skiner-white" data-color="theme-white"></span>
					<span class="skiner-color skiner-black" data-color="theme-black"></span>
				</div>
			</div>
		</div>
		<!-- 侧边导航栏 -->
		<div class="left-sidebar">
			<!-- 用户信息 -->
			<div class="tpl-sidebar-user-panel">
				<div class="tpl-user-panel-slide-toggleable">
					<div class="tpl-user-panel-profile-picture">
						<img src="/assets/img/user04.png" alt="">
					</div>
					<span class="user-panel-logged-in-text"> <i
						class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
						禁言小张
					</span> <a href="javascript:;" class="tpl-user-panel-action-link"> <span
						class="am-icon-pencil"></span> 账号设置
					</a>
				</div>
			</div>

			<!-- 菜单 -->
			<!-- 菜单 -->
			<ul class="sidebar-nav">
				<li class="sidebar-nav-link"><a href="/user/list"
					class="active"> <i class="am-icon-home sidebar-nav-link-logo"></i>
						用户管理
				</a></li>

			</ul>
		</div>

		<!-- 内容区域 -->
		<div class="tpl-content-wrapper">



			<div class="row-content am-cf">


				<div class="row">

					<div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
						<div class="widget am-cf">
							<div class="widget-head am-cf">
								<div class="widget-title am-fl">用户操作</div>
								<div class="widget-function am-fr">
									<a href="javascript:;" class="am-icon-cog"></a>
								</div>
							</div>
							<div class="widget-body am-fr">

								<form action="/user/saveUpdateOpt" method="post" class="am-form tpl-form-line-form">

									<div style="${user.id==null?'display: none':''}" class="am-form-group">
										<label for="user-name" class="am-u-sm-3 am-form-label">编号</label>
										<div class="am-u-sm-9">
											<input readonly="readonly" value="${user.id}" name="id" type="text" class="tpl-form-input" id="user-name"
												placeholder="请输入账号">
										</div>
									</div>
									<div  class="am-form-group">    
										<label for="user-name" class="am-u-sm-3 am-form-label">头像</label>
										<div class="am-u-sm-9">
											  <img id="uploadImgUrl" width="70px" height="70px" class="am-circle"
												src="${user.headImg==null?'/assets/img/user06.png':user.headImg}" /> <a id="kdUploadSelect"
												class="am-btn am-btn-secondary" href="javascript:;">上传头像</a>
                                 <input  id="headImgUrl"  value="${user.headImg==null?'/assets/img/user06.png':user.headImg}" type="hidden"  name="headImg"  />
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-name" class="am-u-sm-3 am-form-label">账号</label>
										<div class="am-u-sm-9">
											<input  value="${user.name}"   name="name" type="text" class="tpl-form-input" id="user-name"
												placeholder="请输入账号">
										</div>
									</div>
									
									<div class="am-form-group">
										<label for="user-name" class="am-u-sm-3 am-form-label">密码</label>
										<div class= "am-u-sm-9">
											<input value="${user.pwd}"  name="pwd" type="text" class="tpl-form-input" id="user-name"
												placeholder="请输入账号">
										</div>
									</div>



									<div class="am-form-group">
										<div class="am-u-sm-9 am-u-sm-push-3">
											<button type="submit"
												class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>






			</div>
		</div>
	</div>
	</div>
	<script src="/assets/js/amazeui.min.js"></script>
	<script src="/assets/js/amazeui.datatables.min.js"></script>
	<script src="/assets/js/dataTables.responsive.min.js"></script>
	<script src="/assets/js/app.js"></script>
  <script type="text/javascript">
	// 初始化hpUpload上传组件
    $.hpUpload("/upload/uploadFile",{"path":"xxx/headImg"},function(json){
    	$('#uploadImgUrl').attr('src',"/"+json.data);
    	$('#headImgUrl').val("/"+json.data);
    	
    }); 
</script>
  
</body>

</html>