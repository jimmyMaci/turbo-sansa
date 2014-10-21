package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventRatingsDao;
import events.system.model.EventRatings;
import events.system.service.api.EventRatingsService;

@Transactional
@Service("eventRatingsService")
public class EventRatingsBusinessService
		extends
		AbstractBusinessService<EventRatings, java.lang.Integer, EventRatingsDao>
		implements EventRatingsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventRatingsDao(EventRatingsDao eventRatingsDao) {
		setDao(eventRatingsDao);
	}

}