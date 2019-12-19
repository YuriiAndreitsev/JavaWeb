<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@include file="../../includes/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>Sing Up</title>
<body>
<div>
	<a href="./login" about="Sign In">Sign In</a><br>
</div>


<c:choose>

    <c:when test="${regComplete==null}">

        <form action='./registration' method='post' align='center'>
            <h1 align='center'>
                Fill in this registration form!
            </h1>
            <table>


                <tr>
                    <td width="500" align='right'>
                        Enter your e-mail: <input type='text' name='email' value='${request.email}'/>
                    </td>
                    <td width="350" align="justify" rowspan="3">

                            ${errorObj}</font></ul>

                    </td>
                </tr>
                <tr>
                    <td align='right'>
                        Enter your pass: <input type='password' name='password' value='${request.password}'/>
                    </td>
                </tr>
                <tr>
                    <td align='right'>
                        Confirm your pass: <input type='password' name='passwordConfirmation'/>
                    </td>

                </tr>
                <tr>
                    <td align='right'>
                        Where are you from?: <select name='location'>
                        <option value=""></option>
                        <option value="dnr">DNR</option>
                        <option value="lnr">LNR</option>
                        <option value="crimea">CRIMEA</option>
                    </select>
                    </td>

                </tr>
                <tr>
                    <td align='right'>
                        What are you?: <input type='radio' name='gender' value="male">Male</input>
                        <input type='radio' name='gender' value="female">Female</input>

                    </td>
                </tr>
                <tr>
                    <td align='right'>
                        Comment: <textarea name='comment' cols='25' rows='10'></textarea>
                    </td>
                </tr>
                <tr>
                    <td align='right'>
                        Have you seen those small letters?: <font color='grey' size='1'><a href="agreement.txt"> (Read
                        this carefully) </a></br>I dont want to read, I agree with everything!</font><input
                            type="checkbox" name='checkbox' value="checked" checked></input>
                    </td>
                </tr>
                <tr>
                    <td align='right'>
                        <input name="signUpButton" type='submit' value="Sign Up!">
                    </td>
                </tr>
            </table>
        </form>
    </c:when>
</c:choose>

${regComplete}

</body>

<%@include file="../../includes/footer.jsp" %>