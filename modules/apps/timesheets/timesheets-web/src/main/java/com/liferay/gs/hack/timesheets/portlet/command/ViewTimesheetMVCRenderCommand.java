package com.liferay.gs.hack.timesheets.portlet.command;

import com.liferay.gs.hack.timesheets.portlet.TimesheetPortletKeys;
import com.liferay.gs.hack.timesheets.service.TimesheetLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TimesheetPortletKeys.TIMESHEET,
		"mvc.command.name=/", "mvc.command.name=/view"
	},
	service = MVCRenderCommand.class
)
public class ViewTimesheetMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		return "/view.jsp";
	}

	@Reference
	void setReportLocalService(TimesheetLocalService timesheetLocalService) {
		_timesheetLocalService = timesheetLocalService;
	}

	private TimesheetLocalService _timesheetLocalService;
}
