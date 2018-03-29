<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	这是菜单页
	<br/>
	<#list menus as u>
		<p>${u.name }，${u.sort }</p>
	</#list>
</body>
</html>