<%@page import="com.ipartek.formacion.nidea.controller.LoginUserController"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>


<div class="row">
	<div class="form-group row btn-volver">
		<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales">Volver</a>
	</div>
</div>
<div class="materiales_form">
	 <form action="login2" method="post">
		<h2>Formulario Usuario</h2>
		<hr>
		<div class="form-group">
			<div class="row">
				<div class="col-md-12">
					<!-- ID -->
					<div class="form-group">
						<label for="name">ID</label>
						<input type="text" id="name" name="id" class="form-control" value="">
					</div>
					<!-- NOMBRE -->
					<div class="form-group">
						<label for="email">NOMBRE</label>
						<input type="text" id="email" name="nombre" class="form-control" value="">
					</div>
				</div><!--end col-md-12 -->
				
				<!--  btn crear -->
				<div class="col-lg-12">
					<div class="form-group row">
						<input type="hidden"  value="">
						<button class="btn btn-primary" id="btn_crear">Guardar</button>
					</div>
				</div>
			</div><!--end row -->
		</div><!--end form-group -->
	 </form><!--end form -->
</div><!--end materiales_form -->

<%@include file="/templates/footer.jsp" %>