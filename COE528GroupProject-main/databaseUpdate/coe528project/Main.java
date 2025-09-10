/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import java.util.ArrayList;

/**
 *
 * @author Citizen Kane
 */
public class Main extends Application {
    
    private static Stage bookstore;
    static database x = database.getInstance();
    
    @Override
    public void start(Stage stage) throws Exception {
        bookstore = stage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("ownerStartScreen.fxml"));
        Scene scene = new Scene(root);
        Image logo = new Image("library.jpg");
        stage.getIcons().add(logo);
        stage.setTitle("Bookstore App");
        stage.setScene(scene);
        stage.show();
    }

    void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        bookstore.getScene().setRoot(pane);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        
        launch(args);
    }
    
}
