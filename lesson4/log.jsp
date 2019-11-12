<%@ page import="package01.FormChecker,java.util.Date" %>
<%! private int accessCount = 0; %>
<%! private long time = 0; %>

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

        if (new FormChecker().check(login, password)) {
            message = "granted";
            color = "green";
            form = false;

        } else {
            accessCount++;
        }
        out.write("<font color='" + color + "'>Access " + message + "</font>");
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

<html xmlns="http://www.w3.org/1999/xhtml">
<a href='log.jsp'>Login</a>
<a href='reg.jsp'>Register</a>
<br/>
<br/>
<br/>
<head>
	<title></title>
	<meta charset="UTF-8" />
	<link href="style.css" rel="stylesheet" />
</head>

<body>
<center>
    <form id="loginForm" action="" method="post">

	<div class="field">
		<label>Enter your login:</label>
		<div class="input"><input type="text" name="login" value="" id="login" /></div>
	</div>

	<div class="field">
		<a href="#" id="forgot">Forgot your password?</a>
		<label>Enter your password:</label>
		<div class="input"><input type="password" name="password" value="" id="pass" /></div>
	</div>

	<div class="submit">
		<button type="submit">Enter</button>
		<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>
	</div>

</form>
</center>
</body>
</html>
<%


    }
    out.write("<br/>Wrong Try number : " + (accessCount));

    out.write("<br/>Time Left : " + penaltyTime / 1000);

%>