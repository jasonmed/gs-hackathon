package com.liferay.gs.hack.report.web.portlet.action;

import com.liferay.gs.hack.report.web.constants.ReportsPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Travis Cory
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ReportsPortletKeys.REPORTS,
		"mvc.command.name=/reports/view"
	},
	service = MVCRenderCommand.class
)
public class ReportsViewMVCRenderCommand
	implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		// TODO:
        // Fetch reports

		return "/view.jsp";
	}
}
