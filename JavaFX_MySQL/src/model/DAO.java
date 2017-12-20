package model;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * interface DAO access
 * @author Justin Alderson
 * @since 28/11/2017
 */
public interface DAO {
    Connection getConnection() throws SQLException;
}
