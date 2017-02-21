/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Archivo {
  public static ArrayList<Articulos> articulos = new ArrayList<>();
  
  
/**
 * método que crea un fichero 
 * @param fichero recibe el fichero con el contenido de los artículos
 */
  public void crear(String fichero){
    try{
      ObjectOutputStream oos = new ObjectOutputStream(
          new FileOutputStream(fichero));
      for (int i = 0; i <articulos.size(); i++){
        Articulos p = new Articulos();
        oos.writeObject(p);
      }
      oos.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }

/**
 * método que añade al fichero información de los artículos
 * @param fichero recibe como parametro el contenido del fichero
 */
  public void anhadeFichero (String fichero){
    try{
      Objetos oos = new Objetos(
      new FileOutputStream(fichero,true));
      Articulos p = new Articulos();
      for (int i = 5; i < articulos.size(); i++){
        oos.writeUnshared(p);
      }
      oos.close();
    } catch (Exception e){
      e.printStackTrace();
    }
  }
  
/**
 * método que lee el contenido del fichero creado anteriormente
 * @param fichero recibe como parametro el contenido del fichero
 */
  public void leeFichero(String fichero){
    try{
      ObjectInputStream ois = new ObjectInputStream(
      new FileInputStream(fichero));
      Object aux = ois.readObject();
      while (aux!=null){
        if (aux instanceof Articulos)
          System.out.println(aux);
        aux = ois.readObject();
      }
      ois.close();
    }catch (EOFException e1){
      System.out.println ("Fin de fichero");
    }catch (Exception e2){
      e2.printStackTrace();
    }
  }
}

