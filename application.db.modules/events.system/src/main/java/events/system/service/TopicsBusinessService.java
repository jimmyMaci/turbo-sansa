package events.system.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import net.sourceforge.jaulp.tree.ifaces.ITreeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import events.system.application.model.TopicTreeNode;
import events.system.daos.TopicsDao;
import events.system.model.Topics;
import events.system.service.api.TopicsService;
import events.system.service.util.HqlStringCreator;

@Transactional
@Service("topicsService")
public class TopicsBusinessService extends
		AbstractBusinessService<Topics, java.lang.Integer, TopicsDao> implements
		TopicsService {

	private static final long serialVersionUID = 1L;

	@Autowired
	public void setTopicsDao(TopicsDao topicsDao) {
		setDao(topicsDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Topics> getChildren(final Topics topic) {
		return find(null, null, topic);
	}
	
	@SuppressWarnings("unchecked")
	public List<Topics> find(String name,  Boolean node, Topics parent) {
		String hqlString = HqlStringCreator.forTopics(name, node, parent);				
		final Query query = getQuery(hqlString);
		if(name != null){
			query.setParameter("name", name);
		}
		if(node != null){
			query.setParameter("node", node);
		}
		if(parent != null){
			query.setParameter("parent", parent);
		}
		final List<Topics> topics = query.getResultList();
		return topics;	
	}

	/**
	 * {@inheritDoc}
	 */
	public Iterator<? extends Topics> getIteratorForChildren(final Topics topic) {
		final List<Topics> topics = getChildren(topic);
		if (null != topics && !topics.isEmpty()) {
			return topics.iterator();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public Topics getRoot() {
		return get(Integer.valueOf(1));
	}

	/**
	 * {@inheritDoc}
	 */
	public ITreeNode<Topics> getRootTreeNode() {
		return getTreeNode(getRoot());
	}

	/**
	 * {@inheritDoc}
	 */
	public void getTopicTreeRecursive(final ITreeNode<Topics> taskElement) {
		final List<Topics> children = getChildren(taskElement.getValue());
		final List<ITreeNode<Topics>> childElements = new ArrayList<ITreeNode<Topics>>();
		if (children != null) {
			final Iterator<Topics> it = children.iterator();
			while (it.hasNext()) {
				final Topics childTopic = it.next();
				final ITreeNode<Topics> childElement = new TopicTreeNode(
						childTopic);
				childElements.add(childElement);
				getTopicTreeRecursive(childElement);
			}
			taskElement.setChildren(childElements);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public ITreeNode<Topics> getTreeNode(final Topics topic) {
		final ITreeNode<Topics> root = new TopicTreeNode(topic);
		getTopicTreeRecursive(root);
		return root;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(final Topics topic) {
		final List<Topics> topics = getChildren(topic);
		return null != topics && !topics.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasParent(final Topics topic) {
		return null != topic.getParent();
	}


}