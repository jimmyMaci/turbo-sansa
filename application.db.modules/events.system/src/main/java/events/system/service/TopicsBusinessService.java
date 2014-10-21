package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.daos.TopicsDao;
import events.system.model.Topics;
import events.system.service.api.TopicsService;

@Transactional
@Service("topicsService")
public class TopicsBusinessService extends
		AbstractBusinessService<Topics, java.lang.Integer, TopicsDao> implements
		TopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setTopicsDao(TopicsDao topicsDao) {
		setDao(topicsDao);
	}

}