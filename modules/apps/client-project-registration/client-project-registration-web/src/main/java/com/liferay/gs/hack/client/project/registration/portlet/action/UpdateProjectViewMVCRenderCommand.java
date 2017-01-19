package com.liferay.gs.hack.client.project.registration.portlet.action;

import com.liferay.gs.hack.client.project.registration.portlet.constants.ClientProjectRegistrationConstants;
import com.liferay.gs.hack.clients.model.Client;
import com.liferay.gs.hack.clients.service.ClientLocalService;
import com.liferay.gs.hack.projects.model.Project;
import com.liferay.gs.hack.projects.service.ProjectLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Date;
import java.util.List;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ClientProjectRegistrationConstants.PORTLET_NAME,
		"mvc.command.name=/", "mvc.command.name=/project/update/view"
	},
	service = MVCRenderCommand.class
)
public class UpdateProjectViewMVCRenderCommand implements MVCRenderCommand {
	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		processProjectUpdateView(renderRequest, renderResponse);

		return "/project/update.jsp";
	}

	protected void processProjectUpdateView(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		long projectId = ParamUtil.getLong(renderRequest, "projectId");

		Project project = _projectLocalService.fetchProject(projectId);

		setProjectParameters(renderRequest, project);

		setClientList(renderRequest);

	}

	protected void setProjectParameters(
		RenderRequest renderRequest, Project project) {

		String projectName = StringPool.BLANK;
		Date startDate = new Date();
		Date endDate = new Date();

		Client client = null;

		boolean active = true;

		if (project != null) {

			projectName = project.getName();

			startDate = project.getStartDate();

			endDate = project.getEndDate();

			active = project.getActive();

			long clientId = project.getClientId();

			client = _clientLocalService.fetchClient(clientId);
		}

		renderRequest.setAttribute("projectName", projectName);

		renderRequest.setAttribute("startDate", startDate);

		renderRequest.setAttribute("endDate", endDate);

		renderRequest.setAttribute("active", active);

		renderRequest.setAttribute("selectedClient", client);
	}

	@Reference
	private ProjectLocalService _projectLocalService;

	@Reference
	private ClientLocalService _clientLocalService;

	protected void setClientList(RenderRequest renderRequest) {

		List<Client> clientList = _clientLocalService.getClients(-1, -1);

		renderRequest.setAttribute("clientList", clientList);
	}
}
