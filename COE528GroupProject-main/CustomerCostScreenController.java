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
import java.lang.Math;

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
    
    public void costMessage (double money){
        cost.setText("Total Cost: $" + money);
    }
    
    public void pointsMessage (User current, double money, boolean operation){//boolean to switch between buy and redeem
        if (operation == true){
            current.setPoints((int) (current.getPoints() + Math.round(money * 10)));
        }
        else{
            if (current.getPoints()>=money*10){
                current.setPoints((int) (current.getPoints() - Math.round(money * 10)));
            }
            else{
                costMessage(money-current.getPoints()/10);
                current.setPoints(0);
            }
        }
        points.setText("Points: " + current.getPoints() + ", Status: " + current.getStatus());
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
