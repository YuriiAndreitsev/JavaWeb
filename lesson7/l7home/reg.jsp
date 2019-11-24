<%@ page session="false" %>
<%request.setCharacterEncoding("UTF-8");%>


<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="database.DataBase"%>
<%@ page import="java.sql.*" %>
<%@include file="header.jsp" %>

<a href='log.jsp'>Login</a>
<a href='reg.jsp'>Register</a>

<%
boolean form = true;

String email = request.getParameter("email");
String password = request.getParameter("password");
String location = request.getParameter("location");
String gender = request.getParameter("gender");
String signUpButton = request.getParameter("signUpButton");
String passwordConfirmation = request.getParameter("passwordConfirmation");
String comment = request.getParameter("textarea");
String checkbox = request.getParameter("checkbox");

boolean ifError = false;
StringBuilder errorText = new StringBuilder("<font color='red'><ul>");

/*
if (email!=null){
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$");
			Matcher matcher = pattern.matcher(email);
				if (matcher.matches()==false){
					ifError = true;
					errorText.append("<li>incorrect e-mail</li>");
				}
			}

if (password!=null){
				Pattern pattern = Pattern.compile("^(?:(?=.*[a-z])(?:(?=.*[A-Z])(?=.*[\\d\\W])|(?=.*\\W)(?=.*\\d))|(?=.*\\W)(?=.*[A-Z])(?=.*\\d)).{8,20}$");
				Matcher matcher = pattern.matcher(password);
				if(matcher.matches()==false){
					ifError=true;
					errorText.append("<li>must contain 8 symb...bla bla bla</li>");
				}
			}

if (passwordConfirmation!=null&&!passwordConfirmation.equals("")){
					Pattern pattern = Pattern.compile("^((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})$");
					Matcher matcher = pattern.matcher(passwordConfirmation);
					
				if (matcher.matches()==false&&!passwordConfirmation.equals(password)){
					ifError=true;
					errorText.append("<li>didnt match with your password</li>");
				} 
			}				
			
if (location!=null){
				if (location.equals("")){
					ifError=true;
					errorText.append("<li>choose your location</li>");
				}
			}
			
			
if (checkbox!=null){
				if (!checkbox.equals("checked")){
					ifError=true;
					errorText.append("<li>dont you agree with us?</li>");
				}
			}
*/
			
if (ifError==false&&email!=null){
		DataBase db = new DataBase();
	if (db.checkEmail(email)!=true){
		db.addUser(email,password,location,gender, comment);
		out.write("</br><font color='green'>Registration complete</font>");
		form=false;
	}else {
		errorText.append("<li>SUCH EMAIL IS ALREADY TAKEN</li>");
	}
	
}		


if (form){
%>

<!--
<a href='log.jsp'>Login</a>
<a href='reg.jsp'>Register</a>
-->

<form action='' method = 'post' align = 'center'>
<table border='0'>
	
	<h1 align='center'>
			Fill in this registration form!
	</h1>
	<tr>
		<td width="500" align='right'>
			Enter your e-mail: <input type='text' name='email' value='<%=(email==null?"":email)%>'/>
		</td>
		<td width="350" align="justify" rowspan="3">
		<% 		
			out.write(""+errorText+"</font></ul>");
		%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Enter your pass: <input type='password' name='password' value='<%=(password==null?"":password)%>'/>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Confirm your pass: <input type='password' name='passwordConfirmation'/></td>
		</td>
		
	</tr>
	<tr>
		<td align='right'>
			Where are you from?: <select name='location'>
			<option value="" ></option>
			<option value="dnr" <%=("dnr".equals(location)?"selected":"")%>>DNR</option>
			<option value="lnr" <%=("lnr".equals(location)?"selected":"")%>>LNR</option>
			<option value="crimea" <%=("crimea".equals(location)?"selected":"")%>>CRIMEA</option>
								</select>
		</td>
		
	</tr>
	<tr>
		<td align='right'>
			What are you?: 	<input type='radio' name='gender' value="male" <%=("male".equals(gender)?"checked":"")%>>Male</input>
							<input type='radio' name='gender' value="female" <%=("female".equals(gender)?"checked":"")%>>Female</input>

		</td>
	</tr>
	<tr>
		<td align='right'>
			Comment: <textarea name='textarea' cols='25' rows='10'></textarea>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Have you seen those small letters?: <font color='grey' size='1'><a href="agreement.txt"> (Read this carefully) </a></br>I dont want to read, I agree with everything!</font><input type="checkbox" name='checkbox' value="checked" checked></input>
		</td>
	</tr>
	<tr>
		<td align='right'>
			<input name = "signUpButton" type='submit' value="Sign Up!">
		</td>
	</tr>
</table>
</form>




<%}


%>
<%@include file="footer.jsp" %>