package com.liferay.gs.hack.tasks.web.portlet.action;

import com.liferay.gs.hack.projects.service.ProjectTaskLocalService;
import com.liferay.gs.hack.tasks.web.portlet.constants.TaskWebConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TaskWebConstants.TASK_PORTLET,
		"mvc.command.name=/task/update"
	},
	service = MVCActionCommand.class
)
public class AddProjectTaskMVCActionCommand  extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		updateProjectTask(actionRequest, actionResponse);
	}

	protected void updateProjectTask(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long companyId = themeDisplay.getCompanyId();
		long userId = themeDisplay.getUserId();

		String taskName = ParamUtil.getString(
			actionRequest, "name");

		String description = ParamUtil.getString(
			actionRequest, "description");

		long projectId = ParamUtil.getLong(actionRequest, "projectId");

		if (_projectTaskLocalService.isExistingTask(projectId, taskName)) {

			SessionErrors.add(
				actionRequest,
				"Task with this name already exists for this project");

			return;
		}

		_projectTaskLocalService.updateProjectTask(
			companyId, userId, projectId, taskName, description);

	}

	@Reference
	private ProjectTaskLocalService _projectTaskLocalService;
}
