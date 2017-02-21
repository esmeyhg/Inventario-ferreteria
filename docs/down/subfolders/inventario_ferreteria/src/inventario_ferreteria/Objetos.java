/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario_ferreteria;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 *
 * @author Esmeralda Yamileth Hernández González
 * @version 0.1
 */
public class Objetos extends ObjectOutputStream{
    
    public Objetos(OutputStream out) throws IOException{
      super(out);
    }
    
    protected Objetos()throws IOException, SecurityException{
      super();
    }
    
    @Override
    protected void writeStreamHeader() throws IOException{
    }
}