<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@include file="/templates/head.jsp"%>
<%@include file="/templates/navbar.jsp"%>
<%@include file="/templates/alert.jsp"%>

${material}
<div class="materiales_form">
    <form action="" method="post">
		<h2>Formulario materiales</h2>
		<hr>
        <div class="form-group">
			<div class="row">
					<div class="col-lg-12">
						<div class="form-group">
							<label for="name">ID</label>
							<input type="text" id="name" name="id" class="form-control" value="${material.id}">
						</div>
						<div class="form-group">
							<label for="email">NOMBRE</label>
							<input type="text" id="email" name="nombre" class="form-control" value="${material.nombre}">
						</div>
						<div class="form-group">
							<label for="subject">PRECIO</label>
							<input type="text" id="subject" name="precio" class="form-control" value="${material.precio}">
						</div>
					</div>
					<!--  btn crear -->
					<div class="col-lg-12">
					<c:if test ="${material.id == -1}">
						<div class="form-group row">
							<input type="hidden" value="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_GUARDAR%>">
							<button class="btn btn-primary" id="btn_crear">Crear</button>
						</div>
					</c:if>
					</div>
					
					<!--  btn modificar y borrar -->
					<div class="col-lg-12">
					<c:if test ="${material.id > -1}">
						<div class="form-group row">
						
							<div class="col-md-6">
								 <input type="hidden" name="op" value="<%=MaterialesController.OP_GUARDAR%>"> 
							  <button type="submit" class="btn btn-primary" id="btn_crear">
							  	Modificar</button>
						  	</div>
						  	
						  	<div class="col-md-6">
							  <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_ELIMINAR%>" class="btn btn-warning" id="btn_crear">
							  Borrar</a>
						  </div>
						</div>
					</c:if>
					</div>
			</div>        	
        </div>
    </form>

</div>


<%@include file="/templates/footer.jsp"%>