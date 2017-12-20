package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.StudentDAO;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for main operations
 * @author Justin Alderson
 * @since 28/11/2017
 */

//TODO Remove my user name password database name from properties.

public class Controller implements Initializable{

    private StudentDAO studentDAO;

    /**
     * Use this to set up the table for the database.
     * @param location url passed in.
     * @param resources resource bundle passed in.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Calling here to check if table exists.
        studentDAO = new StudentDAO();
        studentDAO.createIfNone();
    }

    @FXML
    private TextField name;

    @FXML
    public void myAction(){
        studentDAO.addNewStudent(name.getText().toLowerCase().trim());
    }


}
