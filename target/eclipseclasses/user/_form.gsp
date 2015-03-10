<%@ page import="com.org.geb.User" %>



<%--<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'loaction', 'error')} ">
	<label for="loaction">
		<g:message code="user.loaction.label" default="Loaction" />
		
	</label>
	<g:textField name="loaction" value="${userInstance?.loaction}"/>
</div>

--%>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${userInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'loaction', 'error')} ">
	<label for="loaction">
		<g:message code="user.loaction.label" default="Loaction" />
		
	</label>	
	<g:select name="loaction" id="loaction" from="San Francisco,CA,USA" class="" noSelection="['null':'']" />
</div>