package address.book.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import address.book.model.Federalstates;

@Repository("federalstatesDao")
public class FederalstatesDao extends JpaEntityManagerDao<Federalstates, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3937865183860303611L;

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
