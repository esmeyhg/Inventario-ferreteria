/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.util.ArrayList;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Actividades_Inventario {
  public static Articulos ObjA;
  public static ArrayList<Articulos> articulos = new ArrayList<>();
  

  private String clave;
  private String nombre;
  private String descripcion;
  private double precioCompra;
  private int existencia;
  private String tipoUnidad;
  
/**
 * método que agregará los artículos en el inventario, pidiendo la clave, el nombre,
 * una breve descripción, el precio de compra, la cantidad y el tipo de unidad, es decir,
 * piezas, kgs, lts, mts
 */  
  public void agregarArticulo(){
    Teclado tec = new Teclado();
    Archivo arch = new Archivo();
    ObjA = new Articulos();
    System.out.println("Clave del artículo: ");
    ObjA.setClave(tec.leerString());
    System.out.println("Nombre del artículo: ");
    ObjA.setNombre(tec.leerString());
    System.out.println("Descripción: ");
    ObjA.setDescripcion(tec.leerString());
    System.out.println("Precio de compra: ");
    ObjA.setPrecioCompra(tec.leerDouble());
    System.out.println("Cantidad en existencia: ");
    ObjA.setExistencia(tec.leerEntero());
    System.out.println("Tipo de Unidad: ");
    ObjA.setTipoUnidad(tec.leerString()); 
     
    articulos.add(ObjA);
    arch.crear("articulos.txt");
  }
  
/**
 * método que modificará la información de alguno de los artículos que se encuentran
 * en el inventario
 */ 
  public void editarArticulo(){
    Teclado tec = new Teclado();
    int op = 0;
    System.out.println("Elemento a modificar: ");
    System.out.println("1. Clave");
    System.out.println("2. Nombre");
    System.out.println("3. Descripción");  
    System.out.println("4. Precio");
    System.out.println("5. Existencia");
    System.out.println("6. Tipo de unidad");
    op = tec.leerEntero();
    
    switch(op){
      case 1: 
        editarClave();
        break;
      case 2:
        editarNombre();
        break;
      case 3:
        editarDescripcion();
        break;
      case 4:
        editarPrecio();
        break;
      case 5:
        editarExistencia();
        break;
      case 6:
        editarUnidad();
        break;
      default:
        System.out.println("ERROR DE OPCION :/");
        break;
    } 
  }
  
/**
 * método encargado de modifcar el valor de la clave según la que ingrese el usuario
 */
  public void editarClave(){ 
    Teclado tec = new Teclado();
    System.out.println("Clave anterior: ");
    String folio = tec.leerString();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getClave().equalsIgnoreCase(folio)){
        System.out.println("Nueva Clave: ");
        String newFolio = tec.leerString();
        articulo.setClave(newFolio);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    }
  }
  
/**
 * método encargado de modifcar el valor del nombre del articulo según el
 * que ingrese el usuario
 */
  public void editarNombre(){ 
    Teclado tec = new Teclado();
    System.out.println("Nombre anterior: ");
    String nomb = tec.leerString();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getNombre().equalsIgnoreCase(nomb)){
        System.out.println("Nuevo nombre: ");
        String newName = tec.leerString();
        articulo.setNombre(newName);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    }
  }
  
/**
 * método encargado de modificar la descripción existente por la nueva ingresada
 * por el usuario
 */
  public void editarDescripcion(){
    Teclado tec = new Teclado();
    System.out.println("Descripción anterior: ");
    String desc = tec.leerString();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getDescripcion().equalsIgnoreCase(desc)){
        System.out.println("Nueva descripción: ");
        String newDesc = tec.leerString();
        articulo.setDescripcion(newDesc);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    }
  }
  
/**
 * método encargado de modificar el costo del artículo por el nuevo que ingrese
 * el usuario
 */
  public void editarPrecio(){
    Teclado tec = new Teclado();
    System.out.println("Precio anterior: ");
    double precio = tec.leerDouble();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getPrecioCompra()== precio){
        System.out.println("Nuevo precio: ");
        double newPrecio = tec.leerDouble();
        articulo.setPrecioCompra(newPrecio);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    }
  }
  
/**
 * método encargado de modificar la cantidad de artículos existentes de acuerdo a 
 * el artículo seleccionado por el usuario
 */
  public void editarExistencia(){
    Teclado tec = new Teclado();
    System.out.println("Existencia anterior: ");
    int cantidad = tec.leerEntero();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getExistencia()== cantidad){
        System.out.println("Nueva existencia: ");
        int newCant = tec.leerEntero();
        articulo.setExistencia(newCant);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    }
    
  }
  
