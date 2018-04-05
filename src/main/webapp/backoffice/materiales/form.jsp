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
							<input type="text" id="name" name="id" class="form-control">
						</div>
						<div class="form-group">
							<label for="email">NOMBRE</label>
							<input type="email" id="email" name="nombre" class="form-control">
						</div>
						<div class="form-group">
							<label for="subject">PRECIO</label>
							<input type="text" id="subject" name="precio" class="form-control">
						</div>
					</div>
					<div class="col-lg-12">
					<c:if test ="${material.id == -1}">
						<div class="form-group">
							<a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_GUARDAR%>" class="btn btn-primary" id="btn_crear">Crear</a>
						</div>
					</c:if>
					</div>
					<div class="col-lg-12">
					<c:if test ="${material.id > -1}">
						<div class="form-group">
						  <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_GUARDAR%>" class="btn btn-primary" id="btn_crear">
						  	Modificar</a>
						  <a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesController.OP_ELIMINAR%>" class="btn btn-primary" id="btn_crear">
						  Borrar</a>
						</div>
					</c:if>
					</div>
			</div>        	
        </div>
    </form>

</div>


<%@include file="/templates/footer.jsp"%>