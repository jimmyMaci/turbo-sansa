package message.system.daos;

import hbm.dao.jpa.JpaEntityManagerDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import message.system.model.MessageRecipients;

import org.springframework.stereotype.Repository;

@Repository("messageRecipientsDao")
public class MessageRecipientsDao extends JpaEntityManagerDao<MessageRecipients, Integer>{

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
