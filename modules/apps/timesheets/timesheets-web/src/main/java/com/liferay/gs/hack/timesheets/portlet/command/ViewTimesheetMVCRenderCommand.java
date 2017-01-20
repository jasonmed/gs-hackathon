package com.liferay.gs.hack.timesheets.portlet.command;

import com.liferay.gs.hack.timesheets.model.Timesheet;
import com.liferay.gs.hack.timesheets.model.TimesheetTask;
import com.liferay.gs.hack.timesheets.model.TimesheetTaskDuration;
import com.liferay.gs.hack.timesheets.portlet.TimesheetPortletKeys;
import com.liferay.gs.hack.timesheets.service.TimesheetLocalService;
import com.liferay.gs.hack.timesheets.service.TimesheetTaskDurationLocalService;
import com.liferay.gs.hack.timesheets.service.TimesheetTaskLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

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
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        List<Timesheet> timesheets = _timesheetLocalService.findByUserId(userId);
        if (Validator.isNotNull(timesheets) && !timesheets.isEmpty()) {
            Timesheet timesheet = timesheets.get(0);
            List<TimesheetTask> timesheetTasks = _timesheetTaskLocalService.findByTimesheetId(timesheet.getTimesheetId());
            if (Validator.isNotNull(timesheetTasks)) {
                for (TimesheetTask timesheetTask : timesheetTasks) {
                    long timesheetTaskId = timesheetTask.getTimesheetTaskId();
                    List<TimesheetTaskDuration> timesheetTaskDurations = _timesheetTaskDurationLocalService.findByTimesheetTaskId(timesheetTaskId);
                    timesheetTask.setTimesheetTaskDurations(timesheetTaskDurations);
                }
                renderRequest.setAttribute("timesheetTasks", timesheetTasks);
            }
        }
        try {
            List<Organization> clients = new ArrayList<>();
            List<Organization> projects = new ArrayList<>();
            List<Organization> organizations = _organizationLocalService.getOrganizations(userId, -1, -1, null);
            if (Validator.isNotNull(organizations)) {
                for (Organization organization : organizations) {
                    if (organization.getParentOrganizationId() == 0) {
                        clients.add(organization);
                    } else {
                        projects.add(organization);
                    }
                }
            }
            renderRequest.setAttribute("clients", clients);
            renderRequest.setAttribute("projects", projects);
        } catch (Exception e) {
            _log.error(e, e);
        }
        return "/view.jsp";
    }

    @Reference
    void setTimesheetLocalService(TimesheetLocalService timesheetLocalService) {
        _timesheetLocalService = timesheetLocalService;
    }

    @Reference
    void setTimesheetTaskLocalService(TimesheetTaskLocalService timesheetTaskLocalService) {
        _timesheetTaskLocalService = timesheetTaskLocalService;
    }

    @Reference
    void setTimesheetTaskDurationLocalService(TimesheetTaskDurationLocalService timesheetTaskDurationLocalService) {
        _timesheetTaskDurationLocalService = timesheetTaskDurationLocalService;
    }

    @Reference
    public void setOrganizationLocalService(OrganizationLocalService organizationLocalService) {
        _organizationLocalService = organizationLocalService;
    }

    private TimesheetLocalService _timesheetLocalService;
    private TimesheetTaskLocalService _timesheetTaskLocalService;
    private TimesheetTaskDurationLocalService _timesheetTaskDurationLocalService;
    private OrganizationLocalService _organizationLocalService;
    private static final Log _log = LogFactoryUtil.getLog(ViewTimesheetMVCRenderCommand.class);
}
