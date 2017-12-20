package model;

import java.sql.*;

/**
 * Student database access object.
 * @author Justin Alderson
 * @since 28/11/2017
 */

public class StudentDAO extends BaseDAO {

    //TODO Remove my user name password database name from properties.

    public StudentDAO(){
        System.out.println("StudentDAO Instantiated");
    }

    /**
     * Create table if does not exist.
     */
    public void createIfNone(){

        boolean createTable = false;
        final String DATABASE_NAME= "my_students";
        final String CREATE_TABLE = "create table my_students ";
        final String ID = "(id integer not null auto_increment, ";
        final String NAME = "name varchar(255), ";
        final String PRIMARY_KEY =  "primary key (id))";

        System.out.println("StudentDAO called metaData();");
        try (Connection connection = this.getConnection()) {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("Checking metaData for table.");
            System.out.print("\n\n");


            //Find a list of all table contained on the MySQL database server using catalogs
            ResultSet resultSet = databaseMetaData.getCatalogs();
            System.out.println("Result Set returned.");
            System.out.println("Looping through Result Set.");
            System.out.print("\n\n");


            //Search for the name of table
            while(resultSet.next()){
                String catalogs = resultSet.getString(1);
                if(DATABASE_NAME.equals(catalogs)) {
                    System.out.print("\nDatabase exists.\n");
                    createTable = false;
                }else{
                    System.out.print("\nNo table of that name.\n");
                    createTable = true;
                    System.out.print("Variable createTable set: true");
                }
            }

            System.out.print("\n\n");
            if(createTable){
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE + ID + NAME + PRIMARY_KEY);
                preparedStatement.execute();
                System.out.print("\nPrepared Statement executed..");
                System.out.print("\nCreated new table.\n");
            }


        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }

    /**
     * Add a new student to our database.
     * @param studentName String of student name.
     */
    public void addNewStudent(String studentName) {
        final String INSERT = "insert into my_students ";
        final String NAME = "(name) ";
        final String VALUES = "values ";

        System.out.println("\nStudentDAO called newStudent();");
        try (Connection connection = this.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT + NAME + VALUES + "('" + studentName +"')");
            preparedStatement.execute();
            System.out.print("\nConnected to database!\nNew student was added successfully\n");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
}
