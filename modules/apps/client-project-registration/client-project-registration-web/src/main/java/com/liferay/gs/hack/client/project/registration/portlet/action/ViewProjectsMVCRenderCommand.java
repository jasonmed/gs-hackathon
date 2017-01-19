package com.liferay.gs.hack.client.project.registration.portlet.action;

import com.liferay.gs.hack.client.project.registration.portlet.constants.ClientProjectRegistrationConstants;
import com.liferay.gs.hack.projects.model.Project;
import com.liferay.gs.hack.projects.service.ProjectLocalService;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Prathima Shreenath
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ClientProjectRegistrationConstants.PORTLET_NAME,
		"mvc.command.name=/", "mvc.command.name=/project/view"
	},
	service = MVCRenderCommand.class
)
public class ViewProjectsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		processProjectsView(renderRequest, renderResponse);

		return "/project/view.jsp";
	}

	protected void processProjectsView(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		PortletURL iteratorURL = renderResponse.createRenderURL();

		SearchContainer<Project> searchContainer = new SearchContainer<>(
			renderRequest, iteratorURL, null, "custom empty message");

		List<Project> activeProjects =
			_projectLocalService.getAllActiveProjects(
				searchContainer.getStart(), searchContainer.getEnd());

		int projectsCount = _projectLocalService.getProjectsCount();

		renderRequest.setAttribute("projects", activeProjects);
		renderRequest.setAttribute("projectsCount", projectsCount);
		renderRequest.setAttribute("searchContainer", searchContainer);
	}

	@Reference
	private ProjectLocalService _projectLocalService;

}