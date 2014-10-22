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
		List<File> scriptFiles = new ArrayList<>();
		return scriptFiles;
	}

}
