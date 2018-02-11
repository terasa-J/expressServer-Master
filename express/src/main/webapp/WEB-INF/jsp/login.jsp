<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  
</head>
<body>

<% 
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <p>信息：<span>${info }</span></p>
 <p>用户名：<span>${person.tel}</span></p>
 <p>密码：<span>${person.getPassword()}</span></p> 
 <p>图标：<span><%=basePath%>${person.getUserIconUrl()}  </span></p> 
  <p>图标：<span><img  src="<%=basePath%>${person.userIconUrl}">   </span></p> 

          
         

</body>
</html>