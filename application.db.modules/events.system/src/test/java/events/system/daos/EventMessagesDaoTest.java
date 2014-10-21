package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.EventMessages;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventMessagesDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventMessagesDao eventMessagesDao;

	@Test
	public void testFindAll() {
		List<EventMessages> list = eventMessagesDao.findAll();
	}

}
