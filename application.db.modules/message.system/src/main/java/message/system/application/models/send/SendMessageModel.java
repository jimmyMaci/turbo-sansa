package message.system.application.models.send;

import message.system.application.models.send.api.IMessageContentModel;
import message.system.application.models.send.api.ISendInformationModel;
import message.system.application.models.send.api.ISendMessageModel;
import net.sourceforge.jaulp.xml.XmlUtils;
import net.sourceforge.jaulp.xml.api.Transformable;

/**
 * The Class SendMessageModel.
 */
public class SendMessageModel implements ISendMessageModel, Transformable<SendMessageModel>  {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The data of sender, recipients and sent date. */
	private ISendInformationModel sendInformationModel;
	
	/** The data of message. */
	private IMessageContentModel messageContentModel;

	/**
     * {@inheritDoc}
     */
	@Override
	public IMessageContentModel getMessageContentModel() {
		return messageContentModel;
	}

	@Override
	public ISendInformationModel getSendInformationModel() {
		return sendInformationModel;
	}

	@Override
	public void setMessageContentModel(IMessageContentModel messageModel) {
		this.messageContentModel = messageModel;
	}

    @Override
	public void setSendInformationModel(ISendInformationModel sendInformationModel) {
		this.sendInformationModel = sendInformationModel;
	}

	@Override
	public String toXml() {
		String xml = XmlUtils.toXmlWithXStream(this);
		return xml;
	}

	@Override
	public SendMessageModel toObject(String xml) {
		SendMessageModel model = XmlUtils.toObjectWithXStream(xml);
		return model;
	}

}
