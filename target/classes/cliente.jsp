<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="net.tibrasil.model.Cliente"
	import="java.util.List"%>


<!DOCTYPE html>



<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="cliente">

		e-mail: <input type="text" value="" name="email" /> <input
			type="submit" value="Save">

	</form>

	<%
		List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
		for (Cliente c : lista) {
			out.print(c.getEmail() + "<br/>");
		}
	%>

</body>
</html>
