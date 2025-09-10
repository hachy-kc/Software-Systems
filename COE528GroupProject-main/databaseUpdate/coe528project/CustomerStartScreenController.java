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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Citizen Kane
 */
public class CustomerStartScreenController implements Initializable {
    @FXML
    private TableView<Book> table;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<User, Double> priceColumn;
    @FXML
    private TableColumn<User, CheckBox> selectColumn;
    @FXML
    private Label customerGreeting;
    
    Main m = new Main();
    Book enter = new Book();
    User current = new User ();
    double cost = 0;
    database x = database.getInstance();
    
    public void welcomeMessage (String username){
        current = current.findUser(username);
        customerGreeting.setText("Welcome " + current.getUsername() + ". You have " + current.getPoints() + " points. Your status is " + current.getStatus()+ ".");
    }
    
    public void clickLogout(ActionEvent e) throws IOException {
        m.changeScene("login.fxml");
    }
     public void clickBuy(ActionEvent e) throws IOException {//pass in cost to the first and second method also true for second method and current
        cost = getBook().stream().filter((cycle) -> (cycle.getRemark().isSelected())).map((cycle) -> cycle.getBookPrice()).reduce(cost, (accumulator, _item) -> accumulator + _item);
        /*
        for (Book cycle : getBook()){
            if (cycle.getRemark().isSelected()){
                cost += cycle.getBookPrice();
            }
        }
        */
        
        current.setStats1();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerCostScreen.fxml")); 
        Parent customerCostParent = loader.load();
        Scene customerCostScene = new Scene(customerCostParent);
        CustomerCostScreenController controller = loader.getController();
        controller.costMessage(current,cost);
        controller.pointsMessage(current,cost);
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.setScene(customerCostScene);
        window.show();
    }
    public void clickRedeem(ActionEvent e) throws IOException {//pass in 0 for first method and cost for second with false also current for user
        cost = getBook().stream().filter((cycle) -> (cycle.getRemark().isSelected())).map((cycle) -> cycle.getBookPrice()).reduce(cost, (accumulator, _item) -> accumulator + _item);
        current.setStats2();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("customerCostScreen.fxml")); 
        Parent customerCostParent = loader.load();
        Scene customerCostScene = new Scene(customerCostParent);
        CustomerCostScreenController controller = loader.getController();
        //
        controller.costMessage(current, cost);
        controller.pointsMessage(current,cost);
        Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
        window.setScene(customerCostScene);
        window.show();
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameColumn.setCellValueFactory(new PropertyValueFactory<> ("bookName"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<> ("bookPrice"));
        selectColumn.setCellValueFactory(new PropertyValueFactory<> ("remark"));
        table.setItems(getBook());
    }    
    
    public ObservableList<Book> getBook(){
        ObservableList<Book> books = FXCollections.observableArrayList(enter.getList());
        return books;
    }
}