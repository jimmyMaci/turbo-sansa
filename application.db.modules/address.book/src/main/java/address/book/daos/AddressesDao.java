package address.book.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import address.book.model.Addresses;

@Repository("addressesDao")
public class AddressesDao extends JpaEntityManagerDao<Addresses, Integer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5693868415897202295L;

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
