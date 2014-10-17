package flirt.and.date.hbm.enums;

/**
 * The Enum ApplicationRoles.
 */
public enum ApplicationRoles {

	/** The public. */
	PUBLIC(ApplicationRoles.PUBLIC_ROLE),
	/** The member. */
	MEMBER(ApplicationRoles.MEMBER_ROLE), 
	/** The premium member. */
	PREMIUM_MEMBER(ApplicationRoles.PREMIUM_MEMBER_ROLE),
	/** The root. */
	ROOT(ApplicationRoles.ROOT_ROLE);
	
	/** The Constant ROOT_ROLE. */
	private static final String ROOT_ROLE = "root";
	/** The Constant PROVIDER_ROLE. */
	private static final String MEMBER_ROLE = "member";
	
	/** The Constant SUBSCRIBER_ROLE. */
	private static final String PREMIUM_MEMBER_ROLE = "premium_member";

	/** The Constant PUBLIC_ROLE. */
	private static final String PUBLIC_ROLE = "public";
	/** The rolename. */
	private final String rolename;

	/**
	 * Instantiates a new application roles.
	 * 
	 * @param rolename
	 *            the rolename
	 */
	private ApplicationRoles(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * Gets the rolename.
	 * 
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

}
