package events.system.service;

import java.util.List;

import javax.persistence.Query;

import hbm.service.jpa.AbstractBusinessService;
import net.sourceforge.jaulp.collections.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;
import events.system.daos.ProfileTopicsDao;
import events.system.model.ProfileTopics;
import events.system.model.Topics;
import events.system.service.api.ProfileTopicsService;

@Transactional
@Service("profileTopicsService")
public class ProfileTopicsBusinessService
		extends
		AbstractBusinessService<ProfileTopics, java.lang.Integer, ProfileTopicsDao>
		implements ProfileTopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setProfileTopicsDao(ProfileTopicsDao profileTopicsDao) {
		setDao(profileTopicsDao);
	}
	/**
	 * {@inheritDoc}.
	 */
	public boolean contains(final Topics topic, final Users user) {
		return findProfileTopic(topic, user) != null;
	}

	/**
	 * {@inheritDoc}.
	 */
	public void deleteWithAllReferences(ProfileTopics profileTopics) {
		if (profileTopics != null) {
			profileTopics.setUser(null);
			profileTopics.setTopic(null);
			profileTopics = merge(profileTopics);
			delete(profileTopics);
		}
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public ProfileTopics findProfileTopic(final Topics topic, final Users user) {
		final String hqlString = "select pt from ProfileTopics pt where pt.user=:user and pt.topic=:topic";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		query.setParameter("topic", topic);
		List<ProfileTopics> profileTopics = query.getResultList();
		return ListUtils.getFirst(profileTopics);
	}

	/**
	 * {@inheritDoc}.
	 */
	@SuppressWarnings("unchecked")
	public List<ProfileTopics> findProfileTopics(final Users user) {
		final String hqlString = "select pt from ProfileTopics pt where pt.user=:user";
		final Query query = getQuery(hqlString);
		query.setParameter("user", user);
		List<ProfileTopics> profileTopics = query.getResultList();
		return profileTopics;
	}


}