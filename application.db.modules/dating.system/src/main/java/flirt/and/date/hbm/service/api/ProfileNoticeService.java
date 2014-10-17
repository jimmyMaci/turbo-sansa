package flirt.and.date.hbm.service.api;

import flirt.and.date.hbm.model.ProfileNotice;
import flirt.and.date.hbm.model.UserProfile;
import hbm.service.jpa.BusinessService;

import java.util.List;

import user.management.model.Users;

public interface ProfileNoticeService extends BusinessService<ProfileNotice, Integer> {

	ProfileNotice findProfileNotice(Users user, UserProfile userProfile);
	
	List<ProfileNotice> find(Users user);
	
	List<ProfileNotice> findAll(Users user, UserProfile userProfile);
}
