package hbm.dao.jpa;

import hbm.entity.BaseEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import net.sourceforge.jaulp.lang.TypeArgumentsUtils;

public abstract class JpaEntityManagerDao<T extends BaseEntity<PK>, PK extends Serializable> implements
		EntityManagerDao<T, PK> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	private final Class<T> type = (Class<T>) TypeArgumentsUtils.getFirstTypeArgument(JpaEntityManagerDao.class, this.getClass());
	
	/** The data source. */
	@Autowired
	private DataSource dataSource;

	/** The jdbc template. */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<T> getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void create(final T entity) {
		getEntityManager().persist(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(final T entity) {
		getEntityManager().merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(final T entity) {
		getEntityManager().remove(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(List<T> objects) {
		for (T entity : objects) {
			getEntityManager().remove(entity);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(PK id) {
		final T entity = get(id);
		delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(PK id) {
		return get(id) != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(getType());
		Root<T> root = cq.from(getType());
		cq.select(root);
		return getEntityManager().createQuery(cq).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T get(PK id) {
		if (id != null) {
			return getEntityManager().find(type, id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T load(PK id) {
		return get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T merge(T object) {		
		return getEntityManager().merge(object);
	}

	
	@Override
	public void refresh(T object) {
		getEntityManager().refresh(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PK> save(List<T> objects) {
		List<PK> primaryKeys = new ArrayList<PK>();
		for (T object : objects) {
			primaryKeys.add(save(object));
		}
		return primaryKeys;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> merge(List<T> objects) {
		List<T> mergedEntities = new ArrayList<T>();
		for (T object : objects) {
			mergedEntities.add(merge(object));
		}
		return mergedEntities;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PK save(T object) {
		getEntityManager().persist(object);
		return object.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveOrUpdate(List<T> objects) {
		save(objects);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveOrUpdate(T object) {
		save(object);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(List<T> objects) {
		for (T t : objects) {
			update(t);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void evict(T object) {
		getEntityManager().detach(object);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Query getQuery(final String hqlQuery) {
		return getEntityManager().createQuery(hqlQuery);
	}

}