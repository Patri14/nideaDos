<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.model.MaterialDAO"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<div class="row">
	<div class="form-group row">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>
</div>
<div class="materiales_form">
	 <form action="backoffice/materiales" method="post">
		<h2>Formulario materiales</h2>
		<hr>
		<div class="form-group">
			<div class="row">
				<div class="col-md-12">
					<!-- ID -->
					<div class="form-group">
						<label for="name">ID</label>
						<input type="text" id="name" name="id" class="form-control" value="${material.id}" readonly>
					</div>
					<!-- NOMBRE -->
					<div class="form-group">
						<label for="email">NOMBRE</label>
						<input type="text" id="email" name="nombre" class="form-control" value="${material.nombre}" required>
					</div>
					<!-- PRECIO -->
					<div class="form-group">
						<label for="subject">PRECIO</label>
						<input type="text" id="subject" name="precio" class="form-control" value="${material.precio}">
					</div>
				</div><!--end col-md-12 -->
				
				<!--  btn crear -->
				<div class="col-lg-12">
				<c:if test ="${material.id == -1}">
					<div class="form-group row">
						<input type="hidden" name="op" value="<%=MaterialesController.OP_GUARDAR%>">
						<button class="btn btn-primary" id="btn_crear">Crear</button>
					</div>
				</c:if>
				</div>
					
				<!--  btn modificar y borrar -->
				<div class="col-lg-12">
				<c:if test ="${material.id > -1}">
					<div class="form-group row">
						<!--  btn modificar -->
						<div class="col-md-6">
							 <input type="hidden" name="op" value="<%=MaterialesController.OP_GUARDAR%>"> 
						  <button type="submit" class="btn btn-primary" id="btn_crear">
							Modificar</button>
						</div>
						<!--  btn borrar -->
						<div class="col-md-6">
						  <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_ELIMINAR%>&id=${material.id}" class="btn btn-warning" id="btn_crear">
						  Borrar</a>
						</div>
					  
					</div>
				</c:if>
				</div>
				<!-- Delete Modal HTML -->
				<div id="deleteEmployeeModal" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<form>
								<div class="modal-header">						
									<h4 class="modal-title">Delete Employee</h4>
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">					
									<p>Are you sure you want to delete these Records?</p>
									<p class="text-warning"><small>This action cannot be undone.</small></p>
								</div>
								<div class="modal-footer">
									<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
									<input type="submit" class="btn btn-danger" value="Delete">
								</div>
							</form>
						</div>
					</div>
				</div>
					
			</div><!--end row -->
		</div><!--end form-group -->
	 </form><!--end form -->
</div><!--end materiales_form -->

<%@include file="/templates/footer.jsp" %>