<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        


<body>

<% 
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<form action="<%=basePath %>addProduct" method="post">
content：<input type="text" name="content">
cid：<input type="text" name="cid">
nickname：<input type="text" name="nickname">
price：<input type="text" name="price">
productUrl：<input type="text" name="productUrl">
tel：<input type="text" name="tel">
phone：<input type="text" name="phone">
userIconUrl：<input type="text" name="userIconUrl">
createat：<input type="text" name="createat">
school：<input type="text" name="school">






<!-- <br>密码：<input type="password" name="password">
<br> -->
<input type="submit" value="login">   
<input type="submit" value="register">
</form>

          
        


</body>
</html>