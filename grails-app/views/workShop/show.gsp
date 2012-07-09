
<%@ page import="org.comgeek.cgc.WorkShop" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'workShop.label', default: 'WorkShop')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-workShop" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-workShop" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list workShop">
			
				<g:if test="${workShopInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="workShop.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${workShopInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.start}">
				<li class="fieldcontain">
					<span id="start-label" class="property-label"><g:message code="workShop.start.label" default="Start" /></span>
					
						<span class="property-value" aria-labelledby="start-label"><g:formatDate date="${workShopInstance?.start}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.end}">
				<li class="fieldcontain">
					<span id="end-label" class="property-label"><g:message code="workShop.end.label" default="End" /></span>
					
						<span class="property-value" aria-labelledby="end-label"><g:formatDate date="${workShopInstance?.end}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="property-label"><g:message code="workShop.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${workShopInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.detail}">
				<li class="fieldcontain">
					<span id="detail-label" class="property-label"><g:message code="workShop.detail.label" default="Detail" /></span>
					
						<span class="property-value" aria-labelledby="detail-label"><g:fieldValue bean="${workShopInstance}" field="detail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.owner}">
				<li class="fieldcontain">
					<span id="owner-label" class="property-label"><g:message code="workShop.owner.label" default="Owner" /></span>
					
						<span class="property-value" aria-labelledby="owner-label"><g:fieldValue bean="${workShopInstance}" field="owner"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label"><g:message code="workShop.mail.label" default="Mail" /></span>
					
						<span class="property-value" aria-labelledby="mail-label"><g:fieldValue bean="${workShopInstance}" field="mail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${workShopInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="workShop.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${workShopInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${workShopInstance?.id}" />
					<g:link class="edit" action="edit" id="${workShopInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
