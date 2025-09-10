/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Citizen Kane
 */
public class CustomerCostScreenController implements Initializable {
    @FXML
    private Label cost;
    @FXML
    private Label points;
    
    Main m = new Main();
    //put in abstract
    public void costMessage (User current,double money){
        cost.setText(current.getStats().cost(current, money));
    }
    //put in abstract
    public void pointsMessage (User current, double money){
        points.setText(current.getStats().standing(current, money));
    }
    
    public void clickLogout(ActionEvent e) throws IOException {
        m.changeScene("login.fxml");
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
        public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

}
