<%@ page import="org.comgeek.cgc.WorkShop" %>



<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="workShop.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="64" required="" value="${workShopInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'start', 'error')} required">
	<label for="start">
		<g:message code="workShop.start.label" default="Start" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="start" precision="minute" value="${workShopInstance?.start}" relativeYears="[-1..3]" />
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'end', 'error')} required">
	<label for="end">
		<g:message code="workShop.end.label" default="End" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="end" precision="minute" value="${workShopInstance?.end}" relativeYears="[-1..3]" />
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'place', 'error')} ">
	<label for="place">
		<g:message code="workShop.place.label" default="Place" />
		
	</label>
	<g:textField name="place" maxlength="64" value="${workShopInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'detail', 'error')} ">
	<label for="detail">
		<g:message code="workShop.detail.label" default="Detail" />
		
	</label>
	<g:textArea name="detail" cols="40" rows="5" maxlength="256" value="${workShopInstance?.detail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'owner', 'error')} ">
	<label for="owner">
		<g:message code="workShop.owner.label" default="Owner" />
		
	</label>
	<g:textField name="owner" maxlength="32" value="${workShopInstance?.owner}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'mail', 'error')} ">
	<label for="mail">
		<g:message code="workShop.mail.label" default="Mail" />
		
	</label>
	<g:field type="email" name="mail" value="${workShopInstance?.mail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: workShopInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="workShop.password.label" default="Password" />
		
	</label>
	<g:textField name="password" maxlength="32" value="${workShopInstance?.password}"/>
</div>

