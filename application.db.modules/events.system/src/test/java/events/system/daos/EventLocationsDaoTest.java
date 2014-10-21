package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.EventLocations;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class EventLocationsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private EventLocationsDao eventLocationsDao;

	@Test
	public void testFindAll() {
		List<EventLocations> list = eventLocationsDao.findAll();
	}

}
