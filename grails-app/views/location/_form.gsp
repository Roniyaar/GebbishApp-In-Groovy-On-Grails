<%@ page import="com.org.geb.Location" %>



<div class="fieldcontain ${hasErrors(bean: locationInstance, field: 'location', 'error')} ">
	<label for="Find location">
		<g:message code="location.location.label" default="Location" />
		
	</label>
	<g:textField name="location" value="${locationInstance?.location}"/>
	
	
	
</div>

