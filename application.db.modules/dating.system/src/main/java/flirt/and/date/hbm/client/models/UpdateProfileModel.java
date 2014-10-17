package flirt.and.date.hbm.client.models;

import user.management.model.Users;

public class UpdateProfileModel extends ProfileModel {
	
	private Users profileVisitor;

	private static final long serialVersionUID = 1L;

	public Users getProfileVisitor() {
		return profileVisitor;
	}

	public void setProfileVisitor(Users profileVisitor) {
		this.profileVisitor = profileVisitor;
	}

}
