package events.system.service.api;

import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;
import events.system.model.ProfileTopics;
import events.system.model.Topics;

/**
 * The Interface ProfileTopicsService.
 */
public interface ProfileTopicsService extends
		BusinessService<ProfileTopics, java.lang.Integer> {
	/**
	 * Contains.
	 * 
	 * @param topic
	 *            the topic
	 * @param user
	 *            the user
	 * @return true, if successful
	 */
	boolean contains(final Topics topic, final Users user);

	/**
	 * Delete with all references.
	 *
	 * @param profileTopics the profile topics
	 */
	void deleteWithAllReferences(ProfileTopics profileTopics);

	/**
	 * Find profile topic.
	 * 
	 * @param topic
	 *            the topic
	 * @param user
	 *            the user
	 * @return the profile topics
	 */
	ProfileTopics findProfileTopic(final Topics topic, final Users user);

	/**
	 * Find profile topics.
	 * 
	 * @param user
	 *            the user
	 * @return the list
	 */
	List<ProfileTopics> findProfileTopics(final Users user);
}