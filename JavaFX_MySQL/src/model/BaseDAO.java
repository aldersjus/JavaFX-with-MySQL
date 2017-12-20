package model;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * BaseDAO class to be extended by DAOs to access database.
 * @author Justin Alderson
 * @since 28/11/2017
 */

//TODO Remove my user name password database name from properties.

class BaseDAO implements DAO {

    BaseDAO() {
        System.out.println("BaseDAO Instantiated");
    }

    /**
     * Connects to the database.
     * @return Connection
     */


    ///Using properties file for getting info to connect to database.
    @Override
    public Connection getConnection() throws SQLException{
        String dburl = null;
        String theUser;
        String thePassword;
        Properties properties = null;
        System.out.println("BaseDAO called getConnection();");
        try {
            ///Create the properties.
            properties = new Properties();
            ///Load file from it's location, use whatever path as per location.
            properties.load(new FileInputStream("student.properties"));
            System.out.println("File Read");

            //get the details
            theUser = properties.getProperty("user");
            thePassword = properties.getProperty("password");
            dburl = properties.getProperty("dburl");
            properties.getProperty("useSSL");
            properties.getProperty("autoReconnect");

            System.out.println("user = " + theUser);
            System.out.println("password = " + thePassword);
            System.out.println("dburl = " + dburl);

            System.out.println("BaseDAO Connection Using Properties File");

        }catch (Exception e){
            System.out.println("BaseDAO called getConnection(); Exception " + e.getMessage());
        }

        return DriverManager.getConnection(dburl,properties);

    }

}