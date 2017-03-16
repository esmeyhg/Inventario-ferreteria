/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class Articulo {
  public SimpleStringProperty clave = new SimpleStringProperty();
  public SimpleStringProperty nombre = new SimpleStringProperty();
  public SimpleStringProperty descripcion = new SimpleStringProperty();
  public SimpleDoubleProperty precio = new SimpleDoubleProperty();
  public SimpleIntegerProperty existencia = new SimpleIntegerProperty();
  public SimpleStringProperty unidad = new SimpleStringProperty();
 
  
  /**
   * Constructor default
   */
  public Articulo () {
  }
  
  /**
   * Consstructor con los primeros 2 parametros (clave y nombre)
   * @param clave
   * @param nombre
   * @param descripcion
   * @param precio
   * @param existencia
   * @param unidad
   */
  public Articulo(String clave, String nombre, String descripcion, double precio,
      int existencia, String unidad) {
    this.clave = new SimpleStringProperty("");
    this.nombre= new SimpleStringProperty("");
    this.descripcion = new SimpleStringProperty("");
    this.precio = new SimpleDoubleProperty();
    this.existencia = new SimpleIntegerProperty();
    this.unidad = new SimpleStringProperty("");
  }
  
  /**
   * metodos set
   * @return 
   */
  public String getClave() {
    return clave.get();
  }
  
  public String getNombre() {
    return nombre.get();
  }
  
  public String getDescripcion() {
    return descripcion.get();
  }
  
  public double getPrecio() {
    return precio.get();
  }
  
  public int getExistencia() {
    return existencia.get();
  }
  
  public String getUnidad() {
    return unidad.get();
  }
  
  /**
   * métodos set
   * @param clave
   */
  public void setClave (String clave) {
    this.clave.set(clave);
  }
  
  public void setNombre (String nombre) {
    this.nombre.set(nombre);
  }
  
  public void setDescripcion (String descripcion) {
    this.descripcion.set(descripcion);
  }
  
  public void setPrecio (double precio) {
    this.precio.set(precio);
  }
  
  public void setExistencia (int existencia) {
    this.existencia.set(existencia);
  }
  
  public void setUnidad (String unidad) {
    this.unidad.set(unidad);
  }
  
  /**
   * métodos property
   * @return 
   */
  public StringProperty claveProperty(){
    return clave;
  }
  
  public StringProperty nombreProperty() {
    return nombre;
  }
  
  public StringProperty descripcionProperty(){
    return descripcion;
  }
  
  public DoubleProperty precioProperty() {
    return precio;
  }
  
  public IntegerProperty existenciaProperty() {
    return existencia;
  }
  
  public StringProperty unidadProperty() {
    return unidad;
  }
}
