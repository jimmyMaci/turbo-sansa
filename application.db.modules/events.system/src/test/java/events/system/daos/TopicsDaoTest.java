package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.Topics;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class TopicsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private TopicsDao topicsDao;

	@Test
	public void testFindAll() {
		List<Topics> list = topicsDao.findAll();
	}

}
