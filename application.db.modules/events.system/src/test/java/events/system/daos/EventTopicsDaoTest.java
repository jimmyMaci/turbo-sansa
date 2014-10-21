package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.EventTopics;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventTopicsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventTopicsDao eventTopicsDao;

	@Test
	public void testFindAll() {
		List<EventTopics> list = eventTopicsDao.findAll();
	}

}
