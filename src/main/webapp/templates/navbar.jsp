
<div id="app" class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-faded">
        <a href="index.jsp">
	  		<img src="img/logo.png" class="logo" alt="Logo Nidea">
	  	</a>	
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div id="navbarNavDropdown" class="navbar-collapse collapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="generar-mesa">Mesa</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="calculadora">Calculadora</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="materiales">Materiales</a>
                </li>
                
               
            </ul>
            <ul class="navbar-nav">
              
<!--<li class="nav-item admin"> -->
<!--  <a class="btn btn-warning" href="Login2">Usuario</a> -->
                    
                    <!-- drop down login usuario -->
                    <li class="nav-item dropdown">
                    <a href="#" class="dropdown-toggle btn btn-warning" data-toggle="dropdown">
                       <i class="fa fa-user"></i>
                        <strong>Usuario</strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p class="text-left"><strong>Nombre</strong></p>
                                        <p class="text-left small">id</p>
                                        <p class="text-left">
                                            <a href="Login2" class="btn btn-primary btn-block btn-sm">Registrarse</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p>
                                            <a href="#" class="btn btn-danger btn-block">Cerrar Sesion</a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </li>
                     </ul>
                     <!-- fin drop down login usuario -->	
                </li>
                <li class="nav-item">
                  	<c:if test ="${empty usuario}">
		      			<a class="btn btn-primary" href="login">Admin</a>
		     		</c:if>
     
			     	<c:if test ="${!empty usuario}">
			     		 <a class="p-2 text-dark" href="backoffice/materiales"> Materiales</a>   
			     		<span class="badge badge-secondary">Admin</span>
			      		<a class="btn btn-outline-danger" href="logout">Logout</a>
			       </c:if>
                </li>
            </ul>
        </div>
    </nav>
</div>

    
    <div class="container">