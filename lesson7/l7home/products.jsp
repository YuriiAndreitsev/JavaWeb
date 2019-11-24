<%@include file="header.jsp" %>
<%@ page import="database.DataBase"%>
<%@ page import="servlet.ProductController"%>
<% 
out.write(new ProductController().getProducts());
%>
<%@include file="footer.jsp" %>