<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
</div>
<div id="sidebar">
    <table border=1>
        <tr>
            <br width="252" align="left">
            <font color=white>
                <div>
                    Вы авторизировались как
                    <c:choose>
                        <c:when test="${sessionScope.user!=null}">
                            ${sessionScope.user.email} <br/>
                            <form action='./login.html' method='post'>
                                <input type='hidden' name='logout'/>
                                <input type='submit' value='logout'/>
                            </form>
                        </c:when>

                        <c:otherwise>
                            Guest
                        </c:otherwise>
                    </c:choose>
                </div>
                <br>
                <c:choose>
                    <c:when test="${sessionScope.cartSize==null}">
                        <div id="emptyCart">Ваша корзина пуста</div>
                    </c:when>
                    <c:otherwise>
                        <div>В вашей корзине товаров: <p id=footerCart>${sessionScope.cartSize}</p></div>
                    </c:otherwise>
                </c:choose>
            </font>
            </td>
        </tr>
    </table>
    <h2>Боковое меню</h2>
    <ul>
        <li><a href='./products.html?category=cognac'>Cognacs</a></li>
        <li><a href='./products.html?category=cigars'>Cigars</a></li>
        <li><a href='./products.html?category=whisky'>Whisky</a></li>
        <li><a href="./registration.html">Регистрация</a></li>
        <li><a href="./login.html">Вход</a></li>
        <li><a href="./cart.html">Корзина</a></li>
    </ul>
</div>
</div>
</div>
</div>
</div>
<div id="footer">
    <p>Copyright (c) by Бондаренко Антон</p>
</div>
<!-- end #footer -->
</body>
</html>