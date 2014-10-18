package flirt.and.date.hbm.service.utils;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import user.management.model.Users;
import flirt.and.date.hbm.enums.FriendshipRequestsState;
import flirt.and.date.hbm.model.UserProfile;

public class HqlStringCreatorTest {

	@Test(enabled=true)
	public void testForFriendshipRequests() {
		String actual;
		String expected;
		
		actual = HqlStringCreator.forFriendshipRequests(new Users(), new Users(), FriendshipRequestsState.ACCEPTED);
		expected = "select fr from FriendshipRequests fr where fr.requestor=:requestor and fr.requestedUser=:requestedUser and fr.state=:state";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(new Users(), new Users(), null);
		expected = "select fr from FriendshipRequests fr where fr.requestor=:requestor and fr.requestedUser=:requestedUser";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(null, new Users(), null);
		expected = "select fr from FriendshipRequests fr where fr.requestedUser=:requestedUser";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(new Users(), null, null);
		expected = "select fr from FriendshipRequests fr where fr.requestor=:requestor";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(null, null, null);
		expected = "select fr from FriendshipRequests fr";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(null, new Users(), FriendshipRequestsState.ACCEPTED);
		expected = "select fr from FriendshipRequests fr where fr.requestedUser=:requestedUser and fr.state=:state";
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(new Users(), null, FriendshipRequestsState.ACCEPTED);
		expected = "select fr from FriendshipRequests fr where fr.requestor=:requestor and fr.state=:state";
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFriendshipRequests(null, null, FriendshipRequestsState.ACCEPTED);
		expected = "select fr from FriendshipRequests fr where fr.state=:state";
		AssertJUnit.assertEquals(expected, actual);
	}
	
	@Test(enabled=true)
	public void testForFavoriteMembers() {
		String actual;
		String expected;		
		actual = HqlStringCreator.forFavoriteMembers(new Users(), new UserProfile());
		expected = "select fm from FavoriteMembers fm where fm.owner=:owner and fm.favorite=:favorite";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFavoriteMembers(new Users(), null);
		expected = "select fm from FavoriteMembers fm where fm.owner=:owner";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFavoriteMembers(null, new UserProfile());
		expected = "select fm from FavoriteMembers fm where fm.favorite=:favorite";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forFavoriteMembers(null, null);
		expected = "select fm from FavoriteMembers fm";		
		AssertJUnit.assertEquals(expected, actual);		
	}
	
	@Test(enabled=true)
	public void testForProfileNotice() {
		String actual;
		String expected;		
		actual = HqlStringCreator.forProfileNotice(new Users(), new UserProfile());
		expected = "select pr from ProfileNotice pr where pr.user=:user and pr.userProfile=:userProfile";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forProfileNotice(new Users(), null);
		expected = "select pr from ProfileNotice pr where pr.user=:user";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forProfileNotice(null, new UserProfile());
		expected = "select pr from ProfileNotice pr where pr.userProfile=:userProfile";		
		AssertJUnit.assertEquals(expected, actual);
		
		actual = HqlStringCreator.forProfileNotice(null, null);
		expected = "select pr from ProfileNotice pr";		
		AssertJUnit.assertEquals(expected, actual);		
	}

}
