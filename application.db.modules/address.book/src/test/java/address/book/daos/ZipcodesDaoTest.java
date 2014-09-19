package address.book.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import address.book.model.Zipcodes;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class ZipcodesDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private ZipcodesDao zipcodesDao;

	public List<Zipcodes> testFindAll() {
		return zipcodesDao.findAll();
	}

}
