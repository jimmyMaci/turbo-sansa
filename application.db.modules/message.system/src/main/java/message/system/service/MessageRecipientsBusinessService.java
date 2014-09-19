package message.system.service;

import hbm.service.jpa.AbstractBusinessService;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import message.system.daos.MessageRecipientsDao;
import message.system.model.MessageRecipients;
import message.system.model.Messages;
import message.system.service.api.MessageRecipientsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import user.management.model.Users;

@Transactional
@Service("messageRecipientsService")
public class MessageRecipientsBusinessService extends AbstractBusinessService<MessageRecipients, Integer, MessageRecipientsDao> implements MessageRecipientsService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	public void setMessageRecipientsDao(MessageRecipientsDao messageRecipientsDao) {
		setDao(messageRecipientsDao);
	}

	@SuppressWarnings("unchecked")
	public boolean deleteMessageRecipient(final Users recipient,
			final Messages message) {
		final String hqlSelectString = 
				"select distinct mr from MessageRecipients mr " +
				"where mr.recipient=:recipient " +
				"and mr.message=:message";

		final Query query = getQuery(hqlSelectString);
		query.setParameter("recipient", recipient);
		query.setParameter("message", message);
		final List<MessageRecipients> toDel = query.getResultList();
		if (toDel != null && !toDel.isEmpty()) {
			for (final Iterator<MessageRecipients> iterator = toDel.iterator(); iterator
					.hasNext();) {
				MessageRecipients messageRecipient = iterator.next();
				messageRecipient.setMessage(null);
				messageRecipient.setRecipient(null);
				messageRecipient = merge(messageRecipient);
				delete(messageRecipient);
			}
			return true;
		}
		return false;
	}
}