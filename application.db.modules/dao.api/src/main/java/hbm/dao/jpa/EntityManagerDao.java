package hbm.dao.jpa;
import hbm.dao.api.GenericDao;
import hbm.entity.BaseEntity;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface EntityManagerDao<T extends BaseEntity<PK>, PK extends Serializable> extends GenericDao<T, PK> {
	
	void create(T entity);

	EntityManager getEntityManager();

	void setEntityManager(EntityManager entityManager);

	Query getQuery(String hqlQuery);

}