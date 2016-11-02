<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.retailer.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Retail Store</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}
table.center {
    margin-left: auto;
    margin-right: auto;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(odd) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<div>
<div style='text-align:center; margin-top:10px'>
        <h1>Online Retail Store</h1>
        <h2>To buy items, click 'Move to cart' next to the item.</h2>
</div>
<c:if test="${not empty cartSize}">
    <div style='text-align:center; margin-top:10px'>Cart size: <b><c:out value="${cartSize}"/></b></div>
</c:if>
<form style='text-align:center; margin-top:10px' method="post" action="<%=request.getContextPath()%>/generate/bill">
  	      <input type="submit" value="Click to Check your orders">
</form>
 <table class="center">
    <c:forEach items="${products}" var ="product" varStatus="status">
      <tr><td>
      <a href="#">
         <b>${product.productName}</b>
      </a>
      <div><b>Price:</b> ${product.productCurrency} ${product.productPrice}</div>
      <div><b>About:</b> ${product.productShortDescription}</div>
      
      <form style='text-align:right; margin-top:10px' method="post" action="<%=request.getContextPath()%>/add/to/cart">
          <input type="hidden" name="productId" value="<c:out value="${product.productId}" escapeXml="true"/>"/>
          <select name="quantity">
         	     <option value="1">1</option>
  				 <option value="2">2</option>
  				 <option value="3">3</option>
  			     <option value="4">4</option>
  			     <option value="5">5</option>
  	      </select>
  	      <input type="submit" value="Move to cart">
      </form>
      </td></tr>
    </c:forEach>
</table>
 <form style='text-align:center; margin-top:10px' method="post" action="<%=request.getContextPath()%>/generate/bill">
  	      <input type="submit" value="Click to Check your orders">
</form>
</div>
<table>
    
</table>
</body>
</html>
