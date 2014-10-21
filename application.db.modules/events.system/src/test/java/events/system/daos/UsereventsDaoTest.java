package events.system.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import events.system.model.Userevents;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class UsereventsDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
	private UsereventsDao usereventsDao;

	@Test
	public void testFindAll() {
		List<Userevents> list = usereventsDao.findAll();
	}

}
