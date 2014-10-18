package events.system.enums;

public enum Difficulty {

	BEGINNER, ADVANCED, EXPERT;

	/** The resource key. */
	private String resourceKey = "difficulty.level." + this.name();

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public String getId() {
		return this.name();
	}

	/**
	 * Gets the level.
	 * 
	 * @return the level
	 */
	public String getLevel() {
		return this.name();
	}

	/**
	 * Gets the resource key.
	 * 
	 * @return the resource key
	 */
	public String getResourceKey() {
		return resourceKey;
	}
}
