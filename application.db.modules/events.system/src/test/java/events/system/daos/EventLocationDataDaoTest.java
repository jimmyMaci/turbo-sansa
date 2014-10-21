package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.EventLocationData;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventLocationDataDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventLocationDataDao eventLocationDataDao;

	@Test
	public void testFindAll() {
		List<EventLocationData> list = eventLocationDataDao.findAll();
	}

}
