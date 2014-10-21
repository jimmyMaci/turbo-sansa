package events.system.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import events.system.model.UserContactsAllowedContactmethods;

@Repository("userContactsAllowedContactmethodsDao")
public class UserContactsAllowedContactmethodsDao
		extends
		JpaEntityManagerDao<UserContactsAllowedContactmethods, java.lang.Integer> {
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
