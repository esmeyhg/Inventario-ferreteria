/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Ventas {
  public SimpleStringProperty claveventa = new SimpleStringProperty();
  public SimpleStringProperty nombreventa = new SimpleStringProperty();
  public SimpleIntegerProperty cantidad = new SimpleIntegerProperty();
  public SimpleDoubleProperty precio = new SimpleDoubleProperty();
  public SimpleDoubleProperty neto = new SimpleDoubleProperty();
  public SimpleStringProperty fecha = new SimpleStringProperty();
  public SimpleDoubleProperty total = new SimpleDoubleProperty();
  
/**
 * Constructor vacío
 */
  Ventas(){
  }
  
  /**
   * Constructor de la clase
   * @param clave clave del articulo
   * @param nombre nombre del articulo
   * @param descripcion descripcion del articulo
   * @param precioCompra precio de compra del articulo
   * @param existencia existencia en cantidad del articulo
   * @param tipoUnidad tipo de unidad del articulo, pieza, kg, lt
   */
  Ventas(String claveventa, String nombreventa, int cantidad, double precio,
         double neto, double total){
    this.claveventa = new SimpleStringProperty("");
    this.nombreventa = new SimpleStringProperty("");
    this.cantidad = new SimpleIntegerProperty();
    this.precio= new SimpleDoubleProperty();
    this.total = new SimpleDoubleProperty();
    this.neto = new SimpleDoubleProperty();
  }
  
      //getters
  public String getClaveventa(){
    return claveventa.get();
  }
    
  public String getNombreventa(){
    return nombreventa.get();
  }
    
  public int getCantidad(){
    return cantidad.get();
  } 
    
  public double getPrecio(){
    return precio.get();
  }
    
  public double getTotal(){
    return total.get();
  }
  
  public Double getNeto(){
    return neto.get();
  }
  
  public String getFecha() {
    return fecha.get();
  }
    
  //setters
  public void setClaveventa(String claveventa){
    this.claveventa.set(claveventa);
  }
    
  public void setNombreventa(String nombreventa){
    this.nombreventa.set(nombreventa);
  }
    
  public void setCantidad(int cantidad){
    this.cantidad.set(cantidad);
  } 
    
  public void setPrecio(double precio){
    this.precio.set(precio);
  }
    
  public void setTotal(double total){
    this.total.set(total);
  }
  
  public void setNeto(double neto){
    this.neto.set(neto);
  }
  
  public void setFecha(String fecha) {
    this.fecha.set(fecha);
  }
  
  /**
   * métodos property
   * @return 
   */
  public StringProperty claveventaProperty(){
    return claveventa;
  }
  
  public StringProperty nombreventaProperty() {
    return nombreventa;
  }
  
  public IntegerProperty cantidadProperty(){
    return cantidad;
  }
  
  public DoubleProperty precioProperty() {
    return precio;
  }
  
  public DoubleProperty totalProperty() {
    return total;
  }
  
  public DoubleProperty netoProperty() {
    return neto;
  }
  
  public StringProperty fechaProperty() {
    return fecha;
  }
  
}
