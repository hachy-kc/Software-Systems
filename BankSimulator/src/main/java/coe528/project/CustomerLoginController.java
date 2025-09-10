package coe528.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CustomerLoginController {

    @FXML
    private TextField usernameBox; 
    
    @FXML
    private Label errorMessage;
      
    @FXML
    private void checkPassword(){
        String username = usernameBox.getText();
        
        if (username.isEmpty()) {
            errorMessage.setText("Username cannot be empty");
            return;
        }
        
        if (username.equals("monica")){
            errorMessage.setText("");
            System.out.println("dap me up shlime, u right");
        } else {
            errorMessage.setText("Incorrect Username");
        }
    }
    
    @FXML
    public void mainScreen() throws IOException{
        App.setRoot("selectUser");
    }
}