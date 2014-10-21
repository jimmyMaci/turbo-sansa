package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.UsereventsDao;
import events.system.model.Userevents;
import events.system.service.api.UsereventsService;

@Transactional
@Service("usereventsService")
public class UsereventsBusinessService extends
		AbstractBusinessService<Userevents, java.lang.Integer, UsereventsDao>
		implements UsereventsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setUsereventsDao(UsereventsDao usereventsDao) {
		setDao(usereventsDao);
	}

}