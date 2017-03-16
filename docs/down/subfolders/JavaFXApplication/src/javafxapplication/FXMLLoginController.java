/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class FXMLLoginController implements Initializable {
  
  @FXML private Button login;
  @FXML private TextField userTF;
  @FXML private TextField passTF;
  
  @FXML
  private void ingresar(ActionEvent event) throws IOException {
    Stage stage;
    Parent root;
    if(event.getSource()==login){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Menu");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(login.getScene().getWindow());
      stage.showAndWait();
    } else {
      stage=(Stage)login.getScene().getWindow();
      stage.close();
    }
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
