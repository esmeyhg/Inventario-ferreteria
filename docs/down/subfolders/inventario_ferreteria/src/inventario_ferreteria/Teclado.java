/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario_ferreteria;

import java.util.Scanner;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Teclado {
  private Scanner sc;
/**
 * Inicializa nuestro objeto Scanner con la entrada estandar que es la lectura del teclado
 */
    
public Teclado(){
  sc = new Scanner(System.in);
}
    
/**
 * 
 * @return regresa la lectura de un valor entero
 */
    
public int leerEntero(){
  return sc.nextInt();
}
/**
 * 
 * @return regresa la lectura de un valor double
 */
    
public double leerDouble(){
  return sc.nextDouble();
}

/**
 * 
 * @return regresa la lectura de un valor String 
 */
public String leerString(){
  return sc.next();
}

public String leerStr(){
  return sc.nextLine();
}
    
    
}
