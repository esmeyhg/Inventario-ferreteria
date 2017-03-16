/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class FXMLVentasController implements Initializable {
  
  //Declaracion de botones
  @FXML private Button comprarBT;
  @FXML private Button agregarBT;
  @FXML private Button eliminarBT;
  @FXML private Button editarBT;
  @FXML private Button regresarBT;
  
  //Declaracion de textFields
  @FXML private TextField fechaTF;
  @FXML private TextField claveTF;
  @FXML private TextField nombreTF;
  @FXML private TextField cantidadTF;
  @FXML private TextField precioTF;
  @FXML private TextField totalTF;
  
  //Declaracion de tabla y de columnas
  @FXML private TableView<Ventas> tablaVentas;
  @FXML private TableColumn claveCL;
  @FXML private TableColumn nombreCL;
  @FXML private TableColumn cantidadCL;
  @FXML private TableColumn precioCL;
  @FXML private TableColumn netoCL;
  ObservableList<Ventas> ventas;
  
  private int posicion;
  
    @FXML
  private void regresarWindows(ActionEvent rw) throws IOException {
    Stage stage;
    Parent root;
    if(rw.getSource()==regresarBT){
      stage = new Stage();
      root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
      stage.setScene(new Scene(root));
      stage.setTitle("Menu");
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.initOwner(regresarBT.getScene().getWindow());
      stage.showAndWait();
    } else {
      stage=(Stage)regresarBT.getScene().getWindow();
      stage.close();
    }
  }
  
  @FXML
  private void realizarVenta(ActionEvent rv) throws IOException {
    Ventas venta = new Ventas();
    venta.claveventa.set(claveTF.getText());
    venta.nombreventa.set(nombreTF.getText());
    venta.cantidad.set(Integer.parseInt(cantidadTF.getText()));
    venta.precio.set(Double.parseDouble(precioTF.getText()));
    venta.total.set(Double.parseDouble(totalTF.getText()));
    venta.fecha.set(fechaTF.getText());
    
    ventas.add(venta); 
    ventas.set(posicion,venta);
  }
  
  @FXML
  private void editarVenta(ActionEvent eventa) {
    Ventas venta = new Ventas();
    venta.claveventa.set(claveTF.getText());
    venta.nombreventa.set(nombreTF.getText());
    venta.cantidad.set(Integer.parseInt(cantidadTF.getText()));
    venta.precio.set(Double.parseDouble(precioTF.getText()));
    venta.total.set(Double.parseDouble(totalTF.getText()));
    venta.fecha.set(fechaTF.getText());
    
    ventas.set(posicion, venta);
  }
  
  @FXML
  private void eliminarVenta(ActionEvent elv) {
    ventas.remove(posicion);
  }
  
  private final ListChangeListener<Ventas> selectorTablaVentas =
      (ListChangeListener.Change<? extends Ventas> c) -> {
        ponerVentasSeleccionado();
  };
  
  public Ventas getTablaVentasSeleccionado() {
    if (tablaVentas != null) {
      List<Ventas> tabla = tablaVentas.getSelectionModel().getSelectedItems();
      if(tabla.size() == 1) {
        final Ventas competicionSeleccionada = tabla.get(0);
        return competicionSeleccionada;
      }
    }
    return null;
  }
  
  private void ponerVentasSeleccionado() {
    final Ventas vendido = getTablaVentasSeleccionado();
    posicion = ventas.indexOf(vendido);
    
    if (vendido != null) {
      claveTF.setText(vendido.getClaveventa());
      nombreTF.setText(vendido.getNombreventa());
     //descripcionTF.setText(articulo.getDescripcion());
     // precioTF.setText(Double.toString().getClass().getMethod(articulo.getPrecio()));
     //existenciaTF.setText(Integer.toString(posicionArticuloEnTabla));
      fechaTF.setText(vendido.getFecha());
      
      editarBT.setDisable(false);
      eliminarBT.setDisable(false);
      agregarBT.setDisable(true);
    }
  }

  private void inicializarTablaVentas () {
    claveCL.setCellValueFactory(new PropertyValueFactory<>("clave"));
    nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    cantidadCL.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
    precioCL.setCellValueFactory(new PropertyValueFactory<>("precio"));
    netoCL.setCellValueFactory(new PropertyValueFactory<>("neto"));
    
    ventas = FXCollections.observableArrayList();
    tablaVentas.setItems(ventas);
  }
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.inicializarTablaVentas();
    
    editarBT.setDisable(false);
    eliminarBT.setDisable(false);
    
    final ObservableList<Ventas> tablaVentasSel = tablaVentas.getSelectionModel().getSelectedItems();
    tablaVentasSel.addListener(selectorTablaVentas);
  }  
  
}
