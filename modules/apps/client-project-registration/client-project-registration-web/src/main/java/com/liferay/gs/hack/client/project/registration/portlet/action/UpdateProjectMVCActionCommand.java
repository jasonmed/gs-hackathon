package com.liferay.gs.hack.client.project.registration.portlet.action;

import com.liferay.gs.hack.client.project.registration.portlet.constants.ClientProjectRegistrationConstants;
import com.liferay.gs.hack.projects.service.ProjectLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ClientProjectRegistrationConstants.PORTLET_NAME,
		"mvc.command.name=/project/update"
	},
	service = MVCActionCommand.class
)
public class UpdateProjectMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		updateProjectInfo(actionRequest, actionResponse);

	}

	protected void updateProjectInfo(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();

		String projectName = ParamUtil.getString(
			actionRequest, "projectName");

		long clientId = ParamUtil.getLong(actionRequest, "client");

		DateFormat df = DateFormat.getDateInstance(
			DateFormat.SHORT, themeDisplay.getLocale());

		Date startDate = ParamUtil.getDate(
			actionRequest, "startDate", df, null);

		Date endDate = ParamUtil.getDate(actionRequest, "endDate", df, null);

		boolean active = ParamUtil.getBoolean(actionRequest, "active");

		//TODO Add validations

		_projectLocalService.updateProject(
			companyId,groupId, userId, clientId, projectName, startDate,
			endDate, active);

		actionResponse.setRenderParameter("mvcPath", "/project/update.jsp");

		sendRedirect(actionRequest, actionResponse);

	}

	@Reference
	private ProjectLocalService _projectLocalService;
}
