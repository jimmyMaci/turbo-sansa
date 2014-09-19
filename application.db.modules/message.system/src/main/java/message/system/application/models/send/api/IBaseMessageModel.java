package message.system.application.models.send.api;

import message.system.enums.MessageState;
import message.system.enums.MessageType;

public interface IBaseMessageModel extends ISendMessageModel {

	/**
	 * Gets the message state.
	 *
	 * @return the message state
	 */
	MessageState getMessageState();

	/**
	 * Gets the message type.
	 *
	 * @return the message type
	 */
	MessageType getMessageType();

	/**
	 * Sets the message state.
	 *
	 * @param messageState the new message state
	 */
	void setMessageState(MessageState messageState);

	/**
	 * Sets the message type.
	 *
	 * @param messageType the new message type
	 */
	void setMessageType(MessageType messageType);

}