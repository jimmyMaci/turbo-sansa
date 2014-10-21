package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.RatingDescriptions;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class RatingDescriptionsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private RatingDescriptionsDao ratingDescriptionsDao;

	@Test
	public void testFindAll() {
		List<RatingDescriptions> list = ratingDescriptionsDao.findAll();
	}

}
