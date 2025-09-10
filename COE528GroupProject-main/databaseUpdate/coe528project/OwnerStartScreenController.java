/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import javafx.event.ActionEvent;



/**
 * FXML Controller class
 *
 * @author Citizen Kane
 */
public class OwnerStartScreenController{
    
    
    Main m = new Main();
    
    public void clickBooks(ActionEvent e) throws IOException {
        m.changeScene("ownerBooksScreen.fxml");
    }
    
    public void clickCustomers(ActionEvent e) throws IOException {
        m.changeScene("ownerCustomersScreen.fxml");
    }
    
    public void clickLogout(ActionEvent e) throws IOException {
        m.changeScene("login.fxml");
    }
}
