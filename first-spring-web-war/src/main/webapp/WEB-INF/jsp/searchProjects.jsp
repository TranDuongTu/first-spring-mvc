<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title><spring:message code="project_search_title" /></title>
<style type="text/css">
table {
	width: 50%;
	border: 1px dotted black;
	text-align: left;
}

th {
	background-color: grey;
	font-weight: bold;
}
</style>
</head>
<body>
	<script type="text/javascript">
	<!--
		function onChangeLocale(lang) {
			var newURL = "";
			var questionMarkLocation = document.URL.indexOf("?");
			if (questionMarkLocation != -1) {
				newURL = document.URL.substring(0, questionMarkLocation);
			} else {
				newURL = document.URL;
			}

			newURL = newURL + "?locale=" + lang;

			document.location = newURL;
		}
	//-->
	</script>

	<form:form method="POST" action="/searchProjects" commandName="query">
		<table>
			<tr>
				<td><form:input path="matchingText" /></td>
				<td><input type="submit" value="<spring:message code="search"/>" /></td>
				<td style="text-align: right"><c:if test="${locale != 'en'}">
						<a href="javascript:onChangeLocale('en')">EN</a>
					</c:if> <c:if test="${locale == 'en'}">EN</c:if> <c:if
						test="${locale != 'fr'}">
						<a href="javascript:onChangeLocale('fr')">FR</a>
					</c:if> <c:if test="${locale == 'fr'}">FR</c:if></td>
			</tr>
		</table>
	</form:form>

	<table>
		<tr>
			<th><spring:message code="project_name" /></th>
			<th><spring:message code="project_leader" /></th>
			<th><spring:message code="group" /></th>
			<th><spring:message code="project_number" /></th>
		</tr>
		<c:forEach items="${projects}" var="project">
			<tr>
				<td><a href="editProject?pid=${project.id}"><c:out
							value="${project.name}" /></a></td>
				<td><c:out value="${project.leader.visa}" /></td>
				<td><c:out value="${project.group.leader.visa}" /></td>
				<td><c:out value="${project.number}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>