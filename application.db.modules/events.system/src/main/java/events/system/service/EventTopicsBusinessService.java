package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventTopicsDao;
import events.system.model.EventTopics;
import events.system.service.api.EventTopicsService;

@Transactional
@Service("eventTopicsService")
public class EventTopicsBusinessService extends
		AbstractBusinessService<EventTopics, java.lang.Integer, EventTopicsDao>
		implements EventTopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventTopicsDao(EventTopicsDao eventTopicsDao) {
		setDao(eventTopicsDao);
	}

}