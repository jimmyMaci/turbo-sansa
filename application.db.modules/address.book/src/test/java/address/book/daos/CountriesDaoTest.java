package address.book.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import address.book.model.Countries;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class CountriesDaoTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private CountriesDao countriesDao;


	@Test
	public List<Countries> testFindAll() {
		return countriesDao.findAll();
	}
}
