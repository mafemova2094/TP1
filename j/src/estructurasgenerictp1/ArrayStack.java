/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1; // nombre del paquete

import java.util.ArrayList;

/**
 * Pila basada en arreglos
 * @author Mau
 */
public class ArrayStack <T> { // pila basada en arreglos genérico de tipo T
    private ArrayList <T> arreglo=new ArrayList <T>();  // Atributos, es una instanciación de un arreglo
    private int size; // atributo
    
    // constructor
    
    public ArrayStack (){
        size=0;
    }
    
    // métodos
        
    /**
     * Agrega un elemento  en el top de la pila.
     * @param element de tipo T
     */
    
    public void push(T element){
        arreglo.add(element);
        size++;
    }
    
    /**
     * Elimina y regresa el elemento en el top de la pila
     * @return un elemento de tipo T
     */
    
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
    
    /**
     * Regresa el elemento en el top de la pila
     * @return un elemento de tipo T
     */
        
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

    /**
     * No recibe ningún parámetro como entrada
     * @return Regresa el número de elementos en la pila
     */
    
    public int size(){
        return size;
    }
    
    /**
     * Restricciones: True si está vacío y False si está con elementos
     * @return un booleano si está vacía o sino 
     * No recibe ningún parámetro como entrada
     */
    
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * vacía la pila
     * No recibe ningun elemento como entrada
     */
    
    public void clear(){
        ArrayList <T> nuevo=new ArrayList <T>(); // instanciación del arraylist
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
