<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesController"%>
<%@include file="/templates/head.jsp"%>
<%@include file="/templates/navbar.jsp"%>
<%@include file="/templates/alert.jsp"%>

<div class="table-wrapper">
 	<div class="table-title">
       <div class="row">
	        <div class="col-sm-6">
				<h2>Materiales Backoffice</h2>
			</div>
			<!-- buscador -->
			<form action="backoffice/materiales" method="get">
				<input type="hidden" name="op" value="<%=MaterialesController.OP_BUSQUEDA%>">
				<input type="text" name="search" required placeholder="Nombre del material">
				<input type="submit" value="buscar">
			</form>
       </div><!-- end row -->
    </div><!-- end table title -->
	<table id="tablaMateriales" class="table table-striped table-bordered table-hover" style="width:100%">
	    <thead>
	        <tr>
	        	<th>
					<span class="custom-checkbox">
						<input type="checkbox" id="selectAll">
						<label for="selectAll"></label>
					</span>
				</th>
	           <th>ID</th>
	           <th>Tipo</th>
	           <th>Precio</th>
	           <th>Detalle</th>
	        </tr>
	    </thead>
	    <tbody>
		    <c:forEach items="${materiales}" var="material" >
		        <tr>
		        	<td>
						<span class="custom-checkbox">
							<input type="checkbox" id="checkbox1" name="options[]" value="1">
							<label for="checkbox1"></label>
						</span>
					</td>
		        <c:choose>
		         	<c:when test = "${material.precio >= 6 && material.precio < 25}">
		        		<td class="text-info"> ${material.id}</td>
		          		<td class="text-info">
		          		${material.nombre}
		          		</td>
		          		<td class="text-info"> ${material.precio}</td>
			       </c:when>
			         
		       	 	<c:when test = "${material.precio > 26}">
		        		<td class="text-danger"> ${material.id}</td>
		          		<td class="text-danger"> ${material.nombre}</td>
		         		<td class="text-danger"> ${material.precio}</td>
		         	</c:when>
			         
		        	 <c:otherwise>
		          		<td class="text-default"> ${material.id}</td>
		         	  	<td class="text-default"> ${material.nombre}</td>
		           		<td class="text-default"> ${material.precio}</td>
		         	</c:otherwise>
		      	</c:choose>
		      	  <td>
                    <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_MOSTRAR_FORMULARIO%>" class="edit">
                     	<i class="fa fa-eye"></i>
                     </a>
                 </td>
		       </tr>
		 	</c:forEach>
	     </tbody>
	 </table>
 </div>


<%@include file="/templates/footer.jsp"%>

<script>
$(document).ready(function() {
    $('#tablaMateriales').DataTable({
    	 "language": {
    	        "sProcessing":    "Procesando...",
    	        "sLengthMenu":    "Mostrar _MENU_ registros",
    	        "sZeroRecords":   "No se encontraron resultados",
    	        "sEmptyTable":    "Ningún dato disponible en esta tabla",
    	        "sInfo":          "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
    	        "sInfoEmpty":     "Mostrando registros del 0 al 0 de un total de 0 registros",
    	        "sInfoFiltered":  "(filtrado de un total de _MAX_ registros)",
    	        "sInfoPostFix":   "",
    	        "sSearch":        "Buscar:",
    	        "sUrl":           "",
    	        "sInfoThousands":  ",",
    	        "sLoadingRecords": "Cargando...",
    	        "oPaginate": {
    	            "sFirst":    "Primero",
    	            "sLast":    "Último",
    	            "sNext":    "Siguiente",
    	            "sPrevious": "Anterior"
    	        },
    	        "oAria": {
    	            "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
    	            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
    	        }
    	    }
    } );
} );
</script>