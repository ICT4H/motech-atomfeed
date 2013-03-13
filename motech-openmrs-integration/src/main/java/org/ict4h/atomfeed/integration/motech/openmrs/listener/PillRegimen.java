package org.ict4h.atomfeed.integration.motech.openmrs.listener;

import org.ict4h.atomfeed.integration.motech.openmrs.mapper.EventMapper;
import org.motechproject.event.MotechEvent;
import org.motechproject.event.listener.annotations.MotechListener;
import org.motechproject.scheduler.MotechSchedulerService;
import org.motechproject.server.pillreminder.api.service.PillReminderService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class PillRegimen {
    public static final String EVENT_FROM_OPEN_MRS = "eventFromOpenMRS";
    private final PillReminderService pillReminderService;
    private EventMapper mapper;

    public PillRegimen(PillReminderService pillReminderService, EventMapper mapper) {
        this.pillReminderService = pillReminderService;
        this.mapper = mapper;
    }

    @MotechListener(subjects = EVENT_FROM_OPEN_MRS)
    public void create(MotechEvent motechEvent) throws IOException {
        Map<String,Object> parameters = motechEvent.getParameters();
        String contents = (String) parameters.get("contents");
        pillReminderService.createNew(mapper.toDailyPillRegimenRequest(contents));
        System.out.println("If you see this - go check the couch installation to view the created Pill Regimen");
    }

}
