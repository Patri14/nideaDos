<%@page import="com.ipartek.formacion.nidea.controller.loginUserController"%> 
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>



<form  id="msform" action="login-user" method="post">

  <fieldset>
    <h2 class="form-title">Crear cuenta</h2>
    
    <input type="text" name="nombre" placeholder="Nombre" />
<!--<input type="text" name="id" placeholder="Id" /> -->
    <input type="password" name="psw" placeholder="Contraseña" />
    
   <button class="next action-button">Guardar</button>
	
  </fieldset>
  
</form>

<%@include file="/templates/footer.jsp" %>