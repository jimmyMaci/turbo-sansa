package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.EventTemplateDao;
import events.system.model.EventTemplate;
import events.system.service.api.EventTemplateService;

@Transactional
@Service("eventTemplateService")
public class EventTemplateBusinessService
		extends
		AbstractBusinessService<EventTemplate, java.lang.Integer, EventTemplateDao>
		implements EventTemplateService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setEventTemplateDao(EventTemplateDao eventTemplateDao) {
		setDao(eventTemplateDao);
	}

}