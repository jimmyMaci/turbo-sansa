package message.system.service.api;

import hbm.service.jpa.BusinessService;
import message.system.model.MessageRecipients;
import message.system.model.Messages;
import user.management.model.Users;

public interface MessageRecipientsService extends BusinessService<MessageRecipients, Integer>{
	

	boolean deleteMessageRecipient(final Users recipient, final Messages message);
}