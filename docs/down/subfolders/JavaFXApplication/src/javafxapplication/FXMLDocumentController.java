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
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class FXMLDocumentController implements Initializable {
  
    
  //Declaracion de botones
  @FXML private Button insertarBT;
  @FXML private Button editarBT;
  @FXML private Button eliminarBT;
  @FXML private Button nuevoBT;
  @FXML private Button volver;
  
  //Declaracion de textFields
  @FXML private TextField claveTF;
  @FXML private TextField nombreTF;
  @FXML private TextField descripcionTF;
  @FXML private TextField precioTF;
  @FXML private TextField existenciaTF;
  @FXML private TextField unidadTF;
  
  //Declaracion de tabla y columnas
  @FXML private TableView<Articulo> tablaArticulos;
  @FXML private TableColumn claveCL;
  @FXML private TableColumn nombreCL;
  @FXML private TableColumn descripcionCL;
  @FXML private TableColumn precioCL;
  @FXML private TableColumn existenciaCL;
  @FXML private TableColumn unidadCL;
  ObservableList<Articulo> articulos;
  
  private int posicionArticuloEnTabla;
  
  @FXML
  private void handleButtonAction(ActionEvent event) throws IOException {

  }
  
   @FXML
  private void regresar(ActionEvent r) throws IOException {
      Stage stage;
      Parent root;
      if(r.getSource()==volver){
        stage = new Stage();
        root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Menu");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage=(Stage)volver.getScene().getWindow();
        stage.close();
      } else {
        stage=(Stage)volver.getScene().getWindow();
        stage.close();
      }
  }
  
  /**
   * metodo para insertar un nuevo articulo
   * @param event al presionar el boton nuevo reaccionará
   */
  @FXML
  private void nuevo(ActionEvent e) {
    claveTF.setText("");
    nombreTF.setText("");
    descripcionTF.setText("");
    precioTF.setText("");
    existenciaTF.setText("");
    unidadTF.setText("");
    editarBT.setDisable(true);
    eliminarBT.setDisable(true);
    insertarBT.setDisable(false);
  }
  
  /**
   * metodo para insertar un articulo despues de clickear nuevo
   * @param event reaccionará ante un click a insertar
   */
  @FXML
  private void insertar(ActionEvent ev) {
    Articulo articulo = new Articulo();
    articulo.clave.set(claveTF.getText());
    articulo.nombre.set(nombreTF.getText());
    articulo.descripcion.set(descripcionTF.getText());
    articulo.precio.set(Double.parseDouble(precioTF.getText()));
    articulo.existencia.set(Integer.parseInt(existenciaTF.getText()));
    articulo.unidad.set(unidadTF.getText());
    
    articulos.add(articulo);  
  }
  
  /**
   * método que editará la información del articulo
   * @param event reaccionará al dar click en el boton editar
   */
  @FXML
  private void editar(ActionEvent eve) {
    Articulo articulo = new Articulo();
    articulo.clave.set(claveTF.getText());
    articulo.nombre.set(nombreTF.getText());
    articulo.descripcion.set(descripcionTF.getText());
    articulo.precio.set(Double.parseDouble(precioTF.getText()));
    articulo.existencia.set(Integer.parseInt(existenciaTF.getText()));
    articulo.unidad.set(unidadTF.getText());
    
    articulos.set(posicionArticuloEnTabla, articulo);

  }
  
  /**
   * metodo que eliminará un articulo de la tabla
   * @param event eliminará al dar click sobre boton eliminar
   */
  @FXML
  private void eliminar(ActionEvent even) {
    articulos.remove(posicionArticuloEnTabla);
  }
  
  /**
   * metodo para seleccionar una celda de la tabla
   * 
   */
  private final ListChangeListener<Articulo> selectorTablaArticulos =
      (ListChangeListener.Change<? extends Articulo> c) -> {
        ponerArticuloSeleccionado();
  };
  
  public Articulo getTablaArticulosSeleccionado() {
    if (tablaArticulos != null) {
      List<Articulo> tabla = tablaArticulos.getSelectionModel().getSelectedItems();
      if(tabla.size() == 1) {
        final Articulo competicionSeleccionada = tabla.get(0);
        return competicionSeleccionada;
      }
    }
    return null;
  }
  
  private void ponerArticuloSeleccionado() {
    final Articulo articulo = getTablaArticulosSeleccionado();
    posicionArticuloEnTabla = articulos.indexOf(articulo);
    
    if (articulo != null) {
      claveTF.setText(articulo.getClave());
      nombreTF.setText(articulo.getNombre());
      descripcionTF.setText(articulo.getDescripcion());
     // precioTF.setText(Double.toString().getClass().getMethod(articulo.getPrecio()));
     //existenciaTF.setText(Integer.toString(posicionArticuloEnTabla));
      unidadTF.setText(articulo.getUnidad());
      
      editarBT.setDisable(false);
      eliminarBT.setDisable(false);
      insertarBT.setDisable(true);
    }
  }

  private void inicializarTablaArticulos () {
    claveCL.setCellValueFactory(new PropertyValueFactory<>("clave"));
    nombreCL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    descripcionCL.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    precioCL.setCellValueFactory(new PropertyValueFactory<>("precio"));
    existenciaCL.setCellValueFactory(new PropertyValueFactory<>("existencia"));
    unidadCL.setCellValueFactory(new PropertyValueFactory<>("unidad"));
    
    articulos = FXCollections.observableArrayList();
    tablaArticulos.setItems(articulos);
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    this.inicializarTablaArticulos();
    
    editarBT.setDisable(true);
    eliminarBT.setDisable(true);
    
    final ObservableList<Articulo> tablaArticuloSel = tablaArticulos.getSelectionModel().getSelectedItems();
    tablaArticuloSel.addListener(selectorTablaArticulos);

      
    /*Articulo a1 = new Articulo();
      a1.clave.set(claveTF.getText());
      a1.nombre.set(nombreTF.getText());
      a1.descripcion.set(descripcionTF.getText());
      //a1.precio.set(Double.parseDouble(precioTF.getText()));
      //a1.existencia.set(Integer.parseInt(existenciaTF.getText()));
      a1.unidad.set(unidadTF.getText());
      articulos.add(a1);*/
    
  }  
  
}
