/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Citizen Kane
 */
public class OwnerCustomersScreenController implements Initializable {
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> usernameColumn;
    @FXML
    private TableColumn<User, String> passwordColumn;
    @FXML
    private TableColumn<User, Integer> pointsColumn;
    @FXML
    private TextField username;  
    @FXML
    private TextField password;
    
    Main m = new Main();
    User enter = new User();
    database customerTxtFile = database.getInstance();
    
    public void clickBack(ActionEvent e) throws IOException {
        m.changeScene("ownerStartScreen.fxml");
    }
    public void clickAdd(ActionEvent e) throws IOException {        
        enter = new User (username.getText(),password.getText());  
        if (enter.findUser(username.getText()) == null && !username.getText().isEmpty()){
            enter.register(enter);
            customerTxtFile.updateCustomerList(enter.getList());
            m.changeScene("ownerCustomersScreen.fxml");
        }        
        
        
    }
    public void clickDelete(ActionEvent e) throws IOException {
        enter.unregister(table.getSelectionModel().getSelectedItem());
        customerTxtFile.updateCustomerList(enter.getList());
        m.changeScene("ownerCustomersScreen.fxml");  
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<> ("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<> ("password"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<> ("points"));//it works now don't know why
        table.setItems(getUser());
    }    

    private ObservableList<User> getUser() {
        enter.users = customerTxtFile.loadCustomer();
        ObservableList<User> users = FXCollections.observableArrayList(enter.getList());
        return users;
    }
    
}