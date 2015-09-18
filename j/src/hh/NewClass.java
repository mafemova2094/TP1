/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hh;

/**
 *
 * @author Mau
 */
public class NewClass <T,Z>{
    private T casa;
    private Z perro;
    
    public void setT(T casa){
      
      this.casa = casa;  
      System.out.println(this.casa);
        
    }
    
    public void setZ(Z perro){
        
      this.perro = perro;  
      System.out.println(this.perro);
        
    }
}
