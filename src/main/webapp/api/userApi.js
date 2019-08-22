/**
 * 用户操作api
 */

// json {}
var userApi = {
	// 获取用户列表数据
	"ajaxList" : function(pageNum) {
		var url = "/user/ajaxPageList";
		// 开启加载层
		layer.load();
		$
				.post(
						url,
						{"pageNum":pageNum},
						function(json) {
							console.log(json);
							// tbody
							var tb = "";
							// foreach i
							if(json.data.list.length>0){
								$
								.each(
										json.data.list,
										function(index, item) {
											var tr = ' <tr class="gradeX">'
													+ '                                                <td>'
													+ item.id
													+ '</td>'
													+ '                                                <td> <img class="am-circle" style="width:70px;height:70px" src="'
													+ item.headImg
													+ '" /></td>'
													+ '                                                <td>'
													+ item.name
													+ '</td>'
													+ '                                                <td>'
													+ item.pwd
													+ '</td>'
													+ '                                                <td>'
													+ '                                                    <div class="tpl-table-black-operation">'
													+ '                                                        <a val="'
													+ item.id
													+ '" class="updateBtn" href="javascript:;">'
													+ '                                                            <i class="am-icon-pencil"></i> 编辑'
													+ '                                                        </a>'
													+ '                                                        <a  val="'
													+ item.id
													+ '"  href="javascript:;" class="tpl-table-black-operation-del deleteBtn">'
													+ '                                                            <i class="am-icon-trash"></i> 删除'
													+ '                                                        </a>'
													+ '                                                    </div>'
													+ '                                                </td>'
													+ '                                            </tr>';
											console.log(item)
											tb += tr;
										})

						      $("#tb").html(tb)
							}else{
								//无数据样式
								var table_noData='<div class="am-u-sm-4 am-u-sm-offset-5">' +
								'<span class="">暂无数据</span>' +
								'</div>';
								$("#table").after(table_noData);

							}
							
							// 关闭加载层
							layer.closeAll('loading');
							
							 // 初始化 分页组件
							   var pagination = new Pagination({
							   	  wrap: $('.am-pagination'), // 存放分页内容的容器
						     	  count:json.data.pages||1, // 总页数
							   	  current: json.data.pageNum||1, // 当前的页数（默认为1）
							   	  prevText: '上一页', // prev 按钮的文本内容
							   	  nextText: '下一页', // next 按钮的文本内容
							   	  callback: function(pageNum) { // 每一个页数按钮的回调事件
							   		  
							   		userApi.ajaxList(pageNum);
							   	  }
							   	});

							
						})

	},
	initEvent : function() {

		// 动态元素 =》 通过ajax 后来添加到 页面数据 绑定不上
		// $(".updateBtn") -> $(document).on('click',".updateBtn",function(){
		/*
		 * $(".updateBtn").click(function(){ alert(1) });
		 */
		// 删除按钮事件绑定
		$(document).on('click', ".deleteBtn", function() {
			// 通过ajax 删除方法
			var url = "/user/delete";
			// $.post(url,{"id"})
			var id = $(this).attr('val');
			var _this = this;
			$.post("/user/delete", {
				"id" : id
			}, function(json) {
				if (json.code == 200) {
					alert(json.msg)
					$(_this).parents("tr").remove();
				} else {
					alert("删除失败")
				}

			})

		});
		
		
		// 新增按钮事件绑定
		$(document).on('click', "#saveBtn", function() {
			location.href='/user/saveOrUpdate'
		});
		
		// 编辑按钮事件绑定
		$(document).on('click', ".updateBtn", function() {
			var id = $(this).attr('val');
			location.href='/user/saveOrUpdate?id='+id;  
		});

	}

}
