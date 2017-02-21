/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.io.IOException;

/**
 *
 * @author Esmerlada Yamileth Hernández González
 * @version 0.1
 */
public class Inventario_ferreteria {

  /**
   * @param args the command line arguments
   */
  
    public static void main(String[] args) throws IOException {
      Registro_datos msn = new Registro_datos();
      int op=0;
  /**
  * permitira ir mostrando el menu al usuario hasta que él decida la opcion de salir (9).
  */
  do{
    msn.menu();
    op=msn.leerOpcion();
    msn.realizarOpcion(op);
  }while(op!=8);
    } 
}
