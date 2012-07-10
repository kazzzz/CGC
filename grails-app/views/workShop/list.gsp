
<%@ page import="org.comgeek.cgc.WorkShop" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'workShop.label', default: 'WorkShop')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-workShop" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-workShop" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="title" title="${message(code: 'workShop.title.label', default: 'Title')}" />
					
						<g:sortableColumn property="start" title="${message(code: 'workShop.start.label', default: 'Start')}" />
					
						<g:sortableColumn property="end" title="${message(code: 'workShop.end.label', default: 'End')}" />
					
						<g:sortableColumn property="place" title="${message(code: 'workShop.place.label', default: 'Place')}" />
					
						<g:sortableColumn property="owner" title="${message(code: 'workShop.owner.label', default: 'Owner')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${workShopInstanceList}" status="i" var="workShopInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${workShopInstance.id}">${fieldValue(bean: workShopInstance, field: "title")}</g:link></td>
					
						<td><g:formatDate date="${workShopInstance.start}" format="yyyy/MM/dd hh:mm" /></td>
					
						<td><g:formatDate date="${workShopInstance.end}" format="yyyy/MM/dd hh:mm" /></td>
					
						<td>${fieldValue(bean: workShopInstance, field: "place")}</td>
					
						<td>${fieldValue(bean: workShopInstance, field: "owner")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${workShopInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
