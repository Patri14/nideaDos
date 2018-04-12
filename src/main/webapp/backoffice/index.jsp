<%@include file="/templates/head.jsp"%>
<%@include file="/templates/navbar.jsp"%>
<%@include file="/templates/alert.jsp"%>



<h1>Backoffice</h1>
<%
//ArrayList <Material> lista = (ArrayList<Material>).getAttribute("materiales");
//en vez de esto usamo EL => Expresion Lengiage => ${}
//podemos usar cualquier expresion, si no hay expresion, pìnta la variable
%>

<ol>
<c:forEach items="${applicationScope.usuarios_conectados}" var="usuario" >
	<li class="text-info">${usuario.key} - ${usuario.value}</li>
  </c:forEach>
</ol>


<jsp:include page="/templates/footer.jsp"></jsp:include>