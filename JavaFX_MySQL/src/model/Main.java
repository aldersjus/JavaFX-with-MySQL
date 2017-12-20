package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main entry point.
 * Program is an example of using MySQL with JavaFX
 * Relies on there being a MySQL Server on the local host.
 * Name of database, user and password need to be added to student.properties
 * Needs correct user name and password in the properties file.
 * @author Justin Alderson
 * @since 28/11/2017
 */

//TODO Remove my user name password database name from properties.

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/new_student.fxml"));
        primaryStage.setTitle("Enter New Student");
        Scene scene = new Scene(root, 500, 475);
        scene.getStylesheets().add(getClass().getResource("../view/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
