
<%@ include file="../../../header.jsp" %> 

<form action="<c:url value="/home/login"/>" name="loginForm" method="post">
	<fieldset>
		<legend>Login</legend>
		<label for="login"><fmt:message key="login.usuario" /></label>
		<input type="text" name="login" id="login" />	
		<label for="senha"><fmt:message key="login.senha" /></label>
		<input type="password" name="password" id="password"/>
		<button type="submit" id="submit"><fmt:message key="login.enviar"/></button>
	</fieldset>
</form>

<form action="<c:url value="/users" />" name="registerForm" method="post">
	<fieldset>
		<legend>Cadastrar Usuário</legend>
		<label for="user.name"><fmt:message key="login.nome" /></label>
		<input type="text" name="user.name" value="${user.name }"/>
		<label for="user.login"><fmt:message key="login.usuario" /></label>
		<input type="text" name="user.login" value="${user.login }"/>
		<label for="user.password"><fmt:message key="login.senha" /></label>
		<input type="password" name="user.password" value="${user.password }"/>
		<button type="submit" id="user.submit"><fmt:message key="login.enviar"/></button>
	</fieldset>
</form>

<%@ include file="../../../footer.jsp" %> 