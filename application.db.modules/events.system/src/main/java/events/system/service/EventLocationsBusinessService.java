package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventLocationsDao;
import events.system.model.EventLocations;
import events.system.service.api.EventLocationsService;

@Transactional
@Service("eventLocationsService")
public class EventLocationsBusinessService
		extends
		AbstractBusinessService<EventLocations, java.lang.Integer, EventLocationsDao>
		implements EventLocationsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventLocationsDao(EventLocationsDao eventLocationsDao) {
		setDao(eventLocationsDao);
	}

}