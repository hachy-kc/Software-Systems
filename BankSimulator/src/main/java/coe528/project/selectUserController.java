package coe528.project;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javafx.fxml.FXML;
import java.io.IOException;

/**
 *
 * @author stephen
 */
public class selectUserController {
    
    @FXML
    public void switchToManager() throws IOException{
        App.setRoot("managerLogin");
    }
    
    @FXML
    public void switchToCustomer() throws IOException{
        App.setRoot("customerLogin");
    }  
}
