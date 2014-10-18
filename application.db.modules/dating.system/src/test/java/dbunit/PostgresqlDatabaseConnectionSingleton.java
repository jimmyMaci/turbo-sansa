package dbunit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.sourceforge.jaulp.jdbc.ConnectionsUtils;
import net.sourceforge.jaulp.lang.PropertiesUtils;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;

/**
 * The Class PostgresqlDatabaseConnectionSingleton holds an instance for the db
 * connection with dbunit for im- and export of a database.
 */
public final class PostgresqlDatabaseConnectionSingleton {

	/** The connection. */
	private static IDatabaseConnection connection;

	/**
	 * Gets the single instance of PostgresqlDatabaseConnectionSingleton.
	 *
	 * @return single instance of PostgresqlDatabaseConnectionSingleton
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static synchronized IDatabaseConnection getInstance()
			throws DatabaseUnitException, ClassNotFoundException, SQLException,
			IOException {
		if (connection == null) {
			connection = setFactory(getJdbcConnection());
		}
		return connection;
	}

	/**
	 * Gets the jdbc connection.
	 *
	 * @return the jdbc connection
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	protected static Connection getJdbcConnection() throws IOException,
			ClassNotFoundException, SQLException {
		Properties dbProperties = PropertiesUtils
				.loadProperties("project.properties");
		String dbHost = dbProperties.getProperty("jdbc.host");
		String dbName = dbProperties.getProperty("jdbc.db.name");
		String dbUser = dbProperties.getProperty("jdbc.user");
		String dbPassword = dbProperties.getProperty("jdbc.password");
		// Get jdbc connection...
		final Connection jdbcConnection = ConnectionsUtils
				.getPostgreSQLConnection(dbHost, dbName, dbUser, dbPassword);
		return jdbcConnection;
	}

	/**
	 * Gets a list with all postgresql enum names.
	 *
	 * @return the enum names
	 */
	protected static List<String> getEnumNames() {
		List<String> enumNames = new ArrayList<String>();
		enumNames.add("contactmethodtype");
		enumNames.add("educationstate");
		enumNames.add("figuretype");
		enumNames.add("friendshiprequeststate");
		enumNames.add("gendertype");
		enumNames.add("haircolortype");
		enumNames.add("intereststype");
		enumNames.add("messagestatetype");
		enumNames.add("messagetypetype");
		enumNames.add("visibilitytype");
		enumNames.add("relationshipstate");
		enumNames.add("smokerstatetype");
		enumNames.add("zodiacsigntype");
		enumNames.add("ruleviolationreasontype");
		return enumNames;
	}

	/**
	 * Sets the factory.
	 *
	 * @param jdbcConnection
	 *            the jdbc connection
	 * @return the i database connection
	 * @throws DatabaseUnitException
	 *             the database unit exception
	 */
	protected static IDatabaseConnection setFactory(
			final Connection jdbcConnection) throws DatabaseUnitException {
		// Create the dbunit database connection...
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
		// Get database configuration...
		DatabaseConfig dbConfig = connection.getConfig();
		// Override the method to get a valid result...
		PostgresqlDataTypeFactory factory = new PostgresqlDataTypeFactory() {
			public boolean isEnumType(String sqlTypeName) {
				for (String enumName : getEnumNames()) {
					if (sqlTypeName.equalsIgnoreCase(enumName)) {
						return true;
					}
				}
				return false;
			}
		};
		// set the appropriate DataTypeFactory...
		dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, factory);
		return connection;
	}
}
