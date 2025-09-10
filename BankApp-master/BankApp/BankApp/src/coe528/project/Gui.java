/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author josh
 */
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Gui extends Application {
    
    @Override
    public void start(Stage primaryStage){ 
        
        primaryStage.setTitle("Bank Application");
        Button login = new Button("Login");
        
         
        GridPane layout = new GridPane();
        layout.add(login, 0, 3);
       
        TextField user = new TextField("Username");
        Label userField = new Label("Username: ");
        
        TextField pw = new TextField("Password");
        Label pwField = new Label("Password: ");
        
        Label welcome = new Label("Josh's Bank");
        welcome.setFont(Font.font("Copperplate", FontWeight.NORMAL, 25));
        
        Label invalid = new Label("Invalid Login");
        
        
        //positioning on the grid
        layout.setAlignment(Pos.CENTER);
        //layout.add(userField, 0 ,1);
        layout.add(user, 0, 1);
        layout.add(pw, 0, 2);
        //layout.add(pwField, 0, 2);
        layout.add(welcome , 0 , 0);
        
        
        
        //We create a manager to authenticate the initial logins
        Manager josh = new Manager();
        
        login.setOnAction(new EventHandler<ActionEvent>(){
        
            @Override
            public void handle(ActionEvent event){
                String username = user.getText();
                String password = pw.getText();

                if (username.equals("admin") && password.equals("admin")){
                    managerWindow(primaryStage, josh); //if a manager logs in this takes them to the manager screen
                    System.out.println("Got here");
                    
                } else if (josh.verify(username, password)){ //will create a verify method in the manager class to check for login credentials
                    customerWindow(primaryStage, josh);
                    System.out.println("Got here logged in");
                } 
                  else{
                    System.out.println("Invalid Login");
                    layout.add(invalid, 1, 3);
                }
            }
        });
        
        Scene scene = new Scene(layout, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public void managerWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        Label welcomeManager = new Label("For Manager Use only");
        Label optionText = new Label("Here are your managerial options: ");
        
        Button addButton = new Button("Add Customer");
        Button deleteButton = new Button("Delete Customer");
        Button logoutButton = new Button("Logout");
        welcomeManager.setFont(Font.font("Copperplate", FontWeight.NORMAL, 25));

        
        GridPane managerPane = new GridPane();
        managerPane.setAlignment(Pos.CENTER);
        managerPane.add(welcomeManager ,0 ,0);
        managerPane.add(optionText, 0, 1);
        managerPane.add(addButton, 0, 2);
        managerPane.add(deleteButton, 0, 3);
        managerPane.add(logoutButton, 0, 4);
        
        addButton.setOnAction((ActionEvent e)->{
        addCustomerWindow(primaryStage, josh);
        });
        
        deleteButton.setOnAction((ActionEvent e)->{
        deleteCustomerWindow(primaryStage, josh); 
        });
       
        logoutButton.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        Scene scene = new Scene(managerPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
       
        
    }
    
    public void addCustomerWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        Label user = new Label("First Name: ");
        TextField userField = new TextField();
        Label pass = new Label("Last Name: ");
        TextField passField = new TextField();
        
        Button addC = new Button("Add");
        Button backButton = new Button("Back");
        
        Label addedText = new Label("Customer Added!");
        
        GridPane addPane = new GridPane();
        
        addC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userField.getText();
                String password = passField.getText();
                if (username != null && password != null) {
                    josh.addCustomer(username, password);
                    addPane.add(addedText, 1, 3);
                }
                else {
                    System.out.println("urname and pw gotta be right");
                }
            }
        });
        
        backButton.setOnAction((ActionEvent e) -> {
            managerWindow(primaryStage, josh);
        });
        
        
        addPane.setAlignment(Pos.CENTER);
        addPane.add(user, 0, 1);
        addPane.add(userField, 1, 1);
        addPane.add(pass, 0, 2);
        addPane.add(passField, 1, 2);
        addPane.add(addC, 0,3);
        addPane.add(backButton, 0, 4);
        
        Scene scene = new Scene(addPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void deleteCustomerWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        Label user = new Label("First Name: ");
        TextField userField = new TextField();
        Label pass = new Label("Last Name: ");
        TextField passField = new TextField();
        
        Button deleteC = new Button("Delete");
        Button backButton = new Button("Back");
        
        Label deleteText = new Label("Customer Deleted");
        
        GridPane addPane = new GridPane();

        
        deleteC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = userField.getText();
                String password = passField.getText();
                if (username != null && password != null) {
                    josh.deleteCustomer(username, password);
                    addPane.add(deleteText, 1, 3);
                }
                else {
                    System.out.println("urname and pw gotta be right");
                }
            }
        });
        
        backButton.setOnAction((ActionEvent e) -> {
            managerWindow(primaryStage, josh);
        });
        
        addPane.setAlignment(Pos.CENTER);
        addPane.add(user, 0, 1);
        addPane.add(userField, 1, 1);
        addPane.add(pass, 0, 2);
        addPane.add(passField, 1, 2);
        addPane.add(deleteC, 0,3);
        addPane.add(backButton, 0, 4);
        
        Scene scene = new Scene(addPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void customerWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        
        Button logoutButton = new Button("Logout");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Button purchaseButton = new Button("Purchase");
        
        Label welcomeText = new Label("Welcome to your account.");
        Label balLabel = new Label("Balance: "+ josh.getBalance());
        welcomeText.setFont(Font.font("Copperplate", FontWeight.NORMAL, 15));

        
        GridPane customerGrid = new GridPane();
        customerGrid.add(logoutButton, 0,4);
        
        withdrawButton.setOnAction((ActionEvent e) -> { //using lambda notation
            withdrawWindow(primaryStage, josh);
        });
        
        depositButton.setOnAction((ActionEvent e) -> {
            depositWindow(primaryStage, josh);
        });
        
        purchaseButton.setOnAction((ActionEvent e) -> {
            purchaseWindow(primaryStage, josh);
        });
        
        logoutButton.setOnAction((ActionEvent e) -> {
            start(primaryStage);
        });
        
        
         balLabel.setFont(Font.font("Copperplate", FontWeight.NORMAL, 15));

        customerGrid.setAlignment(Pos.CENTER);
        customerGrid.add(welcomeText, 0,0);
        customerGrid.add(depositButton, 0,1);
        customerGrid.add(withdrawButton, 0, 2);
        customerGrid.add(purchaseButton, 0, 3);
        customerGrid.add(balLabel, 2, 1);
        
        
        Scene scene = new Scene(customerGrid, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void withdrawWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        GridPane withdrawPane = new GridPane();
        
        Label withdrawText = new Label("Withdrawls");
                
        
        Button back = new Button("Back");
        Button withdraw = new Button("Widthdraw");
        
        TextField withdrawField = new TextField();
        
        Label levelLabel = new Label("Level: " + josh.level());
        Label balLabel = new Label("Balance: "+ josh.getBalance());
        
        withdraw.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
              int amount = Integer.parseInt(withdrawField.getText());
              if (josh.withdraw(amount)){
                  levelLabel.setText("Level: " + josh.level());
                  balLabel.setText("Balance: " + josh.getBalance());   
              }else{
                  Alert notEnough = new Alert(AlertType.WARNING);
                  notEnough.setTitle("WARNING");
                  notEnough.setContentText("Low on funds/Not enough");
              }
                  
            }
        
        });
        
        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, josh);
        });
        
        withdrawPane.setAlignment(Pos.CENTER);
        withdrawPane.add(back, 0, 4);
        withdrawPane.add(withdraw,0,1);
        withdrawPane.add(withdrawText, 0, 0);
        withdrawPane.add(withdrawField, 1,1);
        withdrawPane.add(levelLabel, 2, 1);
        withdrawPane.add(balLabel, 1, 2);
        
        Scene scene = new Scene(withdrawPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
    public void depositWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        GridPane depositPane = new GridPane();
        
        Label depositText = new Label("Deposit");
                
        
        Button back = new Button("Back");
        Button deposit = new Button("Deposit");
        
        TextField depositField = new TextField();
        
        Label levelLabel = new Label("Level: " + josh.level());
        Label balLabel = new Label("Balance: "+ josh.getBalance());
        
        deposit.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
              int amount = Integer.parseInt(depositField.getText());
              josh.deposit(amount);
              levelLabel.setText("Level: "+ josh.level());
              balLabel.setText("Account Balance: " + josh.getBalance());
              }
                  
            });
        
        
        
        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, josh);
        });
        
        depositPane.setAlignment(Pos.CENTER);
        depositPane.add(back, 0, 4);
        depositPane.add(deposit,0,1);
        depositPane.add(depositText, 0, 0);
        depositPane.add(depositField, 1,1);
        depositPane.add(levelLabel, 2, 1);
        depositPane.add(balLabel, 1, 2);
        
        Scene scene = new Scene(depositPane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void purchaseWindow(Stage primaryStage, Manager a){
        Manager josh = a;
        GridPane purchasePane = new GridPane();
        
        Label purchaseText = new Label("Enter the amount to purchase");
                
        
        Button back = new Button("Back");
        Button purchase = new Button("Purchase");
        
        TextField purchaseField = new TextField();
        
        Label levelLabel = new Label("Level: " + josh.level());
        Label balLabel = new Label("Balance: "+ josh.getBalance());
       
        
        purchase.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
              int amount = Integer.parseInt(purchaseField.getText());
              if (josh.purchase(amount)){
                  levelLabel.setText("Level: " + josh.level());
                  balLabel.setText("Balance: " + josh.getBalance());   
              }else{
                  Alert notEnough = new Alert(AlertType.WARNING);
                  notEnough.setTitle("WARNING");
                  notEnough.setContentText("Low on funds/Not enough");
              }
                  
            }
        
        });
        
        back.setOnAction((ActionEvent e) -> {
            customerWindow(primaryStage, josh);
        });
        
        purchasePane.setAlignment(Pos.CENTER);
        purchasePane.add(back, 0, 4);
        purchasePane.add(purchase,0,1);
        purchasePane.add(purchaseText, 1, 0);
        purchasePane.add(purchaseField, 1,1);
        purchasePane.add(levelLabel, 2, 1);
        purchasePane.add(balLabel, 1, 2);
        
        Scene scene = new Scene(purchasePane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.show();  
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    
    
}
