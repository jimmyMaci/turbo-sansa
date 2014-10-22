package de.alpharogroup.scheduler.system.service.locator;

import de.alpharogroup.scheduler.system.service.api.AppointmentsService;

public interface ServiceLocator {

	/**
	 * Gets the AppointmentsService.
	 * 
	 * @return the AppointmentsService. 
	 */
	AppointmentsService getAppointmentsService();

	/**
	 * Sets the AppointmentsService.
	 * 
	 * @param appointmentsService
	 *            the new AppointmentsService
	 */
	void setAppointmentsService(AppointmentsService appointmentsService);

}
