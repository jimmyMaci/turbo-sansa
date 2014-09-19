package address.book.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import address.book.model.Federalstates;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class FederalstatesDaoTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private FederalstatesDao federalstatesDao;

	@Test
	public void testFindAll() {
		List<Federalstates> all = federalstatesDao.findAll();
		System.out.println(all.size());		
	}
}
