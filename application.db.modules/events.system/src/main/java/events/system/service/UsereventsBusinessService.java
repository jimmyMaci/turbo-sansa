package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;
import events.system.daos.UsereventsDao;
import events.system.enums.UsereventsRelationType;
import events.system.model.EventTemplate;
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

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public Users findUser(final EventTemplate eventtemplateToFind,
			final UsereventsRelationType relationtype) {
		final String hqlString = "select ue.user from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", eventtemplateToFind);
		final List<Users> users = query.getResultList();
		return ListUtils.getFirst(users);
	}

	@SuppressWarnings("unchecked")
	public List<Userevents> findUserevents(final EventTemplate event) {
		final String hqlString = "select ue from Userevents ue where ue.event=:event";
		final Query query = getQuery(hqlString);
		query.setParameter("event", event);
		final List<Userevents> userevents = query.getResultList();
		return userevents;
	}


}