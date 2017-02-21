/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.io.IOException;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Registro_datos {
    
/**
 * muestra las opciones que se pueden realizar en el momento 
 */
    
public void menu(){
    System.out.println("******************************************");
    System.out.println("**Inventario Ferretería**");
    System.out.println("1. Agregar un artículo"); 
    System.out.println("2. Eliminar un artículo");
    System.out.println("3. Editar datos de un artículo");
    System.out.println("4. Buscar");
    System.out.println("5. mostrar inventario");
    System.out.println("6. Costo del inventario");
    System.out.println("7. Realizar venta");
    System.out.println("8. Salir");
    System.out.println("******************************************");     
}
    
  /**
   * Pregunta al usuario la opcion que desea del menu y lee la opcion del usuario.
   * @return regresa la opcion introducida por el usuario.
   */
    
  public int leerOpcion(){
    Teclado teclado = new Teclado();
    System.out.println("Elija una opción: ");  
    return teclado.leerEntero(); 
  }
    
  /**
   * De acuerdo al valor recibido, irá realizando las diferentes actividades
   * que ofrece cada metodo al que se esta llamando
   * @param op opcion introducida por el usuario para seleccionar alguna de las actvs. a realizar.
   * @throws java.io.IOException
   */
  public void realizarOpcion(int op) throws IOException{
    Actividades_Inventario actvs = new Actividades_Inventario();
    switch(op){
      case 1:
        actvs.agregarArticulo();
        break;
      case 2: 
        actvs.eliminarArticulo();
        break;
      case 3:
        actvs.editarArticulo();
        break;
      case 4: 
        actvs.buscar();
        break;
      case 5:
        actvs.mostrarInventario();
        break;
      case 6:
        actvs.costoInventario();
        break;
      case 7:
        actvs.vender();
        break;
      case 8:
        System.out.println("GRACIAS POR UTILIZAR EL PROGRAMA ;)");
        break;
      default:
        System.out.println("OPCION INCORRECTA, INGRESE VALOR VÁLIDO");
        break;
    }
  } 
}
