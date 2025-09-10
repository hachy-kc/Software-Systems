package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class ManagerLoginController {

    @FXML
    private TextField usernameBox; 
    
    @FXML
    private PasswordField passwordBox;
    
    @FXML
    private Label errorMessage;
     
    @FXML
    private void checkPassword() throws IOException{
        String username = usernameBox.getText();
        String password = passwordBox.getText();
        
        Manager manager = Manager.getInstance();
        
        if (manager.login(username, password)){
            App.setRoot("managerHomeScreen");
        }
        
        else
            errorMessage.setText("Username or Password is Incorrect");
    }
    
    @FXML
    public void mainScreen() throws IOException{
        App.setRoot("selectUser");
    }
}