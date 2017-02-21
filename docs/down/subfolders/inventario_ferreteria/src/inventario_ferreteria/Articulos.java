/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.io.Serializable;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 */
public class Articulos implements Serializable {
  private String clave;
  private String nombre;
  private String descripcion;
  private double precioCompra;
  private int existencia;
  private String tipoUnidad;
  private boolean disponible = false;
  public static int dimensionArray;
  
/**
 * Constructor vacío
 */
  Articulos(){
  }
  
  /**
   * Constructor
   * @param nombre nombre del articulo
   * @param descripcion descripcion del articulo
   */
  Articulos(String nombre, String descripcion){
    this.nombre = nombre;
    this.descripcion = descripcion;
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
  Articulos(String clave, String nombre, String descripcion, double precioCompra, int existencia, String tipoUnidad, boolean disponible){
    this.clave = clave;
    this.descripcion = descripcion;
    this.existencia = existencia;
    this.nombre = nombre;
    this.precioCompra = precioCompra;
    this.tipoUnidad = tipoUnidad;
    this.disponible = disponible;
    
    dimensionArray++;
  }
  
      //getters
    public String getClave(){
        return clave;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public double getPrecioCompra(){
      return precioCompra;
    } 
    public int getExistencia(){
      return existencia;
    }
    public String getTipoUnidad(){
      return tipoUnidad;
    }
    public boolean isDisponible(){
      if(getExistencia()>0) this.disponible = true;
      return this.disponible;
    }
    
    //setters
    public void setClave(String clave){
        this.clave = clave;
    }
    public void setNombre(String nombre){
       this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
       this.descripcion = descripcion;
    }
    public void setPrecioCompra(double precioCompra){
      this.precioCompra = precioCompra;
    } 
    public void setExistencia(int existencia){
      this.existencia = existencia;
    }
    public void setTipoUnidad(String tipoUnidad){
      this.tipoUnidad = tipoUnidad;
    }
    public void setDisponible(boolean disponible){
      this.disponible = disponible;
    }
    
/**
 * método que guarda las cadenas de texto 
 * @return regresa los valores convertidos en cadenas
 */
    @Override
    public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append("\nClave: ");
      sb.append(clave);
      sb.append("\nNombre: ");
      sb.append(nombre);
      sb.append("\nDescripción: ");
      sb.append(descripcion);
      sb.append("\nPrecio Compra: ");
      sb.append(precioCompra);
      sb.append("\nExistencia: ");
      sb.append(existencia);
      sb.append("\nTipo de Unidad: ");
      sb.append(tipoUnidad);
      return sb.toString();
      
    }
}
