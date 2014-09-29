package de.alpharogroup.scheduler.system.init;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import net.sourceforge.jaulp.lang.PropertiesUtils;

import org.apache.log4j.Logger;


public class InitializeDbScheduler {	
	/** The Constant logger. */
	protected static final Logger logger = Logger.getLogger(InitializeDbScheduler.class
			.getName());

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		Properties dbProperties = PropertiesUtils.loadProperties("jdbc.properties");
		new DatabaseInitialization(dbProperties).initializeDatabase();
	}

}
