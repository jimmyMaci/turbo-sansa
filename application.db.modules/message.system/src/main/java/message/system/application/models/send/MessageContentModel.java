package message.system.application.models.send;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import message.system.application.models.send.api.IMessageContentModel;
import net.sourceforge.jaulp.xml.XmlUtils;
import net.sourceforge.jaulp.xml.api.Transformable;

public class MessageContentModel implements IMessageContentModel, Transformable<IMessageContentModel> {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The subject. */
	private String subject;

	/** The message content. */
	private String content;

	/** The locale for the message content. */
	private Locale locale;

	public MessageContentModel() {
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public Locale getLocale() {
		return locale;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String getSubject() {
		return subject;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String getContent() {
		return content;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public void setContent(String content) {
		this.content = content;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public String toXml() {
		Map<String, Class<?>> aliases = new HashMap<String, Class<?>>();
		aliases.put("message", MessageContentModel.class);
		String xmlString = XmlUtils.toXmlWithXStream(this, aliases);
		return xmlString;
	}

    /**
     * {@inheritDoc}
     */
	@Override
	public IMessageContentModel toObject(String xml) {
		Map<String, Class<?>> aliases = new HashMap<String, Class<?>>();
		aliases.put("message", MessageContentModel.class);
		return XmlUtils.toObjectWithXStream(xml, aliases);
	}

}
