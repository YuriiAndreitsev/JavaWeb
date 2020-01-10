<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>MyShop</title>
    <link href="style.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<script type="text/javascript" src="jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="jquery.poptrox-0.1.js"></script>
<div id="header" class="container">
    <div id="logo">
        <h1>
            <a href="#">My Spring MVC Shop </a>
        </h1>
        <p>
            я - двоечник и лентяй (<a href="http://www.freecsstemplates.org"></a>
        </p>
    </div>
    <div id="menu">
        <ul>
            <li class="current_page_item"><a href="index.html">Главная</a></li>
            <li><a href="./products.html">Товары</a></li>
            <li><a href="./registration.html">Регистрация</a></li>
            <li><a href="./login.html">Вход</a></li>
            <li><a href="./cart.html">Корзина</a></li>
        </ul>
    </div>
</div>
<!-- end #header -->
<div id="poptrox" >
    <!-- start -->
    <ul id="gallery" align = 'center'>
        <li><a href="images/remy-xo.jpg"><img
                src="images/remy-xo.jpg" width='150' height='150'
                title="Remy Martin XO. Probably the best cognac ever."
                alt=""/></a></li>
        <li><a href="images/balvenie.jpg"><img
                src="images/balvenie.jpg" width='150' height='150'
                title="Balvenie Scotch 12 y.o Tripple Cask."
                alt=""/></a></li>
        <li><a href="images/macanudo.jpg"><img
                src="images/macanudo.jpg " width='150' height='150'
                title="Macanudo Maduro Cigars. Nicaragua, Dominicana."
                alt=""/></a></li>
        <%--			<li><a href="images/img04_big.jpg"><img--%>
        <%--					src="images/balvenie.jpg"--%>
        <%--					title="Phasellus nec erat sit amet nibh pellentesque congue."--%>
        <%--					alt="" /></a></li>--%>
        <%--			<li><a href="images/img02_big.jpg"><img--%>
        <%--					src="images/img02.jpg"--%>
        <%--					title="Phasellus nec erat sit amet nibh pellentesque congue."--%>
        <%--					alt="" /></a></li>--%>
        <%--			<li><a href="images/img01_big.jpg"><img--%>
        <%--					src="images/img01.jpg"--%>
        <%--					title="Phasellus nec erat sit amet nibh pellentesque congue."--%>
        <%--					alt="" /></a></li>--%>
        <%--			<li><a href="images/img04_big.jpg"><img--%>
        <%--					src="images/img04.jpg"--%>
        <%--					title="Phasellus nec erat sit amet nibh pellentesque congue."--%>
        <%--					alt="" /></a></li>--%>
        <%--			<li><a href="images/img03_big.jpg"><img--%>
        <%--					src="images/img03.jpg"--%>
        <%--					title="Phasellus nec erat sit amet nibh pellentesque congue."--%>
        <%--					alt="" /></a></li>--%>
    </ul>
    <br class="clear"/>
    <script type="text/javascript">
        $('#gallery').poptrox();
    </script>
    <!-- end -->
</body>
</html>

<div id="page">
    <div id="bg1">
        <div id="bg2">
            <div id="bg3">
                <div id="content">