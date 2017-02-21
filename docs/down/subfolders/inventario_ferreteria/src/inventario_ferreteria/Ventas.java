/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Ventas {
  private Articulos articulos[] = null;
  private double caja;
  
/**
 * Constructor de la clase ventas
 */
  public Ventas(){
  }

/**
 * Constructor con parametros de la clase ventas
 * @param articulos recibe como parametro los articulos de la  clase Articulos
 */
  public Ventas(Articulos[] articulos){
  this.articulos = articulos;
  }

/**
 * método que muestra todos los articulos del inventario
 * @param articulos recibe como parametro los articulos almacenados
 */
  public void mostrarArticulos(Articulos[] articulos){
    for (Articulos articulo : articulos) {
      System.out.println(articulo + "\n--------------\n");
    }
  }

/**
 * método que muestra solo los nombres de los articulos del inventario
 * @param articulos recibe como parametro los articulos almacenados
 */
  public void mostrarNombres(Articulos[] articulos){
    for(int i = 0; i < articulos.length; i++){
      System.out.println(i+1 +" " + articulos[i].getNombre()+ "\n");
    }
    System.out.println("\n-----------------\n");
  }
  
/**
 * Método encargado de realizar la compra, validando si existe la cantidad
 * suficiente de articulos para realizar la transacción
 * @param articulos recibe como parametro los articulos almacenados
 * @param num indica la posición del articulo 
 * @param cantidad cantidad de articulos que comprará de un solo producto
 * @return regresa el valor de la caja, es decir del total vendido del inventario
 */
  public double comprarArticulo(Articulos[] articulos, int num, int cantidad){
    if(articulos[num-1].isDisponible()){
      if(articulos[num-1].getExistencia()>= cantidad){
        System.out.println("Compra exitosa!\n");
        articulos[num-1].setExistencia(articulos[num-1].getExistencia()-cantidad);
        return caja+= cantidad*articulos[num-1].getPrecioCompra();
      }else{
        System.out.println("No hay cantidad suficiente :(");
      }
    }else{
      System.out.println("No hay cantidad suficiente :(");
    }
    return caja;
  }
  
/**
 * método que realiza las operaciones para mostrar el total entrante en caja 
 * @return regresa el valor de la caja dividido entre 100
 */
  public double mostrarCaja(){
    System.out.println("El total de la caja es: ");
    caja = Math.round(caja*100);
    return caja/100;
  }
}
