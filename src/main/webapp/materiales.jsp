<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
    
<%@include file="/templates/head.jsp"%>
<%@include file="/templates/navbar.jsp"%>
<%@include file="/templates/alert.jsp"%>


<ol>
<c:forEach items="${materiales}" var="material" >
	
	
		<c:choose>
         
         <c:when test = "${material.precio >= 6 && material.precio < 25}">
           <li class="text-info">${material.nombre} - ${material.precio}</li>
         </c:when>
         
         <c:when test = "${material.precio > 26}">
            <li class="text-danger">${material.nombre} - ${material.precio}</li>
         </c:when>
         
         <c:otherwise>
           <li class="text-default">${material.nombre} - ${material.precio}</li>
         </c:otherwise>
      </c:choose>
 </c:forEach>
</ol>

<%@include file="/templates/footer.jsp"%>