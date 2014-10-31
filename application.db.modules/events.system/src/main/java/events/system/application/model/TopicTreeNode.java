package events.system.application.model;

import events.system.model.Topics;
import net.sourceforge.jaulp.tree.TreeNode;


/**
 * The Class TopicTreeNode.
 * 
 * @author Asterios Raptis
 */
public class TopicTreeNode extends TreeNode<Topics> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new topic tree node.
	 * 
	 * @param value
	 *            the value
	 */
	public TopicTreeNode(final Topics value) {
		super(value);
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @return true, if is node
	 * @see com.sem.base.model.tree.TreeNode#isNode()
	 */
	@Override
	public boolean isNode() {
		return getValue().isNode();
	}

	/**
	 * {@inheritDoc}.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(getDisplayValue() != null) {
			return getDisplayValue();
		}
		return getValue().getName();
	}

}
