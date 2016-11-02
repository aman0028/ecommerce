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
<title>Online Store</title>
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
<c:choose>
   <c:when test="${cartEmpty eq true}">
    <div style='text-align:center; margin-top:10px'>
        <h2>Your shopping cart is empty.</h2>
        <h1>To buy one or more items, click 'Move to cart' next to the item.</h1>
    </div>
    <div style='text-align:center; margin-top:10px'>
       <a href="<%=request.getContextPath()%>/catalog">Back</a>
    </div> 
   </c:when>
   <c:otherwise>
     <div style='text-align:center; margin-top:10px'>
        <h2>Your shopping cart is ready.</h2>
        <h1>To buy more items, click 'Move to cart' next to the item.</h1>
     </div>
 <div style='text-align:right; margin-top:10px'>
  <a href="<%=request.getContextPath()%>/catalog">Back</a>
 </div>
 <table class="center">
    <tr>
    <th>S.No</th>
    <th>Product</th>
    <th>Product Category(Tax%)</th>
    <th>Price per product</th>
    <th>Quantity</th>
    <th>Total Price with Tax</th>
    </tr>
    <c:forEach items="${cartBillList}" var ="cartBill" varStatus="status">
      <tr>
         <td>${status.count}</td>
         <td>${cartBill.productName}</td>
         <td>${cartBill.categoryName}(${cartBill.categoryTaxPercentage}%)</td>
         <td>${cartBill.pricePerProduct}</td>
         <td>${cartBill.quantity}</td>
         <td>${cartBill.productCurrency}${cartBill.totalAmount}</td>
      </tr>
    </c:forEach>
</table>
 <div style='text-align:center; margin-top:10px'>
  	<h2> Total payable amount is ${productCurrency}${totalPayableAmount}</h2>
</div>
</c:otherwise>
</c:choose>
</div>
</body>
</html>
