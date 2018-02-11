<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  
</head>
<body >
 result:
    <% 
String path=request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <c:forEach items="${productList}" var="productList">
                                          
                    ${productList.productid }
                    <p>${productList.nickname }</p>
                    <p>${productList.price }</p>
                    <p>${productList.createat }</p>
                    <p>${productList.tel }</p>
                    <p>${productList.cid }</p>
                    <p>${productList.content }</p>
                    <p>${productList.school }</p>
                  
                    
                     <img src="<%=basePath%>${productList.productUrl }" alt="0">
                      <img src="<%=basePath%>${productList.userIconUrl }" alt="0">
               
           
             </c:forEach>


</body>
</html>