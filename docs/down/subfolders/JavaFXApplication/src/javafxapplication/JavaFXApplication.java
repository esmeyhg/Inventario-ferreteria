/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class JavaFXApplication extends Application {
  
  @Override
  public void start(Stage stage) throws Exception {
    Parent pane = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
    
    Scene scene = new Scene(pane);
    
    stage.setTitle("**Sistema Inventario**");
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
