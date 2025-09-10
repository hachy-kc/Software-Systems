package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Pair;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stephen
 */
public class MHSController {
    
    @FXML
    Label message = new Label();
    
    @FXML
    private void addCustomer() throws IOException{
        Dialog<Pair<String, String>> dialog = new Dialog();
        
        dialog.setTitle("Add Customer");
        dialog.setHeaderText("Enter New Customer Info");
        
        ButtonType create = new ButtonType("Create", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(create, ButtonType.CANCEL);
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("New Username");
        TextField passwordField = new TextField();
        passwordField.setPromptText("New Password");
       
        GridPane grid = new GridPane();
        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);
        
        dialog.getDialogPane().setContent(grid);
        
        dialog.showAndWait();
        
        if(FileManager.writeCustomer(usernameField.getText(), passwordField.getText(), 100, false)){
            message.setTextFill(Color.GREEN);
            message.setText("Customer Added");
        }
        
        else{
             message.setTextFill(Color.RED);
             message.setText("There was an error in creation");
        }
    }
    
    @FXML
    private void removeCustomer(){
        Dialog<Pair<String, String>> dialog = new Dialog();
        
        dialog.setTitle("Remove Customer");
        dialog.setHeaderText("Enter Name of Customer to Remove");
        
        ButtonType remove = new ButtonType("Remove", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(remove, ButtonType.CANCEL);
        
        TextField usernameField = new TextField();
        usernameField.setPromptText("Customer Username");
        
        dialog.getDialogPane().setContent(usernameField);
        
        dialog.showAndWait();
        
        if(FileManager.removeCustomer(usernameField.getText())){
            message.setTextFill(Color.GREEN);
            message.setText("Customer Removed");
        }
        
        else{
             message.setTextFill(Color.RED);
             message.setText("No Customer Found with this Name");
        }
    }
    
    @FXML
    private void logout() throws IOException{
        Manager manager = Manager.getInstance();
        manager.logout();
        App.setRoot("selectUser");
    }
}