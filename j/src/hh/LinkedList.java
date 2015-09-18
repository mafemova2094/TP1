/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hh;

/**
 * Se implementa una lista simple
 * @author Mau
 */
public class LinkedList <T>{ // LinkedList es genérico de tipo T
    
    public class Node <E> { // Clase nodo de  tipo E
        //atributos
        private E element; // Elemento de tipo E
        private Node<E> next; // Nodo de tipo E
        
        public Node (){
            this.element=null; //nodo especial
            this.next=null;
        }
        
        public Node (E element){ // nodo que recibe un elemento de tipo E
            this.element=element;
            this.next=null;
        }
        
        public Node (E element, Node<E> next){ // nodo que recibe un elemento de tipo E, y dos punteros
            this.element=element;
            this.next=next;
        }
        
        //métodos 
        public E getElement(){ // consultar un elemento
            return this.element;
        }
        
        public void setElement (E element){ //Actualiza un elemento. Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.element=element; 
            
        }
         public Node<E> getNext(){ // Obtiene el siguiente elemento
            return this.next;
        }
        
        public void setNext (Node<E> next){ //Por ser un void no se devuelve nada. Se recibe un elemento de tipo E como parámetro.
            this.next=next; 
            
        }
      
    }
    private Node <T> head; // indica la cabeza del nodo
    private Node <T> current; // puntero actual del nodo
    private Node <T> tail; // indica la cola del nodo
    private int size; // indica el tamaño 
    private int pos; // indica la posición
    
    //constructores
    
    public LinkedList (){ // nodo especial en el cual el current es igual al tail y a la cabeza
        this.head=new Node<>();
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    //métodos
    
    /**
     * Inserta un elemento. Crea un nuevo nodo para poderlo insertar en el current
     * @param element debe ser de tipo T
     */
    
    public void insert (T element){
        Node temp=new Node<>(element);
        temp.setNext(current.getNext()); 
        this.current.setNext(temp);
        if (this.current==this.tail){
           this.tail=this.current.getNext();
        }
        size++;
    }
    
    /**
     * Concatena un elemento en la lista doblemente enlazada. Se concatena al final.
     * @param element debe ser de tipo T
     */
    
    public void append (T element){
        if (size==0){
            Node temp=new Node<>(element);
            this.head.setNext(temp);
            this.current=this.head;
            this.tail=this.tail.getNext();
            size++;
           }
        else{
            Node temp=new Node<>(element);
            this.tail.setNext(temp);
            this.tail=this.tail.getNext();
            size++;
        }
        
    }
    
    /**
     * Obtiene el elemento
     * @return el elemento que está en el current
     */
    
    public T getElement(){
        try{
            return (T)this.current.getElement(); // Hay que convertirlo ya que son de diferente tipo uno es E y el otro T
        }
        catch(NullPointerException ex){ // Si es un puntero al final y está vacío, nos tira error si solicitamos el elemento 
            return null;
        }
    }
    
    /**
     * elimina un elemento
     */
    
    public void remove(){
       if (size==0){
           System.out.println("Lista vacía");
           return;
       }
       Node temp=head;
       while(temp.getNext()!=current){
           temp=temp.getNext();
       }
       temp.setNext(this.current.getNext());
       if (current==tail){
          this.current=this.tail=temp;
          this.pos--;
       }
       else{
           this.current=temp;
           this.pos--;
       }
       size--;
    }
    
    /**
     * Modifica el elemento
     * @param element de tipo T
     */
    
    public void updateElement(T element){
        this.current.setElement(element);
        
    }
    
    /**
     * Vacía la lista
     */
    
    public void clear(){
        this.head.setNext(null);
        this.current=head;
        this.tail=head;
        this.pos=-1;
        this.size=0;
    }
    
    /**
     *
     * ir al elemento siguiente
     */
    
    public void next(){
           this.current=this.current.getNext(); 
           this.pos++;         
    }
    
    /**
     *
     * ir al elemento anterior
     */
    
    public void previous(){
        Node temp=head;
        while(temp.getNext()!=current){
           temp=temp.getNext();
       }
        this.current=temp;
        this.pos--;
    }
    
    /**
     *
     * @return el tamaño
     */
    
    public int getSize(){
       return this.size;
    }
    
    /**
     *
     * @return la posición
     */
    
    public int getPos(){
        return this.pos;
    }
    
    /**
     * mover al principio de la lista
     */
    
    public void goToStart(){
        this.current=this.head;
        this.pos=-1;
    }
    
    /**
     * mover al final de la lista
     */
    
    public void goToEnd(){
        this.current=this.tail;
        this.pos=size-1;
    }
    
    /**
     * 
     * @return booleano, para saber si la lista está vacía o no 
     */
    
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void main(String [] args){
        System.out.println("*LinkedList**");
        System.out.println("*AgregandoALinkedList**");
        LinkedList lista=new LinkedList<>();
        lista.append(4);
        lista.append(1);
        lista.append(3);
        System.out.println(lista.getElement());
        System.out.println(lista.getSize());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.next();
        System.out.println(lista.getElement());
        lista.previous();
        lista.remove();
        System.out.println(lista.getElement());
        System.out.println(lista.getPos());
        System.out.println(lista.isEmpty());
        lista.previous();
        lista.insert(5);
        lista.next();
        System.out.println(lista.getElement());
        System.out.println(lista.getSize());
        lista.goToStart();
        System.out.println(lista.getPos());
        lista.goToEnd();
        System.out.println(lista.getPos());
    }
            
}
