package timesheet.details.web.portlet;

import com.liferay.gs.hack.timesheets.model.Timesheet;
import com.liferay.gs.hack.timesheets.model.TimesheetApproval;
import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;
import com.liferay.gs.hack.timesheets.service.TimesheetApprovalLocalService;
import com.liferay.gs.hack.timesheets.service.TimesheetLocalService;
import com.liferay.gs.hack.timesheets.service.TimesheetTaskDurationLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=timesheet-details-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TimesheetDetailsWebPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		Timesheet timesheet = _timesheetLocalService.fetchTimesheet(0);
		long timesheetId = timesheet.getTimesheetId();

		List<TimesheetTaskDuration> timesheetTaskDurations =
			_timesheetTaskDurationLocalService.
				getTimesheetTaskDurationByTimesheetId(timesheetId);

		renderRequest.setAttribute("timesheetTaskDurations", timesheetTaskDurations);

		List<TimesheetApproval> timesheetApprovals = _timesheetApprovalLocalService.getTimesheetApprovalByTimesheetId(timesheetId);

		renderRequest.setAttribute("timesheetApprovals", timesheetApprovals);

		super.doView(renderRequest, renderResponse);
	}

	TimesheetLocalService _timesheetLocalService;

	TimesheetTaskDurationLocalService _timesheetTaskDurationLocalService;

	TimesheetApprovalLocalService _timesheetApprovalLocalService;
}