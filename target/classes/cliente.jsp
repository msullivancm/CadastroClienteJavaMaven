<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="net.tibrasil.model.Cliente"
	import="java.util.List"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function confirma(pi) {
		if (window.confirm("Confirma Exclusão?")) {
			location.href = "cliente?i=" + pi;
		}
	}
</script>

</head>
<body>

	<div>
		<%
			Object msg = request.getAttribute("msg");
			if (msg != null) {
				String msgString = (String) msg;
				out.print(msgString);
			}
		%>
	</div>

	<form method="post" action="cliente">

		e-mail: <input type="text" value="" name="email" /> <input
			type="submit" value="Save">

	</form>

	<%
		List<Cliente> lista = (List<Cliente>) request.getAttribute("lista");
		int i = 0;
		for (Cliente c : lista) {
			out.print(c.getEmail() + "<a href='javascript:confirma("+ i +")'> excluir </a>" + "<br/>");
			i++;
		}
	%>

</body>
</html>
