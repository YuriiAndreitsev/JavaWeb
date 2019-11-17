<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="database.DataBase" %>

<%
boolean form = true;

String email = request.getParameter("email");
String password = request.getParameter("password");
String location = request.getParameter("location");
String gender = request.getParameter("gender");
String signUpButton = request.getParameter("signUpButton");
String passwordConfirmation = request.getParameter("passwordConfirmation");
String textarea = request.getParameter("textarea");
String checkbox = request.getParameter("checkbox");
//String userInfo = "INSERT INTO users(email,password,location,gender) VALUES('"+email+"','"+password+"','"+location+"','"+gender+"');";
//String[] userInfo = new String[]{"INSERT INTO users(email,password,location,gender) VALUES('"+email+"','"+password+"','"+location+"','"+gender+"');"};



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
/*
if (ifError==false&&email!=null){
	
	String[] userInfo = new String[]{"INSERT INTO users(email,password,location,gender) VALUES('"+email+"','"+password+"','"+location+"','"+gender+"');"};

	DataBase db = new DataBase();
	db.main(userInfo);
	
	//out.write(userInfo);
}		
*/
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
		<td width="500" align='right'>
			Enter your e-mail: <input type='text' name='email'/>
		</td>
		<td width="350" align="justify" rowspan="3">
		<% 		
			out.write(""+errorText+"</font></ul>");
		%>
		</td>
	</tr>
	<tr>
		<td align='right'>
			Enter your pass: <input type='password' name='password'/>
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
			<option value=""></option>
			<option value="dnr">DNR</option>
			<option value="lnr">LNR</option>
			<option value="crimea">CRIMEA</option>
								</select>
		</td>
		
	</tr>
	<tr>
		<td align='right'>
			What are you?: 	<input type='radio' name='gender' value="male" checked="checked">Male</input>
							<input type='radio' name='gender' value="female">Female</input>

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
</center>
</body>
</html>
<%}
if (ifError==false&&email!=null){
	
	String[] userInfo = new String[]{ "INSERT INTO users(email,password,location,gender) VALUES('"+email+"','"+password+"','"+location+"','"+gender+"');"};
		
	new DataBase().main(userInfo);
	out.write(userInfo[0]);
}		


%>
