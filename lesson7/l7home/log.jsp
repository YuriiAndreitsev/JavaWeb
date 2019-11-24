<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="package01.FormChecker,java.util.Date" %>
<%! private int accessCount = 0; %>
<%! private long time = 0; %>
<%@include file="header.jsp" %>
<%@ page import="database.DataBase"%>

<a href='log.jsp'>Login</a>
<a href='reg.jsp'>Register</a>
<%
    boolean form = true;

    long penaltyTime = time + 10000 - (new Date().getTime());

    String login = request.getParameter("login");
    String password = request.getParameter("password");

    if(penaltyTime<= 0){
        form = true;
        penaltyTime=0;
        time=0;
    }else{
        form = false;
    }

    if (login != null) {

        String message = "denied";
        String color = "red";

        //if (new FormChecker().check(login, password)) {
		if (new DataBase().getUser(login,password)) {
            message = "granted";
            color = "green";
            form = false;

        } else {
            accessCount++;
        }
        out.write("</br></br><center><font color='" + color + "'>Access " + message + "</font></center>");
    }

    if (accessCount >= 3) {
        form = false;
        if (time == 0) {
            time = new Date().getTime();
        }

if(form==false){
    accessCount=0;
}

    }



    if (form) {
%>
				
    <form id="loginForm" action="" method="post" align='center'>

	<div class="field" align='center'>
		<label>Enter your login:</label>
		<div class="input"><input type="text" name="login" value="" id="login" /></div>
	</div>

	<div class="field" align='center'>
		
		<label>Enter your password:</label>	<a href="#" id="forgot"><font size = '1'>Forgot your password?</font></a>
		<div class="input"><input type="password" name="password" value="" id="pass" /></div>
	</div>

	<div class="submit" align='center'>
		<button type="submit">Enter</button>
		<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>
	</div>

	</form>
<%

    }
    //out.write("<br/>Wrong Try number : " + (accessCount));

    //out.write("<br/>Time Left : " + penaltyTime / 1000);

%>
<%@include file="footer.jsp" %>