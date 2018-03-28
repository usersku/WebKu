<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
  <body>
    <form action="stus?opt=login" method="post">
			<table align="center" border="1">
				<caption>
					学员信息登录
				</caption>
				<tr>
					<td>
						帐号：
					</td>
					<td>
						<input type="text" name="name" id="userName">
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						<input type="text" name="pwd" id="userPwd">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="remember" id="remember" value="auto">
						记住密码？
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录">
						<input type="reset" value="重置">
					</td>
				</tr>

			</table>
		</form>
  </body>
</html>