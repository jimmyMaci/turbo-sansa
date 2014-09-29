package de.alpharogroup.scheduler.system.service.api;

import hbm.service.jpa.BusinessService;
import de.alpharogroup.scheduler.system.model.Appointments;

public interface AppointmentsService extends
		BusinessService<Appointments, Integer> {
}
