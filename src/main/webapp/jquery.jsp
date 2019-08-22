<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="/assets/js/jquery.min.js"></script>
<body>
<h1>如果获取用户输入的值</h1>
num1 <input id="n1"   />
num2 <input id="n2"   />
<button id="btn">获取</button>
<h1>结果:<span  id="result"></span></h1>
<h1 >历史:
<div  class="content">

</div>
</h1>
<script type="text/javascript">

$("#btn").click(function(){

	var n1=parseInt( $("#n1").val());
	var n2=parseInt( $("#n2").val());
	var result=n1+n2;
	$("#result").html(result)
	if(result>100){
		$("#result").attr("style","color:green")
	}else{
		$("#result").attr("style","color:red")
	}
	
	$(".content").append("<div>"+n1+"+"+n2+"="+result+"</div>")
	console.log(n1+n2)
})

// each

var data=[1,3,8]

$.each(data,function(index,item){
	console.log("==========")
	console.log(index)
	console.log(item)
	
})



</script>


</body>
</html>