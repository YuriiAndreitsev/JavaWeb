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
<br/>
<br/>
<br/>
<center>
    <form action=''>
        <table border='0'>
            <tr>
                <td>Login:</td>
                <td><input type='text' name='login'/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='text' name='password'/></td>
            </tr>
            <tr>
                <td></td>
                <td align='right'><input type='submit' value='SEND'/></td>
            </tr>
        </table>
    </form>
</center>

<%


    }
    out.write("<br/>Wrong Try number : " + (accessCount));

    out.write("<br/>Time Left : " + penaltyTime / 1000);

%>