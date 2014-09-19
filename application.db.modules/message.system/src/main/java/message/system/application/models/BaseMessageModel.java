package message.system.application.models;

import net.sourceforge.jaulp.xml.XmlUtils;
import message.system.application.models.send.SendMessageModel;
import message.system.application.models.send.api.IBaseMessageModel;
import message.system.enums.MessageState;
import message.system.enums.MessageType;

/**
 * The Class BaseMessageModel.
 */
public class BaseMessageModel extends SendMessageModel implements IBaseMessageModel {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/** The message state. */
	private MessageState messageState;
	
	/** The message type. */
	private MessageType messageType;

    /**
     * {@inheritDoc}
     */
	@Override
	public MessageState getMessageState() {
		return messageState;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public MessageType getMessageType() {
		return messageType;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void setMessageState(MessageState messageState) {
		this.messageState = messageState;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toXml() {
		String xml = XmlUtils.toXmlWithXStream(this);
		return xml;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public BaseMessageModel toObject(String xml) {
		BaseMessageModel model = XmlUtils.toObjectWithXStream(xml);
		return model;
	}
}
