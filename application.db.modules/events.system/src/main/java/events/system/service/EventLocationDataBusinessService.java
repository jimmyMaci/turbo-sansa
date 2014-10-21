package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventLocationDataDao;
import events.system.model.EventLocationData;
import events.system.service.api.EventLocationDataService;

@Transactional
@Service("eventLocationDataService")
public class EventLocationDataBusinessService
		extends
		AbstractBusinessService<EventLocationData, java.lang.Integer, EventLocationDataDao>
		implements EventLocationDataService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventLocationDataDao(
			EventLocationDataDao eventLocationDataDao) {
		setDao(eventLocationDataDao);
	}

}