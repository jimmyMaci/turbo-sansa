package flirt.and.date.hbm.daos;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import flirt.and.date.hbm.model.FavoriteMembers;
import flirt.and.date.hbm.service.api.FavoriteMembersService;

@ContextConfiguration(locations = "classpath:test-applicationContext.xml")
public class FavoriteMembersDaoTest extends AbstractTestNGSpringContextTests {

    @Autowired
    FavoriteMembersService favoriteMembersService; 

	@Test
	public void getAllFavoriteMembers() {
		initFavoriteMembers();
		List<FavoriteMembers> list = favoriteMembersService.findAll();
		AssertJUnit.assertEquals(2, list.size());
	}
	
	protected void initFavoriteMembers() {
		FavoriteMembers favoriteMembers = new FavoriteMembers();
		// TODO init model class
		favoriteMembersService.merge(favoriteMembers);

		favoriteMembers = new FavoriteMembers();
		// TODO init model class
		favoriteMembersService.merge(favoriteMembers);

	}

}
