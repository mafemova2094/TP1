/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasdedatos;

import java.util.ArrayList;

/**
 *
 * @author Mau
 */
public class ArrayStack <T> {
    private ArrayList <T> arreglo=new ArrayList <T>();  // Atributos, es una instanciación de un arreglo
    private int size;
    
    // constructor
    
    public ArrayStack (){
        size=0;
    }
    
    // métodos
    
    public void push(T element){
        arreglo.add(element);
        size++;
    }
    
    public T pop(){
        if (arreglo==null){
            System.out.println("Stack vacío");
            return null;                    
        }
        else{
            T temp=arreglo.get(size-1);
            arreglo.remove(size-1);
            this.size--;
            return temp;            
        }
    }
    
    public T top(){
        if (size==0){
            System.out.println("Stack vacío");
            return null;                    
        }
        else{
            T temp=arreglo.get(size-1);
            return temp;            
        }
    }   

    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void clear(){
        ArrayList <T> nuevo=new ArrayList <T>();
        arreglo=nuevo;
        System.out.println(arreglo.size());
        size=0;
    }
    
    public static void main (String args []){
        ArrayStack arreglo=new ArrayStack();
        arreglo.push(5);
        arreglo.push(4);
        arreglo.pop();
        System.out.println(arreglo.pop());
        arreglo.push(7);
        arreglo.top();
        System.out.println(arreglo.top());
        System.out.println(arreglo.size());
        System.out.println(arreglo.isEmpty());
        arreglo.clear();
        System.out.println(arreglo.top());
    }
}
