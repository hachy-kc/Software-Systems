package coe528project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Citizen Kane 
 */
public class loginController {
    @FXML 
    private TextField username;
    @FXML 
    private PasswordField password;
    @FXML 
    private Label loginMessage;
    /**
     * Initializes the controller class.
     * @param e
     * @throws java.io.IOException
     */
    User current = new User();
    CustomerStartScreenController input;
    database x = database.getInstance();
    
    public void checkLogin(ActionEvent e) throws IOException {
        Main m = new Main();
        User.users = x.loadCustomer();
//        x.updateCustomerList(User.users);
        if ((username.getText().equals("admin"))&&(password.getText().equals("admin"))){
            m.changeScene("ownerStartScreen.fxml");
        }
        //different because I have to pass stuff through
        else if (current.login(username.getText(), password.getText())){
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("customerStartScreen.fxml")); 
            Parent customerParent = loader.load();
            Scene customerScene = new Scene(customerParent);
            CustomerStartScreenController controller = loader.getController();
            controller.welcomeMessage(username.getText());
            Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
            window.setScene(customerScene);
            window.show();
        }
        else{
            loginMessage.setText("Wrong Username and/or Password");
        }            
    }    
    
}

