<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
</div>
<div id="sidebar">
    <table border=1>
        <tr>
            <td width="252" align="left">
                <font color=white>
                    Вы авторизировались как
                    <c:choose>

                        <c:when test="${sessionScope.user!=null}">
                            ${sessionScope.user.email} <br/>
                            <form action='./login' method='post'>
                                <input type='hidden' name='logout'/>
                                <input type='submit' value='LOGOUT'/>
                            </form>
                        </c:when>

                        <c:otherwise>
                            Guest
                        </c:otherwise>
                    </c:choose>
                    В вашей корзине 0 товаров.
                </font>
            </td>
        </tr>
    </table>
    <h2>Боковое меню</h2>
    <ul>
        <li><a href='./products?category=cognac'>Cognacs</a></li>
        <li><a href='./products?category=cigars'>Cigars</a></li>
        <li><a href='./products?category=whisky'>Whisky</a></li>
        <li><a href="./registration">Регистрация</a></li>
        <li><a href="./login">Вход</a></li>
        <li><a href="./cart">Корзина</a></li>
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