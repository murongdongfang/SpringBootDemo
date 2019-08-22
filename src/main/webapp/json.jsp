<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">

var json={"name":"kd","age":18,"like":["c","t","r","l"],"obj":{"name":"kd"}}; // json 对象

console.log(json.name)  // new map ()  put() 
console.log(json.age)
console.log(json.like[0])
console.log(json.obj.name)

var jsonStr=JSON.stringify(json);
var json= JSON.parse(jsonStr) 
console.log(jsonStr)
console.log(json)
var json='{}'; // json 字符串

// JSON.parse() 

</script>

</body>
</html>