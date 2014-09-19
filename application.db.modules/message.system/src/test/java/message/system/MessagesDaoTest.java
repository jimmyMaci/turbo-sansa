package message.system;

import java.util.List;

import message.system.daos.MessagesDao;
import message.system.model.Messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class MessagesDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private MessagesDao messagesDao;


	@Test
	public void testFindAll() {
		List<Messages> all = messagesDao.findAll();
		System.out.println(all);		
	}
}
