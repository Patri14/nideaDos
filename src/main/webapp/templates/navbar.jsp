
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
              
                <li class="nav-item admin">
                    <a class="btn btn-warning" href="Login2">Usuario</a>
                    	
                </li>
                <li class="nav-item admin">
                  	<c:if test ="${empty usuario}">
		      			<a class="btn btn-primary" href="login">Login</a>
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