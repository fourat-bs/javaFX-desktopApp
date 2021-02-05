/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author moham
 */
public class AddorderController implements Initializable {

   @FXML
 private Button backBtn;
@FXML
private Button addBtn;
@FXML
private TextField txt1;
@FXML
private TextField txt2;
@FXML
private TextField txt3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
  private void add(ActionEvent event) throws IOException , ClassNotFoundException , SQLException
    {
        try {
        String url="jdbc:mysql://localhost:3308/eshop";
            String username="root";
            String password=""; 
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection connect = DriverManager.getConnection(url, username, password);
           PreparedStatement pst;            
         String sql="INSERT INTO orders (costumerid,itemid,quantity) VALUES ('"+Integer.parseInt(txt1.getText())+"', '"+Integer.parseInt(txt2.getText())+"','"+Integer.parseInt(txt3.getText())+"')";
                
              
                pst = connect.prepareStatement(sql);
                pst.executeUpdate(sql);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("order Successfuly Added !");
                alert.showAndWait();
                System.out.println("order added");
       
        Stage stage = new Stage();
        addBtn.getScene().getWindow().hide();
        Parent root1;
        root1 = FXMLLoader.load(getClass().getResource("/views/addorder.fxml"));
        Scene scene = new Scene(root1);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);



    }catch(Exception ex){
        System.out.println(ex);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Error!!");
                alert.showAndWait();
                System.out.println(ex);
    }

}
  @FXML
private void goback(ActionEvent e) throws IOException
    {
        Stage oitems = new Stage();
        backBtn.getScene().getWindow().hide();
        Parent root2;
        root2 = FXMLLoader.load(getClass().getResource("/views/orders.fxml"));
        Scene scene = new Scene(root2);
        oitems.setScene(scene);
        oitems.show();
        oitems.setResizable(false);
}
    
}
