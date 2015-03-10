
<%@ page import="com.org.geb.Location" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'location.label', default: 'Location')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-location" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>				
			</ul>
		</div>
		<g:hiddenField name="location" value="${location}" />
		<div id="list-location" class="content scaffold-list" role="main">
			<h1>Neighborhood List</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
						
						<td style="color: #48802C; background-color: rgb(229, 249, 178);">${locationInstanceCount} Neighborhoods match for ${location }</td>						
					
					</tr>
				</thead>
				<tbody>
				
				<g:each in="${locationInstanceList}" status="i" var="locationInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><a href="${locationInstance.url}">${locationInstance.location}</a></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate  total="${locationInstanceCount}" params="[location:params.location]"/>
			</div>
		</div>
	</body>
</html>
