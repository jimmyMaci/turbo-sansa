package flirt.and.date.hbm.daos;

import flirt.and.date.hbm.model.UserProfile;
import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository("userProfileDao")
public class UserProfileDao extends JpaEntityManagerDao<UserProfile, Integer> {
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
