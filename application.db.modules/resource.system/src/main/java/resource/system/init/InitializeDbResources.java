package resource.system.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import net.sourceforge.jaulp.lang.PropertiesUtils;

import org.apache.log4j.Logger;

public class InitializeDbResources {	
	/** The Constant logger. */
	protected static final Logger logger = Logger.getLogger(InitializeDbResources.class
			.getName());
	
	/**
	 * @param args
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static void main(final String[] args) throws ClassNotFoundException,
			SQLException, IOException {
		Properties dbProperties = PropertiesUtils.loadProperties("jdbc.properties");
		new DatabaseInitialization(dbProperties).initializeDatabase();
	}

}
