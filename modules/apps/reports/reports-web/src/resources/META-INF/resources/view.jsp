<%@ include file="/init.jsp" %>

<aui:form action="javascript:;" method="POST">
    <div class="form-group">
		<aui:input checked="true" label="client" name="isClient" type="radio" value="true" />

		<aui:input checked="false" label="project" name="isClient" type="radio" value="fals" />
    </div>

	<aui:input label="organization-id" name="organizationId" required="true" />

	<aui:button name="saveButton" primary="false" type="submit" value="update" />
</aui:form>
