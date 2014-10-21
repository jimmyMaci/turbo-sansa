package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.OfferedEventLocations;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class OfferedEventLocationsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private OfferedEventLocationsDao offeredEventLocationsDao;

	@Test
	public void testFindAll() {
		List<OfferedEventLocations> list = offeredEventLocationsDao.findAll();
	}

}
