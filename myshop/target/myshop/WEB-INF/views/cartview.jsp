<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@include file="../../includes/header.jsp" %>

<a href='./cart'>Cart: <p id="cart">${sessionScope.cartSize}</p></a>

<%--<a href='./products?category=cognac'>Cognacs</a> / <a href='./products?category=cigars'>Cigars</a> / <a href='./products?category=whisky'>Whisky</a>--%>
<!--<a href='./products?category=soft'>SOFT</a>--<a
href='./products?category=strong'>STRONG</a> -->


<c:forEach var="product" items="${sessionScope.productList}">
    <table border='1'>
        <tr>
            <td>Id</td>
            <td>${product.key.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${product.key.name}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td>${product.key.description}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td>${product.key.price}</td>
        </tr>
        <tr>
            <td>Pic</td>
            <td><img src='./images/${product.key.image}' width='100'
                     height='100'/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                QNT: ${product.value}
            </td>
        </tr>
    </table>
    <hr>
</c:forEach>

<%@include file="../../includes/footer.jsp" %>