package user.management.service;

import hbm.service.jpa.AbstractBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.daos.RobinsonsDao;
import user.management.model.Robinsons;
import user.management.service.api.RobinsonsService;

@Transactional
@Service("robinsonsService")
public class RobinsonsBusinessService extends AbstractBusinessService<Robinsons, Integer, RobinsonsDao> implements RobinsonsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setRobinsonsDao(RobinsonsDao robinsonsDao) {
		setDao(robinsonsDao);
	}

}