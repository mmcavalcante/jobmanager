<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="author" content="CSolution"/>
	<meta name="reply-to" content="contato@caelum.com.br"/>
	<meta name="author" content="Marcio Mendes Cavalcante"/>
	<meta name="reply-to" content="marciomendescavalcante@gmail.com"/>

	<meta name="description" content="<fmt:message key="meta.description"/>"/>
	<meta name="keywords" content="sites, web, desenvolvimento, development, java, opensource"/>
	<title>JobManager</title>
	<!--  <link href="<c:url value="/mydvds.css"/>" rel="stylesheet" type="text/css" media="screen" /> -->
    <!--[if lt IE 7]>
    <script src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE7.js" type="text/javascript"></script>
    <![endif]-->
</head>
<body>
	<fieldset>
		<legend>Logo</legend>
		<h1>JobManager</h1>
	</fieldset>
	
	<fieldset>
		<legend>Menu</legend>
	   	<ul>
			<li><a href="${path }"><fmt:message key="menu.home"/></a></li>
			<c:if test="${not empty userInfo.user}">
				<li><a href="<c:url value="/sistema"/>"><fmt:message key="menu.sistema"/></a></li>
			    <li><a href="<c:url value="/users"/>"><fmt:message key="menu.usuario"/></a></li>
			    <li>${userInfo.user.name } - <a href="${path }home/logout">Logout</a></li>
			</c:if>
	    </ul>
	</fieldset>
	
	<fieldset>
		<legend>Erros</legend>
		<c:if test="${not empty errors}">
			<ul>
				<c:forEach items="${errors }" var="error">
					<li>${error.category } - ${error.message }</li>
				</c:forEach>
			</ul>
		</c:if>
	</fieldset>
	
	<fieldset>
		<legend>Mensagens</legend>
		<c:if test="${not empty notice}">
			<p>${notice }</p>
		</c:if>
	</fieldset>