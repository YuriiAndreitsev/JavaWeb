<%
	int size = Integer.parseInt(request.getParameter("size"));
	String height = (request.getParameter("height"));
	String width = (request.getParameter("width"));
	String cellSize = " height='"+height+"' width= '"+width+"' ";
	String[][] table = new String[size][size];
	
	if(size > 0 && Integer.parseInt(height) > 0 && Integer.parseInt(width) > 0){	
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {
			table[i][j] = ""+i+":"+j;
		}
	}
		
	
	out.write("<h1 align ='center'><font color='black'>New Table</font></h1>");
	out.write("<table align = 'center' border = '1'>");
	
	for (int i = 0; i < size; i++) {
		out.write("<tr>");
		for (int j = 0; j < size; j++) {
			if (i == j) {
				out.write("<td bgcolor = 'blue' align ='center'"+cellSize+"</td>"+table[i][j]);
				//out.write("<td bgcolor = 'blue' align ='center'"+cellSize+" "+table[i][j]+"</td>" );
				//out.write(""+table[i][j]);
			}else if ((i% 3 == 0 && i!= 0) || (j% 3 == 0 && j != 0)){
				out.write("<td bgcolor = 'yellow' align ='center'"+cellSize+"</td>"+table[i][j] );
			}else {
				out.write("<td bgcolor = 'white' align ='center'"+cellSize+"</td>"+table[i][j] );
			}
		}
		out.write("</tr>");
	} 
	out.write("</table>");
	} else {
		out.write("<font size='24' color = 'red'> Illegal Parameters! </font></h1>");
	}	
%>
