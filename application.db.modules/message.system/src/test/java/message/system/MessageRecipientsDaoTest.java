package message.system;

import java.util.List;

import message.system.daos.MessageRecipientsDao;
import message.system.model.MessageRecipients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class MessageRecipientsDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	MessageRecipientsDao messageRecipientsDao;

	@Test
	public void testFindAll() {
		List<MessageRecipients> all = messageRecipientsDao.findAll();
		System.out.println(all);
	}
}