/**
 * método encargado de modficiar el tipo de unidad del artículo seleccionado por 
 * el usuario
 */
  public void editarUnidad(){
    Teclado tec = new Teclado();
    System.out.println("Tipo de unidad anterior: ");
    String unidad = tec.leerString();
    for(Object objeto : articulos){
      Articulos articulo = (Articulos) objeto;
      if(articulo.getTipoUnidad().equalsIgnoreCase(unidad)){
        System.out.println("Nuevo tipo de unidad: ");
        String newUnidad = tec.leerString();
        articulo.setTipoUnidad(newUnidad);
      }
    }
    for(Object objeto: articulos){
      Articulos articulo = (Articulos) objeto;
      mostrarInventario();
    } 
  }
  
/**
 * método que eliminará por completo alguno de los productos o artículos que se encuentran
 * en el inventario
 */
  public void eliminarArticulo(){
    Teclado tec = new Teclado();
    mostrarInventario();
    System.out.println("Clave del artículo a eliminar: ");
    String codigo = tec.leerString();
    int indice = 0;
    boolean encontrado = false;
    
    if(articulos.size() >=indice){
      while((indice <= articulos.size())|| (encontrado==false)){
        if(articulos.get(indice).getClave() == null ? codigo == null : articulos.get(indice).getClave().equals(codigo)){
          articulos.remove(indice);
          encontrado = true;
        }
        indice++;
      }
      if(encontrado == false){
        System.out.println("Clave incorrecta!");
      }
    }else{
      System.out.println("Lista vacía");
    }
  }

/**
 * método encargado de desplegar un menú de busqueda según el tipo de
 * busqueda que el usuario desee realizar
 */
  public void buscar(){
    Teclado tec = new Teclado();
    int op = 0;
    System.out.println("método de búsqueda: ");
    System.out.println("1. Búsqueda por clave");
    System.out.println("2. Búsqueda por nombre");
    System.out.println("3. Búsqueda por descripción"); 
    op = tec.leerEntero();
    
    switch(op){
      case 1: 
        buscarClave();
        break;
      case 2:
        buscarNombre();
        break;
      case 3:
        buscarDescripcion();
        break;
      default:
        System.out.println("ERROR DE OPCION :/");
        break;
    }
  }
  
/**
 *método que buscará dentro del inventario la clave que el usuario proporcioné 
 * y lo imprimirá en consola
 */
  public void buscarClave(){
    Teclado tec = new Teclado();
    String clav;
    System.out.println("Ingrese la clave del artículo: ");
    clav = tec.leerString();
    for(int i = 0; i < articulos.size(); i++){
      if(articulos.get(i).getClave() == null ? clav == null : articulos.get(i).getClave().equals(clav)){
        System.out.println(articulos.get(i));
      }
    }
  }
  
/**
 * método que buscará dentro del inventario el nombre que el usuario ingrese en el
 * sistema
 */
  public void buscarNombre(){
    Teclado tec = new Teclado();
    String name;
    System.out.println("Ingrese el nombre del artículo: ");
    name = tec.leerString();
    for(int i = 0; i < articulos.size();i++){
      if(articulos.get(i).getNombre() == null ? name == null : articulos.get(i).getNombre().equals(name)){
        System.out.println(articulos.get(i));
      }
    }
  }
  
/**
 * método que buscará dentro del invnetario la descripción que el usuario ingrese en 
 * el sistema y lo imprimirá en consola
 */
  public void buscarDescripcion(){
    Teclado tec = new Teclado();
    String desc;
    System.out.println("Ingrese la descripción del artículo: ");
    desc = tec.leerString();
    for(int i = 0; i < articulos.size();i++){
      if(articulos.get(i).getDescripcion() == null ? desc == null : articulos.get(i).getDescripcion().equals(desc)){
        System.out.println(articulos.get(i));
      }
    }
  }
  
/**
 * método que mostrará toda la información del inventario
 */
  public void mostrarInventario(){
    for(int i = 0; i < articulos.size(); i++){
      System.out.println(articulos.get(i));
      System.out.println("-----------------------------");
      
    }
  }
/**
 * método que muestra todo el valor del inventario
 */
  public void costoInventario(){
    
  }

/**
 * método que realizar la venta de uno o varios artículos del inventario
 */
  public void vender(){
    Articulos[] articulos = new Articulos[Articulos.dimensionArray];
    Ventas venta = new Ventas();
    Teclado tec = new Teclado();
    
   System.out.println("Numero del artículo: " );
   mostrarInventario();
   int nomb = tec.leerEntero();
   System.out.println("Cantidad: ");
   int cantidad = tec.leerEntero();
   
   venta.comprarArticulo(articulos, nomb, cantidad);
  }
}
