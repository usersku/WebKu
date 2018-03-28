<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
  	当前用户为：      <br>
    <c:forEach var="stus" items="${list }">
    	${stus.id }&nbsp;&nbsp;&nbsp;&nbsp;
    	${stus.name }&nbsp;&nbsp;&nbsp;&nbsp;
    	${stus.pwd }&nbsp;&nbsp;&nbsp;&nbsp;
    	${stus.age }&nbsp;&nbsp;&nbsp;&nbsp;
    	${stus.address }&nbsp;&nbsp;&nbsp;&nbsp;<br>
    </c:forEach>
  </body>
</html>
