<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>


<%
boolean form = true;
String email = request.getParameter("email");
String signUpButton = request.getParameter("signUpButton");


String password = request.getParameter("password");
String passwordConfirmation = request.getParameter("passwordConfirmation");
String gender = request.getParameter("gender");
String textarea = request.getParameter("textarea");
String checkbox = request.getParameter("checkbox");

if (form){
%>

<html>
<a href='log.jsp'>Login</a>
<a href='reg.jsp'>Register</a>
<body>
<center>
<form action=''>
<table border='0'>
	
	<h1 align='center'>
			Fill in this registration form!
	</h1>
	<tr>
		<td align='right'>
			Enter your e-mail: <input type='text' name='email'/>
		</td>
		<td>
		<% 	if (email!=null){
			Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$");
			Matcher matcher = pattern.matcher(email);
				if (matcher.matches()==true){
					out.write("correct"); 
				} else{
					out.write("error");
				}
			}	
			
		%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Enter your pass: <input type='password' name='password'/>
		</td>
		<td>
		<%
			if (password!=null){
				Pattern pattern = Pattern.compile("^((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,20})$");
				Matcher matcher = pattern.matcher(password);
				if(matcher.matches()==true){
					out.write("correct");
				}else{
					out.write("error");
				}
			}
			%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Confirm your pass: <input type='password' name='passwordConfirmation'/></td>
		</td>
		<td>
			<% 	if (passwordConfirmation!=null){
		
				if (passwordConfirmation.equals(password)){
					out.write("correct"); 
				} else{
					out.write("error");
				}
			}	
			
		%>
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
		<td>
		<%
			if (!location.equals("")){
				out.write("bad for you :(");
			}
			%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			What are you?: 	<input type='radio' name='gender' value="male">Male</input>
							<input type='radio' name='gender' value="female">Female</input>
		</td>
		<td>
		<%
			if(gender!=null){
				//if(gender.equals("")){
					out.write("wrong!");
				//}
			}
			%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Comment: <textarea name='textarea' cols='25' rows='10'>If you like this reg form - write us: @myTeacherIsDenis</textarea>
		</td>
		<td>
			
		</td>
	</tr>
	<tr>
		<td align='right'>
			Have you seen those small letters?: <font color='grey' size='1'><a href="agreement.txt"> (Read this carefully) </a>I dont want to read, I agree with everything!</font><input type="checkbox" name='checkbox'></input>
		</td>
		<td>
			
		</td>
	</tr>
	<tr>
		<td align='right'>
			<input type='submit' value="Sign Up!"></td>
		<td>
			
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>
<%}
/*if (signUpButton!=null){
	if (signUpButton.equals("Sign Up!")){
		out.write("the button was pressed");
	}
}*/
%>
