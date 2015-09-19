/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasgenerictp1; // paquete 

import java.io.FileInputStream; // librerías requeridas
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase abrir
 * @author Ricardo Araya
 */
public class abrir implements Serializable{ // nombre de la clase
    
    /**
     * Entrada
     * @param lista de tipo linkedList1
     * No retorna
     */
        
    public void guardar(LinkedList1 lista){ // guardar
        
        try{
            FileOutputStream fout = new FileOutputStream("src\\Imagenes\\LinkedList.ser"); // instanciación
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(lista);
            oos.close();
            return;
        }
        catch(IOException i){
          i.printStackTrace();
        }
    }

    /**
     * 
     * @param ruta
     * @return e LinkedList1
     */
    public LinkedList1 leer(FileInputStream ruta){ // lee la ruta
        LinkedList1 e = new LinkedList1();
        try {
            ObjectInputStream in = new ObjectInputStream(ruta); // instanciación
            e = (LinkedList1) in.readObject();
            in.close();
            ruta.close();
            return e;
        } 
        catch (IOException i) {
            i.printStackTrace();

        } 
        catch (ClassNotFoundException c) {
            System.out.println("Error");
            c.printStackTrace();
        }
        return e;
    }
    
    /**
     * Entrada:
     * @param args
     * Restriccion: @throws FileNotFoundException
     * Void no retorna
     */
    public static void main(String args[]) throws FileNotFoundException{
        abrir e=new abrir();
        
        
        LinkedList1 h=new LinkedList1();
        
        h.append(183);
        h.append(2);
        h.append(3);
        h.append(4);
        h.append(5);
        
        e.guardar(h);
        
        LinkedList1 w=e.leer(new FileInputStream("src\\Imagenes\\LinkedList.ser"));
        System.out.println(w);
        w.next();
        System.out.println(w.getElement());
        w.next();
        System.out.println(w.getElement());
        w.next();
        System.out.println(w.getElement());
    }
}