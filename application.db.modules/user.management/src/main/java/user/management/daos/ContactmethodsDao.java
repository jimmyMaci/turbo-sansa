package user.management.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import user.management.model.Contactmethods;

@Repository("contactmethodsDao")
public class ContactmethodsDao extends JpaEntityManagerDao<Contactmethods, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3922309556657658501L;

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
