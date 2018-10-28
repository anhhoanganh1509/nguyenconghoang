<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin</title>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${root}/css/style.css"/>
</head>
<body>
	<div class="login-form">
		<div class="formindex">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<a href="${pageContext.request.contextPath}/crawl" class="hvr-round-corners">Crawl</a>
				<a href="javascript:formSubmit()" class="hvr-round-corners"> Logout</a>	
				<br>
				<h2 class="text-center">${msg}</h2>				
				<form id="logoutForm" action="<c:url value='/j_spring_security_logout' />" method='POST'>					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
				<script>
					function formSubmit() {
						document.getElementById("logoutForm").submit();
					}
				</script>
			</c:if>
		</div>
	
	</div>	
		
	
</body>
</html>