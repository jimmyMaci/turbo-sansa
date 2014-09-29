package address.book.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import address.book.model.Zipcodes;

@Repository("zipcodesDao")
public class ZipcodesDao extends JpaEntityManagerDao<Zipcodes, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4820703309882159443L;

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
