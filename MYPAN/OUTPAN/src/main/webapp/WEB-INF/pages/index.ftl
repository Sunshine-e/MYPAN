<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	这是首页
	<br/>
	contextPath：${contextPath }
	<#list user as u>
		<p>${u.username }，${u.gender }，${u.sign }</p>
	</#list>
</body>
</html>