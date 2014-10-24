package events.system.init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import hbm.init.AbstractDatabaseInitialization;

public class DatabaseInitialization extends AbstractDatabaseInitialization {

	public DatabaseInitialization(Properties databaseProperties) {
		super(databaseProperties);
	}

	@Override
	protected List<File> getScriptFiles() {
		final File insertsDir = getInsertDir();
		List<File> scriptFiles = new ArrayList<>();		
		scriptFiles.add(new File(insertsDir, "insertRoles.sql"));
		scriptFiles.add(new File(insertsDir, "insertIntoTopics.sql"));
		scriptFiles.add(new File(insertsDir, "insertCountries.sql"));
		scriptFiles.add(new File(insertsDir, "insertAllFederalStates.sql"));
		return scriptFiles;
	}

}
