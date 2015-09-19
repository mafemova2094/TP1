/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estructurasgenerictp1;


/**
 *
 * @author Mau
 */
public class LQueue <T> extends LinkedList <T> {
    
    // atributos
    
    private Node <T> front;
    private Node <T> rear;
    private int size;
    
    // constructor
    
    public LQueue (){
        this.front=new Node<>();
        this.rear=this.front;
        this.size=0;
    }
        
    //métodos
    
    /**
     * Agrega un elemento al final de la cola
     * @param element de tipo T
     */
    
    public void enqueue (T element){
        Node <T> temp=new Node<>(element,rear.getNext());
        this.rear.setNext(temp);
        this.rear=this.rear.getNext(); //También se puede escribir this.rear=temp;
        this.size++;
    }
    
    /**
     * Elimina y regresa el primer elemento de la cola
     * @return el primer elemento de la cola 
     */
    
    public T dequeue (){
        if (this.size==0){
            System.out.println("Cola vacía");
            return null;
        }
        else{
          T temp=this.front.getNext().getElement();
          this.front.setNext(this.front.getNext().getNext());
          this.size--;
          return temp;
        }
    }
    
    /**
     * No recibe ningún parámetro como entrada
     * @return Regresa el primer elemento de la cola de tipo T
     */
    
    public T first(){
        if (this.size==0){
            System.out.println("Cola vacía");
            return null;
        }
        else{
            return this.front.getNext().getElement();
        }
    }
    
    /**
     * No recibe ningún parámetro como entrada
     * @return size de tipo int Regresa el número de elementos en la cola
     */
    
    public int size(){
        return this.size;
    }
    
    /**
     * No recibe ningún parámetro como entrada
     * @return Retorna un booleano indicando si la cola esta vacía
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
     * Vacía la cola
     * No recibe ningún parámetro como entrada
     * Void no retorna
     */
    
    public void clear(){
        this.front=new Node<>();
        this.rear=this.front;
        this.size=0;
    }
    
    public static void main(String args[]){
        LQueue cola=new LQueue<>();
        cola.enqueue(5);
        cola.enqueue(6);
        cola.enqueue(7);
        cola.enqueue(8);
        System.out.println(cola.dequeue());
        cola.enqueue(4);
        System.out.println(cola.first());
        System.out.println(cola.size());
        System.out.println(cola.isEmpty());
        cola.clear();
        System.out.println(cola.size());
        System.out.println(cola.isEmpty());
    }
}
