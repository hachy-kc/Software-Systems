/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528project;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Citizen Kane
 */
public class OwnerBooksScreenController implements Initializable{
    @FXML
    private TableView<Book> Table;
    @FXML
    private TableColumn<Book, String> Names;
    @FXML
    private TableColumn<Book, Double> Prices;
    @FXML
    private TextField Name;  
    @FXML
    private TextField Price; 
    Main m = new Main();
    Book enter = new Book();
    
    public void clickBack(ActionEvent e) throws IOException {
        m.changeScene("ownerStartScreen.fxml");
    }
    
    public void clickAdd(ActionEvent e) throws IOException {
        enter = new Book (Name.getText(),Double.parseDouble(Price.getText()));  
        enter.add(enter);
        m.changeScene("ownerBooksScreen.fxml");
        //Table.getItems().add(enter);
    }
    
    public void clickDelete (ActionEvent e) throws IOException {
        enter.delete(Table.getSelectionModel().getSelectedItem());
        m.changeScene("ownerBooksScreen.fxml");        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Names.setCellValueFactory(new PropertyValueFactory<> ("bookName"));
        Prices.setCellValueFactory(new PropertyValueFactory<> ("bookPrice"));
        
        Table.setItems(getBook());
    }
     
    public ObservableList<Book> getBook(){
        ObservableList<Book> books = FXCollections.observableArrayList(enter.getList());
        return books;
    }
}
