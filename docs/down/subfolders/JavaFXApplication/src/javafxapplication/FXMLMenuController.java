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
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class FXMLMenuController implements Initializable {
  
  @FXML private Button art;
  @FXML private Button vent;
  
  @FXML
  private void gotoArticulos(ActionEvent a) throws IOException {
    Stage stage;
    Parent root;
    if(a.getSource()==art){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Inventario");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(art.getScene().getWindow());
      stage.showAndWait();
      stage.close();
    } else {
      stage=(Stage)art.getScene().getWindow();
      stage.close();
    }
  }
  
  @FXML
  private void gotoVentas(ActionEvent v) throws IOException {
    Stage stage;
    Parent root;
    if(v.getSource()==vent){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("FXMLVentas.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Ventas");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(vent.getScene().getWindow());
      stage.showAndWait();
    } else {
      stage=(Stage)art.getScene().getWindow();
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
