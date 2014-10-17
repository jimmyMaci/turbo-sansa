package flirt.and.date.hbm.service.utils;

import user.management.model.Users;
import flirt.and.date.hbm.enums.FriendshipRequestsState;
import flirt.and.date.hbm.model.UserProfile;

public class HqlStringCreator {

	public static String forFriendshipRequests(Users requestor,
			Users requestedUser, FriendshipRequestsState state) {
		StringBuilder sb = new StringBuilder();
		sb.append("select fr from FriendshipRequests fr");
		boolean requestorIsNotNull = requestor != null;
		if (requestorIsNotNull) {
			sb.append(" ");
			sb.append("where fr.requestor=:requestor");
		}
		boolean requestedUserIsNotNull = requestedUser != null;
		if (requestedUserIsNotNull) {
			sb.append(" ");
			if (requestorIsNotNull) {
				sb.append("and fr.requestedUser=:requestedUser");
			} else {
				sb.append("where fr.requestedUser=:requestedUser");
			}
		}
		boolean stateIsNotNull = state != null;
		if (stateIsNotNull) {
			sb.append(" ");
			if (!requestorIsNotNull && !requestedUserIsNotNull) {
				sb.append("where fr.state=:state");
			} else {
				sb.append("and fr.state=:state");
			}
		}
		return sb.toString();
	}

	public static String forFavoriteMembers(Users owner, UserProfile favorite) {
		StringBuilder sb = new StringBuilder();
		sb.append("select fm from FavoriteMembers fm");
		boolean ownerIsNotNull = owner != null;
		if (ownerIsNotNull) {
			sb.append(" ");
			sb.append("where fm.owner=:owner");

		}
		boolean favoriteIsNotNull = favorite != null;
		if (favoriteIsNotNull) {
			sb.append(" ");
			if (ownerIsNotNull) {
				sb.append("and fm.favorite=:favorite");
			} else {
				sb.append("where fm.favorite=:favorite");
			}
		}
		return sb.toString();
	}

	public static String forProfileNotice(Users user, UserProfile userProfile) {
		StringBuilder sb = new StringBuilder();
		sb.append("select pr from ProfileNotice pr");
		boolean ownerIsNotNull = user != null;
		if (ownerIsNotNull) {
			sb.append(" ");
			sb.append("where pr.user=:user");

		}
		boolean favoriteIsNotNull = userProfile != null;
		if (favoriteIsNotNull) {
			sb.append(" ");
			if (ownerIsNotNull) {
				sb.append("and pr.userProfile=:userProfile");
			} else {
				sb.append("where pr.userProfile=:userProfile");
			}
		}
		return sb.toString();
	}

	public static String forProfileVisitors(Users visitor,
			UserProfile visitedProfile) {
		StringBuilder sb = new StringBuilder();
		sb.append("select pv from ProfileVisitors pv");
		boolean ownerIsNotNull = visitor != null;
		if (ownerIsNotNull) {
			sb.append(" ");
			sb.append("where pv.visitor=:visitor");

		}
		boolean favoriteIsNotNull = visitedProfile != null;
		if (favoriteIsNotNull) {
			sb.append(" ");
			if (ownerIsNotNull) {
				sb.append("and pv.visitedProfile=:visitedProfile");
			} else {
				sb.append("where pv.visitedProfile=:visitedProfile");
			}
		}
		return sb.toString();
	}

	public static String forUserProfile(Users user) {
		StringBuilder sb = new StringBuilder();
		sb.append("select pr from UserProfile pr");
		boolean userIsNotNull = user != null;
		if (userIsNotNull) {
			sb.append(" ");
			sb.append("where pr.user=:user");
		}
		return sb.toString();
	}

}
