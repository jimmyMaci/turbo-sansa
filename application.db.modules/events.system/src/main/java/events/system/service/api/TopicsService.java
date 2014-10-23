package events.system.service.api;

import net.sourceforge.jaulp.tree.ifaces.ITreeNode;
import events.system.model.Topics;
import hbm.service.jpa.BusinessService;

import java.util.Iterator;
import java.util.List;

/**
 * The Interface TopicsService.
 */
public interface TopicsService extends
		BusinessService<Topics, java.lang.Integer> {


	/**
	 * Gets the children.
	 * 
	 * @param topic
	 *            the topic
	 * @return the children
	 */
	List<Topics> getChildren(final Topics topic);

	/**
	 * Gets the iterator for children.
	 * 
	 * @param topic
	 *            the topic
	 * @return the iterator for children
	 */
	Iterator<? extends Topics> getIteratorForChildren(final Topics topic);

	/**
	 * Gets the root.
	 * 
	 * @return the root
	 */
	Topics getRoot();

	/**
	 * Gets the root tree node.
	 * 
	 * @return the root tree node
	 */
	ITreeNode<Topics> getRootTreeNode();

	/**
	 * Gets the topic tree recursive.
	 * 
	 * @param taskElement
	 *            the task element
	 * @return the topic tree recursive
	 */
	void getTopicTreeRecursive(final ITreeNode<Topics> taskElement);

	/**
	 * Gets the tree node.
	 * 
	 * @param topic
	 *            the topic
	 * @return the tree node
	 */
	ITreeNode<Topics> getTreeNode(final Topics topic);

	/**
	 * Checks for children.
	 * 
	 * @param topic
	 *            the topic
	 * @return true, if successful
	 */
	boolean hasChildren(final Topics topic);

	/**
	 * Checks for parent.
	 * 
	 * @param topic
	 *            the topic
	 * @return true, if successful
	 */
	boolean hasParent(final Topics topic);
	
	/**
	 * Finds a list from the given name, node and parent parameters.
	 *
	 * @param name the name
	 * @param node the node
	 * @param parent the parent
	 * @return the list
	 */
	List<Topics> find(String name,  Boolean node, Topics parent);
}